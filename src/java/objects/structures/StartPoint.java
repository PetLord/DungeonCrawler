package objects.structures;

import java.awt.*;

public class StartPoint extends RoomObject{

    public StartPoint(int startRow, int startCol, int tileWidth, int tileHeight, Image image) {
        super(startRow, startCol, 1, 1, tileWidth, tileHeight, image);
    }

    @Override
    public boolean isTilePassable() {
        return true;
    }

    @Override
    public int getPrecedence() {
        return 3;
    }


}
