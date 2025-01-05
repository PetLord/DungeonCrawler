package windows.panels.gamePanel.entities.structures;

import java.awt.*;

public class Tile implements Comparable<Tile> {
    private final int x;
    private final int y;
    private Image image;
    private final boolean isPassable;
    private final int precedence;

    public Tile(int x, int y, Image image, boolean isPassable, int precedence) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.isPassable = isPassable;
        this.precedence = precedence;
    }

    public void render(Graphics g, int gridX, int gridY, int width, int height) {
        g.drawImage(image, gridX, gridY, width, height, null);
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public int compareTo(Tile o) {
        return Integer.compare(this.precedence, o.precedence);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getDefaultTileWidth(){
        return 50;
    }

    public static int getDefaultTileHeight(){
        return 50;
    }
}
