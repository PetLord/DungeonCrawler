package components;

public class MovementComponent {
    private int speed;
    private int dx, dy;

    public MovementComponent(int speed) {
        this.speed = speed;
        this.dx = 0;
        this.dy = 0;
    }

    public void move() {
        this.dx = speed;
        this.dy = speed;
    }

    public void setMovementDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
