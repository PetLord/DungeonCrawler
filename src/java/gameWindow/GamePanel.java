package gameWindow;
import components.GraphicsComponent;
import objects.Entity;
import components.MovementComponent;
import objects.characters.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private final int screenWidth;
    private final int screenHeight;
    private Thread gameThread;
    private GameWorld gameWorld;

    public GamePanel() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenDimension.getWidth();
        screenHeight = (int) screenDimension.getHeight();
        this.setPreferredSize(screenDimension);
        setFocusable(true);
        requestFocusInWindow();
        gameWorld = new GameWorld(this, screenWidth, screenHeight);

        this.setBackground(Color.BLACK);
        startGameThread();
    }

    void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            update();
            repaint();
            try {
                Thread.sleep(16);  // Approximately 60 FPS (1000 ms / 60)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void update() {
        for (Entity entity : gameWorld.getEntities()) {
            if(entity instanceof Player) {
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
        Graphics2D g2 = (Graphics2D) g;

        for (Entity entity : gameWorld.getEntities()) {
            if (entity.hasComponent(GraphicsComponent.class)) {

                GraphicsComponent graphics = entity.getComponent(GraphicsComponent.class);
                graphics.render(g2, entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
            }
        }

        g2.dispose();
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void addEntity(Entity entity){
        gameWorld.addEntity(entity);
        entity.setGamePanel(this);
    }
}
