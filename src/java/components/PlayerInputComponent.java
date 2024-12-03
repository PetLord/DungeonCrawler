package components;

import gameWindow.GamePanel;
import java.awt.event.KeyListener;

public class PlayerInputComponent {
    private final MovementComponent movementComponent;
    private final KeyListener keylistener;
    private GamePanel gamePanel;

    public PlayerInputComponent(MovementComponent movementComponent, GamePanel gamePanel) {
        this.movementComponent = movementComponent;
        this.keylistener = new PlayerInputListener(movementComponent);
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
