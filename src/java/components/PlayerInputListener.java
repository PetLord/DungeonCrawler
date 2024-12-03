package components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PlayerInputListener implements KeyListener {
    private final MovementComponent movementComponent;
    private final Set<Integer> activeKeys = new HashSet<>();

    public PlayerInputListener(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        activeKeys.add(key);
        updateMovement();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        activeKeys.remove(key);
        updateMovement();
    }

    private void updateMovement() {
        int vx = 0, vy = 0;
        boolean sprinting = false;

        if (activeKeys.contains(KeyEvent.VK_W) && !activeKeys.contains(KeyEvent.VK_S)) vy = -1;
        if (activeKeys.contains(KeyEvent.VK_S) && !activeKeys.contains(KeyEvent.VK_W)) vy = 1;
        if (activeKeys.contains(KeyEvent.VK_A) && !activeKeys.contains(KeyEvent.VK_D)) vx = -1;
        if (activeKeys.contains(KeyEvent.VK_D) && !activeKeys.contains(KeyEvent.VK_A)) vx = 1;
        if (activeKeys.contains(KeyEvent.VK_SHIFT)) sprinting = true;

        movementComponent.setVelocity(vx, vy);

        if (sprinting) {
            movementComponent.sprint();
        } else {
            movementComponent.walk();
        }
    }
}
