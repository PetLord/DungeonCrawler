package windows.panels.gamePanel.entities.structures.worldMap;

// idea is to design a set of predefined room layouts,
// each featuring door coordinates on the east, west, north, and south sides.
// Using these layouts, I will generate an n * m grid,
// populate it with rooms and empty spaces (free blocks),
// and then establish connections between the rooms.
// generate using world map generation strategy

import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.structures.WallDirection;

import java.awt.*;

public class WorldMap {
    private Room currentRoom;
    private final Room[][] roomGrid;
    private final GameWorld gameWorld;

    public WorldMap(GameWorld gameWorld, int n, int m, WorldMapGenerationStrategy generationStrategy) {
        this.gameWorld = gameWorld;
        this.roomGrid = new Room[n][m];
        generationStrategy.generateWorldMap(gameWorld, this, n, m);

        Dimension starterRoomPosition = generationStrategy.getStarterRoomPosition();
        if (starterRoomPosition == null || starterRoomPosition.width < 0 || starterRoomPosition.height < 0 ||
                starterRoomPosition.width >= n || starterRoomPosition.height >= m) {
            throw new IllegalArgumentException("Invalid starter room position.");
        }

        currentRoom = roomGrid[starterRoomPosition.width][starterRoomPosition.height];
        if (currentRoom == null) {
            throw new IllegalStateException("Starter room is not defined at the specified position.");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null.");
        }
        currentRoom = room;
    }

    public Room[][] getRoomGrid() {
        return roomGrid;
    }

    public void changeRoom(WallDirection doorDirection) {
        int currentRoomX = currentRoom.getMapX();
        int currentRoomY = currentRoom.getMapY();

        int newX = currentRoomX + doorDirection.getDeltaX();
        int newY = currentRoomY + doorDirection.getDeltaY();

        if (newX < 0 || newX >= roomGrid.length || newY < 0 || newY >= roomGrid[0].length || roomGrid[newX][newY] == null) {
            throw new IllegalStateException("Cannot move in the specified direction. No valid room exists.");
        }

        Player player = gameWorld.getPlayer();
        Room newRoom = roomGrid[newX][newY];
        Point doorLocation = newRoom.getDoorLocation(doorDirection.opposite());

        if (doorLocation == null) {
            throw new IllegalStateException("The corresponding door does not exist in the new room.");
        }

        // Transition the player between rooms
        currentRoom.removeCharacter(player);
        newRoom.addCharacter(player);
        player.setMyRoom(newRoom);
        setCurrentRoom(newRoom);

        movePlayerToFrontOfDoor(player, doorDirection, newRoom);
        newRoom.switchedToRoom();
    }

    private void movePlayerToFrontOfDoor(Player player, WallDirection moveDirection, Room newRoom) {
        Point doorLocation = newRoom.getDoorLocation(moveDirection.opposite());
        if (player == null || doorLocation == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }

        // Adjust player's position to be near the door but not inside the wall
        int offsetX = moveDirection.getDeltaX() * 2;
        int offsetY = moveDirection.getDeltaY() * 2;
        player.setX((doorLocation.y + offsetX) * newRoom.getTileWidth());
        player.setY((doorLocation.x + offsetY) * newRoom.getTileHeight());
    }

    public double getCurrentWidthScale(){
        return gameWorld.getCurrentWidthScale();
    }

    public double getCurrentHeightScale(){
        return gameWorld.getCurrentHeightScale();
    }
}
