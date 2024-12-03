package gameWindow;

import camera.Camera;
import objects.Entity;

import java.util.ArrayList;

public class GameWorld {
    private final int worldHeight;
    private final int worldWidth;
    private final Camera camera;
    private final GamePanel gamePanel;
    private ArrayList<Entity> entities;

    public GameWorld(GamePanel gamepanel, int width, int height) {
        this.gamePanel = gamepanel;
        this.worldWidth = width;
        this.worldHeight = height;
        entities = new ArrayList<>();
        camera = new Camera(this, gamePanel.getScreenWidth(), gamePanel.getScreenHeight());
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }


}
