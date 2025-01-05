package windows.panels.gamePanel.entities.structures.worldMap;

import windows.panels.gamePanel.entities.structures.Room;

// A room the player cant enter
public class EmptyRoomBlock extends Room {
    public EmptyRoomBlock(WorldMap worldMap, int mapX, int mapY) {
        super(worldMap, mapX, mapY, 0, 0, 0, 0, null, null, null, null);
    }
}
