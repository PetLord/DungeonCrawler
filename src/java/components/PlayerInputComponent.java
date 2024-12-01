package components;

import gameWindow.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInputComponent {
    private final MovementComponent movementComponent;
    private final KeyListener keylistener;
    private static final double ACCELERATION = 1.5;
    public PlayerInputComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
        this.keylistener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // empty
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_W) {
                    movementComponent.increaseAy(-ACCELERATION);
                }
                if (key == KeyEvent.VK_S) {
                    System.out.println("S detected");
                    movementComponent.increaseAy(ACCELERATION);
                }
                if (key == KeyEvent.VK_A) {
                    movementComponent.increaseAx(-ACCELERATION);
                }
                if (key == KeyEvent.VK_D) {
                    movementComponent.increaseAx(ACCELERATION);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
                    movementComponent.setAy(0);
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                    movementComponent.setAx(0);
                }
            }
        };
    }

    public void addKeyListener(GamePanel gamePanel) {
        gamePanel.addKeyListener(keylistener);
    }
}
