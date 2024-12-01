package objects;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    protected int x, y, width, height;
    private Map<Class<?>, Object> components = new HashMap<>();

    public Entity(int x, int y, int width, int height) {
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
}
