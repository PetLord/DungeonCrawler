package windows.panels.gamePanel.entities.characters.enemies.enemyBehaviours;

import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.characters.enemies.Enemy;

import java.awt.geom.Point2D;

public class DefensiveBehaviorStrategy implements EnemyBehaviourStrategy {
    @Override
    public void execute(Enemy enemy) {
        MovementComponent movement = enemy.getComponent(MovementComponent.class);
        Player target = enemy.getMyRoom().getAliveCharacters().stream()
                .filter(character -> character instanceof Player)
                .map(character -> (Player) character)
                .findFirst()
                .orElse(null);

        if (target != null) {
            Point2D playerPos = new Point2D.Double(target.getX() + target.getWidth() / 2.0, target.getY() + target.getHeight() / 2.0);
            Point2D slimePos = new Point2D.Double(enemy.getX() + enemy.getWidth() / 2.0, enemy.getY() + enemy.getHeight() / 2.0);

            double dx = slimePos.getX() - playerPos.getX();
            double dy = slimePos.getY() - playerPos.getY();
            double magnitude = Math.sqrt(dx * dx + dy * dy);

            if (magnitude != 0) {
                dx /= magnitude;
                dy /= magnitude;
            }

            movement.setVx(dx);
            movement.setVy(dy);
        }
    }
}
