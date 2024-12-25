package windows.panels.gamePanel.components;

import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.objects.Entity;
import windows.panels.gamePanel.objects.structures.Tile;

import java.awt.Rectangle;
import java.util.PriorityQueue;

public class CollisionComponent {
    private final GameWorld gameWorld;

    public CollisionComponent(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public boolean checkCollision(Rectangle hitBox) {
        int tileWidth = gameWorld.getCurrentRoom().getTileWidth();
        int tileHeight = gameWorld.getCurrentRoom().getTileHeight();
        PriorityQueue<Tile>[][] tileGrid = gameWorld.getCurrentRoom().getTileGrid();

        // Calculate the range of tiles the hitBox overlaps
        int minRow = Math.max(0, hitBox.y / tileHeight);
        int maxRow = Math.min(tileGrid.length - 1, (hitBox.y + hitBox.height - 1) / tileHeight);
        int minCol = Math.max(0, hitBox.x / tileWidth);
        int maxCol = Math.min(tileGrid[0].length - 1, (hitBox.x + hitBox.width - 1) / tileWidth);

        // Check collisions with tiles
        for (int row = minRow; row <= maxRow; row++) {
            for (int col = minCol; col <= maxCol; col++) {
                for (Tile tile : tileGrid[row][col]) {
                    if (!tile.isPassable()) {
                        Rectangle tileHitBox = new Rectangle(col * tileWidth, row * tileHeight, tileWidth, tileHeight);
                        if (tileHitBox.intersects(hitBox)) {
                            return true; // Collision detected
                        }
                    }
                }
            }
        }
        return false;
    }

    public void resolveCollision(Entity entity, int dx, int dy) {
        Rectangle hitBox = entity.getHitBox();
        int tileWidth = gameWorld.getCurrentRoom().getTileWidth();
        int tileHeight = gameWorld.getCurrentRoom().getTileHeight();

        // Handle horizontal movement
        hitBox.x += dx;
        if (checkCollision(hitBox)) {
            hitBox.x -= dx; // Undo horizontal movement
        } else {
            entity.setX(hitBox.x); // Update entity's x position
        }

        // Handle vertical movement
        hitBox.y += dy;
        if (checkCollision(hitBox)) {
            hitBox.y -= dy; // Undo vertical movement
        } else {
            entity.setY(hitBox.y); // Update entity's y position
        }
    }
}
