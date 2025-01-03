package windows.panels.gamePanel.components;

import windows.panels.gamePanel.entities.characters.Character;
import windows.panels.gamePanel.entities.characters.Player;

import javax.swing.*;
import java.awt.geom.Point2D;

public class MovementComponent {
    private final double baseSpeed;
    private final static double speedMultiplier = 1.5;
    private FaceDirection direction;
    private double vx, vy;
    private double knockBackForceX;
    private double knockBackForceY;
    private boolean isSprinting;
    private final boolean canSprint;

    private Timer knockBackTimer;
    private final static int timerUpdate = 1000/500; // how fast should the timer update 500 times a seconds ~ 2ms ~

    public MovementComponent(double baseSpeed, boolean canSprint) {
        direction = FaceDirection.EAST;
        this.baseSpeed = baseSpeed;
        this.vx = 0;
        this.vy = 0;
        this.isSprinting = false;
        this.canSprint = canSprint;
        knockBackForceX = 0;
        knockBackForceY = 0;
    }


    public void setVx(double vx) {
        this.vx = vx;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public void sprint() {
        isSprinting = true;
    }

    public void walk() {
        isSprinting = false;
    }

    public void updatePosition(Character character) {
        double moveSpeed = getSpeed();
        double worldWidthScaleX = character.getGameWorld().getCurrentWidthScale();
        double worldHeightScaleY = character.getGameWorld().getCurrentHeightScale();
        if (vx != 0 && vy != 0) {
            moveSpeed = Math.max(1,  moveSpeed / Math.sqrt(2)); // Diagonal movement is slower naturally
        }

        double finalVx = (vx * moveSpeed + knockBackForceX) * worldWidthScaleX;
        double finalVy = (vy * moveSpeed + knockBackForceY) * worldHeightScaleY;

        // Update direction, prefer composite directions if needed
        if (finalVx != 0 || finalVy != 0) {
            if (Math.abs(finalVy) > Math.abs(finalVx)) {
                direction = finalVy > 0 ? FaceDirection.SOUTH : FaceDirection.NORTH;
            } else {
                direction = finalVx > 0 ? FaceDirection.EAST : FaceDirection.WEST;
            }
        }
        character.setDirection(direction);

        // Set the animation state based on direction and movement
        setAnimationState(character, finalVx, finalVy);


        finalVx = floorOrCeil(finalVx);
        finalVy = floorOrCeil(finalVy);

        // Handle collisions
        if (character.hasComponent(CollisionComponent.class)) {
            CollisionComponent collision = character.getComponent(CollisionComponent.class);
            if (collision != null) {
                collision.resolveCollision(character,  (int)(finalVx), (int) (finalVy));
                return;
            }
        }

        // Apply the movement to the entity's position
        character.setX((int) (character.getX() + finalVx));
        character.setY((int) (character.getY() + finalVy));
    }

    private static double floorOrCeil(double value) {
        return value < 0 ? Math.floor(value) : Math.ceil(value);
    }

    private void setAnimationState(Character character, double finalVx, double finalVy) {
        if (character.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = character.getComponent(AnimationComponent.class);
            if (finalVx != 0 || finalVy != 0) { // If moving
                if (isSprinting && canSprint) {
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
            } else { // If idle
                switch (direction) {
                    case WEST -> animationComponent.setAnimationState(AnimationState.IDLE_LEFT);
                    case EAST -> animationComponent.setAnimationState(AnimationState.IDLE_RIGHT);
                    case SOUTH -> animationComponent.setAnimationState(AnimationState.IDLE_DOWN);
                    case NORTH -> animationComponent.setAnimationState(AnimationState.IDLE_UP);
                }
            }
        }
    }

    public double getSpeed() {
        return isSprinting ? baseSpeed * speedMultiplier : baseSpeed;
    }

    public FaceDirection getDirection() {
        return direction;
    }

    public void applyKnockBack(Point2D force) {
        knockBackForceX = force.getX();
        knockBackForceY = force.getY();

        if (knockBackTimer != null) {
            knockBackTimer.stop();
        }

        knockBackTimer = new Timer(timerUpdate, e -> {
            knockBackForceX = knockBackForceX * 0.9 - 0.05;
            knockBackForceY = knockBackForceY * 0.9 - 0.05;

            // Explicitly set knockback values to zero when they are very small
            if (Math.abs(knockBackForceX) < 0.01) {
                knockBackForceX = 0;
            }
            if (Math.abs(knockBackForceY) < 0.01) {
                knockBackForceY = 0;
            }

            // Stop the timer if both forces are effectively zero
            if (knockBackForceX == 0 && knockBackForceY == 0) {
                knockBackTimer.stop();
            }
        });

        knockBackTimer.setInitialDelay(0);
        knockBackTimer.setRepeats(true);
        knockBackTimer.start();
    }

}