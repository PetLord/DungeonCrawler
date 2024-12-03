package components;

import objects.Entity;

public class MovementComponent {
    private final int speed;
    private int vx, vy;
    public boolean isSprinting;

    public MovementComponent(int speed) {
        this.speed = speed;
        this.vx = 0;
        this.vy = 0;
        this.isSprinting = false;
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
        int moveSpeed = isSprinting ? (int)(speed * 1.5) : speed;

        if (vx != 0 && vy != 0) {
            moveSpeed = (int) (moveSpeed / Math.sqrt(2));
        }

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
        return isSprinting ? speed * (int)Math.sqrt(2) : speed;
    }
}
