package windows.panels.gamePanel.inputHandling;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.entities.characters.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PlayerKeyboardListener implements KeyListener {
    private final GamePanel gamePanel;
    private final Player player;
    private final Set<Integer> activeKeys = new HashSet<>();

    public PlayerKeyboardListener(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            gamePanel.onEscapePressed();
        } else if (activeKeys.add(key)) { // Add key only if it's not already present
            updateMovement();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (activeKeys.remove(key)) { // Remove key only if it was active
            updateMovement();
        }
    }

    private void updateMovement() {
        if(!player.hasComponent(MovementComponent.class)) {
            return;
        }

        int vx = 0, vy = 0;

        if (activeKeys.contains(KeyEvent.VK_W)) vy -= 1;
        if (activeKeys.contains(KeyEvent.VK_S)) vy += 1;
        if (activeKeys.contains(KeyEvent.VK_A)) vx -= 1;
        if (activeKeys.contains(KeyEvent.VK_D)) vx += 1;

        MovementComponent movementComponent = player.getComponent(MovementComponent.class);

        movementComponent.setVx(vx);
        movementComponent.setVy(vy);

        if (activeKeys.contains(KeyEvent.VK_SHIFT)) {
            movementComponent.sprint();
        } else {
            movementComponent.walk();
        }
    }

}
