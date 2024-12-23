package objects;

import components.Direction;
import gameWindow.GamePanel;
import gameWindow.GameWorld;
import objects.structures.Room;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity {
    protected int x, y, width, height;
    private final Map<Class<?>, Object> components = new HashMap<>();
    private GamePanel gamePanel;
    private Direction direction;

    public abstract void render(Graphics2D g);

    public Entity(int x, int y, int width, int height, GamePanel gamePanel) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gamePanel = gamePanel;
        direction = Direction.EAST;
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
        return new Rectangle(x, y, width, height);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
