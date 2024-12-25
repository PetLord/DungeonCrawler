package windows.panels.gamePanel.components;

import windows.panels.gamePanel.objects.Entity;

public class MovementComponent {
    private final int baseSpeed;
    private double adjustedSpeed;
    private final static double speedMultiplier = 1.5;
    private Direction direction;
    private int vx, vy;
    private boolean isSprinting;

    public MovementComponent(int baseSpeed, int tileWidth, int tileHeight) {
        direction = Direction.EAST;
        this.baseSpeed = baseSpeed;
        setTileSizeMultiplier(tileWidth, tileHeight);
        this.vx = 0;
        this.vy = 0;
        this.isSprinting = false;
    }

    public void setTileSizeMultiplier(int tileWidth, int tileHeight) {
        double averageTileSize = (tileWidth + tileHeight) / 2.0;
        this.adjustedSpeed = Math.max(1, baseSpeed * averageTileSize / 64 );
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void sprint() {
        isSprinting = true;
    }

    public void walk() {
        isSprinting = false;
    }

    public void updatePosition(Entity entity) {
        int moveSpeed = getSpeed();

        // Normalize diagonal movement speed
        if (vx != 0 && vy != 0) {
            moveSpeed = Math.max (1, (int) (moveSpeed / Math.sqrt(2)));
        }

        // Update direction based on vx and vy values independently
        if (vy > 0) {
            direction = Direction.SOUTH;
        } else if (vy < 0) {
            direction = Direction.NORTH;
        }


        if (vx > 0) {
            direction = Direction.EAST;
        } else if (vx < 0) {
            direction = Direction.WEST;
        }

        entity.setDirection(direction);

        // Set the animation state based on direction and movement
        if (entity.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = entity.getComponent(AnimationComponent.class);
            // If moving (any direction), set the appropriate running or walking state
            if (vx != 0 || vy != 0) {
                if (isSprinting) {
                    switch (direction) {
                        case WEST -> animationComponent.setAnimationState(AnimationState.RUNNING_LEFT);
                        case EAST -> animationComponent.setAnimationState(AnimationState.RUNNING_RIGHT);
                        case SOUTH -> animationComponent.setAnimationState(AnimationState.RUNNING_DOWN);
                        case NORTH -> animationComponent.setAnimationState(AnimationState.RUNNING_UP);
                    }
                } else {
                    switch (direction) {
                        case WEST -> animationComponent.setAnimationState(AnimationState.WALKING_LEFT);
                        case EAST -> animationComponent.setAnimationState(AnimationState.WALKING_RIGHT);
                        case SOUTH -> animationComponent.setAnimationState(AnimationState.WALKING_DOWN);
                        case NORTH -> animationComponent.setAnimationState(AnimationState.WALKING_UP);
                    }
                }
            } else { // if idle
                switch (direction) {
                    case WEST -> animationComponent.setAnimationState(AnimationState.IDLE_LEFT);
                    case EAST -> animationComponent.setAnimationState(AnimationState.IDLE_RIGHT);
                    case SOUTH -> animationComponent.setAnimationState(AnimationState.IDLE_DOWN);
                    case NORTH -> animationComponent.setAnimationState(AnimationState.IDLE_UP);
                }
            }
        }

        // Handle collisions
        if (entity.hasComponent(CollisionComponent.class)) {
            CollisionComponent collision = entity.getComponent(CollisionComponent.class);
            if (collision != null) {
                collision.resolveCollision(entity, vx * moveSpeed, vy * moveSpeed);
                return;
            }
        }

        // Apply the movement to the entity's position
        entity.setX(entity.getX() + vx * moveSpeed);
        entity.setY(entity.getY() + vy * moveSpeed);
    }

    public void stop() {
        vx = 0;
        vy = 0;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public int getSpeed() {
        return isSprinting ? (int)(adjustedSpeed * speedMultiplier) : (int)adjustedSpeed;
    }

    public Direction getDirection() {
        return direction;
    }
}
