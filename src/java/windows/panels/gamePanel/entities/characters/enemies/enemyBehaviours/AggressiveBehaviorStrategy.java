package windows.panels.gamePanel.entities.characters.enemies.enemyBehaviours;

import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.characters.enemies.Enemy;

import java.awt.geom.Point2D;

public class AggressiveBehaviorStrategy implements EnemyBehaviourStrategy {

    @Override
    public void execute(Enemy enemy) {
        MovementComponent movement = enemy.getComponent(MovementComponent.class);

        // Find the first available Player in the room
        Player target = enemy.getMyRoom().getAliveCharacters().stream()
                .filter(character -> character instanceof Player)
                .map(character -> (Player) character)
                .findFirst()
                .orElse(null);

        if (target == null) {
            // No target to chase, stop moving
            movement.setVx(0);
            movement.setVy(0);
            return;
        }

        double widthScale = target.getMyRoom().getWorldMap().getCurrentWidthScale();
        double heightScale = target.getMyRoom().getWorldMap().getCurrentHeightScale();

        // Calculate positions
        Point2D playerPos = new Point2D.Double(
                target.getX() + target.getWidth() * widthScale / 2.0,
                target.getY() + target.getHeight() * heightScale / 2.0
        );
        Point2D enemyPos = new Point2D.Double(
                enemy.getX() + enemy.getWidth() * widthScale / 2.0,
                enemy.getY() + enemy.getHeight() * heightScale / 2.0
        );

        // Calculate direction to the player
        double dx = playerPos.getX() - enemyPos.getX();
        double dy = playerPos.getY() - enemyPos.getY();
        double magnitude = Math.sqrt(dx * dx + dy * dy);

        // Stop if already at the player's position
        if (magnitude == 0) {
            movement.setVx(0);
            movement.setVy(0);
            return;
        }

        // Normalize direction vector and scale by speed
        double characterSpeed = enemy.getStats().getMovementSpeed();
        dx = (dx / magnitude) * characterSpeed;
        dy = (dy / magnitude) * characterSpeed;

        // Set movement directly towards the player
        movement.setVx(dx);
        movement.setVy(dy);
    }
}
