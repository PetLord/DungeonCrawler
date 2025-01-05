package windows.panels.gamePanel.entities.structures;

import windows.panels.gamePanel.entities.structures.worldMap.WorldMap;

import java.awt.*;

public class Door extends RoomObject {
    private final WallDirection doorDirection;
    private boolean isOpen = false;
    private final Image openImage;
    private final WorldMap worldMap;

    public Door(int startRow, int startCol, int tileWidth, int tileHeight, WallDirection direction, Image openImage, Image closedImage, WorldMap worldMap) {
        super(startRow, startCol, 1, 1, tileWidth, tileHeight, closedImage);
        this.doorDirection = direction;
        this.worldMap = worldMap;
        this.openImage = openImage;
    }

    @Override
    public boolean isTilePassable() {
        return false;
    }

    @Override
    public int getPrecedence() {
        return 3;
    }

    public void openDoor() {
        if(isOpen){
            return;
        }
        isOpen = true;
        this.setNewImage(openImage);
    }

    public void playerEnteringDoor() {
        if(isOpen) {
            worldMap.changeRoom(doorDirection);
        }
    }

    public boolean isMouseOver(int mouseX, int mouseY){
//        System.out.println("MouseX: " + mouseX + " MouseY: " + mouseY);
//        System.out.println("StartCol: " + getStartCol() * getTileWidth() + " EndCol: " + (getStartCol() + 1) * getTileWidth());
//        System.out.println("StartRow: " + getStartRow() * getTileHeight() + " EndRow: " + (getStartRow() + 1) * getTileHeight());
//        System.out.println();

        return mouseX >= getStartCol() * getTileWidth() && mouseX <= (getStartCol() + 1) * getTileWidth() &&
                mouseY >= getStartRow() * getTileHeight() && mouseY <= (getStartRow() + 1) * getTileHeight();
    }
}
