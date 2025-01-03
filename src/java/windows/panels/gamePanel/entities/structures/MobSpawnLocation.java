package windows.panels.gamePanel.entities.structures;

import java.awt.*;

public class MobSpawnLocation {
    private final Room myRoom;
    private final int startRow;
    private final int startCol;

    public MobSpawnLocation(Room room, int startRow, int startCol) {
        this.myRoom = room;
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public Point getStartPoint() {
        return new Point(startRow, startCol);
    }

    public int getTileWidth(){
        return myRoom.getTileWidth();
    }

    public int getTileHeight(){
        return myRoom.getTileHeight();
    }

}
