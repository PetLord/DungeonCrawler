package camera;

import gameWindow.gameWorld;
import objects.Entity;

public class Camera extends Entity {
    private final gameWorld world;

    public Camera(gameWorld world, int width, int height) {
        super(0, 0, width, height);
        this.world = world;
    }

    public void update(int playerX, int playerY) {
        this.x = playerX - width / 2;
        this.y = playerY - height / 2;

        this.x = Math.max(0, Math.min(this.x, world.getWorldWidth() - width));
        this.y = Math.max(0, Math.min(this.y, world.getWorldHeight() - height));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
