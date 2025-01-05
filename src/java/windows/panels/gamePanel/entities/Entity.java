package windows.panels.gamePanel.entities;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.structures.Room;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity {
    protected int x, y;
    protected int width, height;
    protected GamePanel gamePanel;
    protected Room myRoom;
    protected boolean isAlive = true;
    private final Map<Class<?>, Object> components = new HashMap<>();

    public abstract void render(Graphics2D g);

    public Entity(int x, int y, int width, int height, GamePanel gamePanel, Room myRoom) {
        this.myRoom = myRoom;
        this.gamePanel = gamePanel;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public <T> void addComponent(Class<T> componentClass, T component) {
        components.put(componentClass, component);
    }

    public <T> T getComponent(Class<T> componentClass) {
        return (T) components.get(componentClass);
    }

    public boolean hasComponent(Class<?> componentClass) {
        return components.containsKey(componentClass);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GameWorld getGameWorld() {
        try {
            return gamePanel.getGameWorld();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public Rectangle getHitBox(){
        return new Rectangle(x, y, (int) (width * getGameWorld().getCurrentWidthScale()), (int) (height * getGameWorld().getCurrentHeightScale()));
    }


    public Room getMyRoom() {
        return myRoom;
    }

    public int getDistance(Entity entity) {
        int myCenterX = this.x + this.width / 2;
        int myCenterY = this.y + this.height / 2;

        int entityCenterX = entity.x + entity.width / 2;
        int entityCenterY = entity.y + entity.height / 2;

        return (int) Math.sqrt(Math.pow(myCenterX - entityCenterX, 2) + Math.pow(myCenterY - entityCenterY, 2));
    }

    public boolean collidesWith(Entity entity) {
        return this.getHitBox().intersects(entity.getHitBox());
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public void setMyRoom(Room myRoom) {
        this.myRoom = myRoom;
    }
}
