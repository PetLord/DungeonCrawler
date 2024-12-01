package components;

import objects.Entity;

public class MovementComponent {
    private int speed;
    private int vx, vy;    // Velocity
    private double ax, ay; // Acceleration
    private double friction; // Friction or deceleration factor

    public MovementComponent(int speed) {
        this.speed = speed;
        this.vx = 0;
        this.vy = 0;
        this.ax = 0;
        this.ay = 0;
        this.friction = 0.1; // Default friction, adjust as needed
    }

    public void increaseAx(double increment) {
        this.ax += increment;
    }

    public void increaseAy(double increment) {
        this.ay += increment;
        System.out.println("Increasing Ay:" + ay);
    }

    public void move() {
        vx += (int)ax;
        vy += (int)ay;

        if (Math.abs(vx) > speed) {
            vx = (int) (Math.signum(vx) * speed);
        }
        if (Math.abs(vy) > speed) {
            vy = (int) (Math.signum(vy) * speed);
        }

        // Apply friction/deceleration
        ax *= (1 - friction); // Decrease acceleration (deceleration)
        ay *= (1 - friction);

       // Reduce velocity gradually to simulate friction
        //vx *= (int)(1 - friction);
        //vy *= (int)(1 - friction);

        // Stop when the velocity is small enough
        //if (Math.abs(vx) < 1) vx = 0;
        //if (Math.abs(vy) < 1) vy = 0;
    }

    public void updatePosition(Entity entity) {
        move();
        entity.setX(entity.getX() + vx);
        entity.setY(entity.getY() + vy);
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public int getSpeed() {
        return speed;
    }
}
