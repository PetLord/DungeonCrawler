package components;

import gameWindow.GamePanel;
import objects.Entity;

import java.awt.event.KeyListener;

public class PlayerInputComponent {
    private final Entity entity;
    private final KeyListener keylistener;
    private GamePanel gamePanel;

    public PlayerInputComponent(Entity entity, GamePanel gamePanel) {
        this.entity = entity;
        this.keylistener = new PlayerInputListener(entity);
        this.gamePanel = gamePanel;
        gamePanel.addKeyListener(keylistener);
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void addKeyListener() {
        gamePanel.addKeyListener(keylistener);
    }
}
