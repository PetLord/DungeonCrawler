package windows.panels.gamePanel;

import windows.panels.CustomPanel;
import windows.panels.gamePanel.components.GraphicsComponent;
import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.objects.Entity;
import windows.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends CustomPanel implements Runnable {
    private final int originalWidth;
    private final int originalHeight;
    private final int virtualWidth = 1200;  // 4:3 virtual width
    private final int virtualHeight = 900; // 4:3 virtual height
    private final double blackBoxScale = 0.1;
    private int actualWidth;
    private int actualHeight;
    private int offsetX;
    private int offsetY;

    private Thread gameThread;
    private final GameWorld gameWorld;

    public GamePanel(MainFrame mainFrame) {
        super(mainFrame);
        originalWidth = mainFrame.getWidth();
        originalHeight = mainFrame.getHeight();
        this.actualWidth = mainFrame.getWidth();
        this.actualHeight = mainFrame.getHeight();

        this.setPreferredSize(new Dimension(actualWidth, actualHeight));
        this.setFocusable(true);

        calculateLetterboxing();
        gameWorld = new GameWorld(this, (int)(actualWidth * (1 - blackBoxScale)), (int) (actualHeight * 0.8));
        //gameWorld = new GameWorld(this, (int)(actualWidth * (1 - blackBoxScale)), (int) (actualHeight * ( 1 - blackBoxScale)));
        this.setBackground(Color.BLACK);
        startGameThread();
    }

    @Override
    public void onPanelActivation() {
        SwingUtilities.invokeLater(this::requestFocusInWindow);
        //requestFocusInWindow();
        //requestFocus();
    }

    @Override
    public void onPanelDeactivation() {

    }

    private void calculateLetterboxing() {
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

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final double maxUpdatesPerSecond = 60.0;
        final double updateInterval = 1_000_000_000.0 / maxUpdatesPerSecond; // In nanoseconds
        long lastUpdateTime = System.nanoTime();

        while (gameThread != null) {
            long currentTime = System.nanoTime();
            double elapsedTime = currentTime - lastUpdateTime;

            // Update based on elapsed time
            if (elapsedTime >= updateInterval) {
                update();
                lastUpdateTime = currentTime;
            }

            // Render as often as possible
            repaint();

            // Small sleep to prevent CPU overuse
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void update() {
        if(gameWorld.getCurrentRoom().getEntities() == null){
            return;
        }

        for (Entity entity : gameWorld.getCurrentRoom().getEntities()) {
            if (entity.hasComponent(MovementComponent.class)) {
                MovementComponent movement = entity.getComponent(MovementComponent.class);
                if (movement != null) {
                    movement.updatePosition(entity);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameWorld == null || gameWorld.getCurrentRoom() == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        g2.translate(offsetX, offsetY);

        gameWorld.getCurrentRoom().render(g2);

        for (Entity entity : gameWorld.getCurrentRoom().getEntities()) {
            if (entity.hasComponent(GraphicsComponent.class)) {
                entity.render(g2);
            }
        }
    }

    public int getOriginalWidth() {
        return originalWidth;
    }

    public int getOriginalHeight() {
        return originalHeight;
    }

    public int getVirtualWidth() {
        return virtualWidth;
    }

    public int getVirtualHeight() {
        return virtualHeight;
    }

    public int getActualWidth() {
        return actualWidth;
    }

    public int getActualHeight() {
        return actualHeight;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }
}