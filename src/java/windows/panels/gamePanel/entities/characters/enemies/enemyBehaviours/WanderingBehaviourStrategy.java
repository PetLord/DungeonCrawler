package windows.panels.gamePanel.entities.characters.enemies.enemyBehaviours;

import windows.panels.gamePanel.components.MoveDirection;
import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.entities.characters.enemies.Enemy;
import java.util.Random;

public class WanderingBehaviourStrategy implements EnemyBehaviourStrategy {
    private static final Random random = new Random();
    private static final int MIN_WANDER_DURATION = 1000; // 1 second
    private static final int MAX_WANDER_DURATION = 3000; // 3 seconds

    private MoveDirection currentDirection;
    private long nextDirectionChangeTime;

    @Override
    public void execute(Enemy enemy) {
        MovementComponent movement = enemy.getComponent(MovementComponent.class);

        long currentTime = System.currentTimeMillis();

        // Check if it's time to change direction
        if (currentTime >= nextDirectionChangeTime) {
            currentDirection = getRandomDirection();
            nextDirectionChangeTime = currentTime + randomDuration();
        }

        // Apply movement based on the current direction
        applyDirection(movement);
    }

    private MoveDirection getRandomDirection() {
        return MoveDirection.values()[random.nextInt(MoveDirection.values().length)];
    }

    private int randomDuration() {
        return random.nextInt(MAX_WANDER_DURATION - MIN_WANDER_DURATION + 1) + MIN_WANDER_DURATION;
    }

    private void applyDirection(MovementComponent movement) {
        switch (currentDirection) {
            case NORTH -> {
                movement.setVx(0);
                movement.setVy(-1);
            }
            case SOUTH -> {
                movement.setVx(0);
                movement.setVy(1);
            }
            case EAST -> {
                movement.setVx(1);
                movement.setVy(0);
            }
            case WEST -> {
                movement.setVx(-1);
                movement.setVy(0);
            }
            // Optional: Diagonal directions
            case NORTHEAST -> {
                movement.setVx(1);
                movement.setVy(-1);
            }
            case NORTHWEST -> {
                movement.setVx(-1);
                movement.setVy(-1);
            }
            case SOUTHEAST -> {
                movement.setVx(1);
                movement.setVy(1);
            }
            case SOUTHWEST -> {
                movement.setVx(-1);
                movement.setVy(1);
            }
        }
    }
}
