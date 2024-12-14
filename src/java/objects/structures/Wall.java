package objects.structures;

import javax.swing.*;
import java.awt.*;
import objects.structures.Tile;

public class Wall extends RoomObject{
    public Wall(int x, int y, int numRows, int numCols, int tileWidth, int tileHeight, Image image) {
        super(x, y, numRows, numCols, tileWidth, tileHeight, image);
    }

    @Override
    public boolean isTilePassable() {
        return false;
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
