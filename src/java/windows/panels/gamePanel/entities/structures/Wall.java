package windows.panels.gamePanel.entities.structures;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends RoomObject{
    public Wall(int x, int y, int numRows, int numCols, int tileWidth, int tileHeight, Image image) {
        super(x, y, numRows, numCols, tileWidth, tileHeight, image);
    }

    public Wall(int x, int y, int numRows, int numCols, int tileWidth, int tileHeight, ArrayList<Image> images) {
        super(x, y, numRows, numCols, tileWidth, tileHeight, images);
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
