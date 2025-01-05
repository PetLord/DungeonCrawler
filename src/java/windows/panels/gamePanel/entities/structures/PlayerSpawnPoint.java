package windows.panels.gamePanel.entities.structures;

import java.awt.*;

public class PlayerSpawnPoint extends RoomObject{
    public PlayerSpawnPoint(int startRow, int startCol, int tileWidth, int tileHeight, Image image) {
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
