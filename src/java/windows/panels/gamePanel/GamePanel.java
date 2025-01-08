package windows.panels.gamePanel;

import windows.panels.CustomPanel;
import windows.panels.PanelType;
import windows.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends CustomPanel implements Runnable {
    private final int virtualWidth = 1200;  // 4:3 virtual width
    private final int virtualHeight = 900; // 4:3 virtual height
    private int actualWidth;
    private int actualHeight;
    private final double blackBoxScale = 0.1;
    private int offsetX;
    private int offsetY;

    private Thread gameThread;
    private volatile boolean isPaused = false;
    private volatile boolean running = false;
    private GameWorld gameWorld;

    public GamePanel(MainFrame mainFrame) {
        super(mainFrame);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        calculateLetterboxing();
    }

    @Override
    public void onPanelActivation(PanelType previousPanelType) {
        switch (previousPanelType) {
            case MAIN_MENU:
                startGame();
                break;
            case OPTIONS_MENU:
                continueGameThread();
                break;
        }
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    @Override
    public void onPanelDeactivation(PanelType newPanelType) {
        switch (newPanelType) {
            case MAIN_MENU, GAME_OVER:
                exitGame();
                break;
            case OPTIONS_MENU:
                pauseGameThread();
                break;
        }
    }

    private void calculateLetterboxing() {
        this.actualWidth = mainFrame.getWidth();
        this.actualHeight = mainFrame.getHeight();
        double targetAspectRatio = (double) virtualWidth / virtualHeight;
        double actualAspectRatio = (double) actualWidth / actualHeight;

        int letterboxedWidth = actualWidth;
        int letterboxedHeight = actualHeight;
        if (actualAspectRatio > targetAspectRatio) {
            // Screen is wider than 4:3, add bars on the sides
            letterboxedWidth = (int) Math.round(actualHeight * targetAspectRatio);
            offsetX = (actualWidth - letterboxedWidth) / 2;
            offsetY = 0;
        } else if (actualAspectRatio < targetAspectRatio) {
            // Screen is taller than 4:3, add bars on top and bottom
            letterboxedHeight = (int) Math.round(actualWidth / targetAspectRatio);
            offsetY = (actualHeight - letterboxedHeight) / 2;
            offsetX = 0;
        } else {
            offsetX = 0;
            offsetY = 0;
        }

        offsetX += (int) (mainFrame.getWidth() * blackBoxScale / 2);
        offsetY += (int) (mainFrame.getHeight() * blackBoxScale / 2);
        actualWidth = letterboxedWidth;
        actualHeight = letterboxedHeight;
    }

    @Override
    public void run() {
        final double maxUpdatesPerSecond = 60.0;
        final double updateInterval = 1_000_000_000.0 / maxUpdatesPerSecond;
        long lastUpdateTime = System.nanoTime();

        while (running) {
            if (isPaused) {
                try {
                    Thread.sleep(100); // Sleep briefly while paused
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long currentTime = System.nanoTime();
            if (currentTime - lastUpdateTime >= updateInterval) {
                update();
                lastUpdateTime = currentTime;
            }

            repaint();

            try {
                Thread.sleep(1); // Small sleep to prevent CPU overuse
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        if (gameWorld == null || gameWorld.getCurrentRoom() == null || gameWorld.getCurrentRoom().getAliveCharacters() == null) {
            return;
        }

        gameWorld.getCurrentRoom().update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameWorld == null || gameWorld.getCurrentRoom() == null) {
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(offsetX, offsetY);
        gameWorld.render(g2);
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    @Override
    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
        calculateLetterboxing();
        if(gameWorld != null){
            gameWorld.setDimensions((int) (actualWidth * (1 - blackBoxScale)), (int) (actualHeight * 0.8));
        }

    }

    public void onEscapePressed() {
        pauseGameThread();
        mainFrame.switchToPanel(PanelType.OPTIONS_MENU);
    }

    public void startGameThread() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void pauseGameThread() {
        isPaused = true;
    }

    private void continueGameThread() {
        isPaused = false;
    }

    public void startGame() {
        //isPaused = false;
        //running = false;
        if (gameWorld == null) {
            gameWorld = new GameWorld(this, (int) (actualWidth * (1 - blackBoxScale)), (int) (actualHeight * 0.8));
        }
    }

    public void exitGame() {
        stopGameThread();
        gameWorld = null;
    }

    private void stopGameThread() {
        running = false;
        try {
            if (gameThread != null) {
                gameThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameThread = null;
    }

    public void gameOver() {
        mainFrame.switchToPanel(PanelType.GAME_OVER);
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }
}
