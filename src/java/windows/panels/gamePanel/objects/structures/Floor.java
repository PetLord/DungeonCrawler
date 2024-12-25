package windows.panels.gamePanel.objects.structures;

import java.awt.*;

public class Floor extends RoomObject{
    public Floor(int x, int y, int numRows, int numCols, int tileWidth, int tileHeight, Image image) {
        super(x, y, numRows, numCols, tileWidth, tileHeight, image);
    }

    @Override
    public boolean isTilePassable() {
        return true;
    }

    @Override
    public int getPrecedence() {
        return 0;
    }

    public String toString() {
        return "Floor: " + getStartRow() + ", " + getStartCol() + ", rows:" + getNumRows() + ", cols" + getNumCols();

    }
}
