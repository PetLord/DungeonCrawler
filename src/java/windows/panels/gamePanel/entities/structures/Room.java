package windows.panels.gamePanel.entities.structures;

import factories.DoorFactory;
import windows.panels.gamePanel.entities.characters.Character;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.structures.worldMap.WorldMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Room {
    private final int mapX, mapY;
    private static boolean wasChanged = true;
    private final int numRows, numCols;
    private PriorityQueue<Tile>[][] tileGrid;
    private final ArrayList<RoomObject> objects = new ArrayList<>();
    private PlayerSpawnPoint spawnLocation;
    private final ArrayList<MobSpawnLocation> mobSpawnLocations = new ArrayList<>();
    private final Map<WallDirection, Point> doorLocations = new HashMap<>();
    private final Map<WallDirection, Door> doors = new HashMap<>();
    private final ArrayList<Character> characters = new ArrayList<>();
    private final WorldMap worldMap;
    private int tileHeight;
    private int tileWidth;

    public Room(WorldMap worldMap, int mapX, int mapY, int numRows, int numCols, int tileWidth, int tileHeight,
                Point northDoorLocation, Point southDoorLocation, Point eastDoorLocation, Point westDoorLocation) {
        this.worldMap = worldMap;
        this.mapX = mapX;
        this.mapY = mapY;
        this.numRows = numRows;
        this.numCols = numCols;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.doorLocations.put(WallDirection.NORTH, northDoorLocation);
        this.doorLocations.put(WallDirection.SOUTH, southDoorLocation);
        this.doorLocations.put(WallDirection.EAST, eastDoorLocation);
        this.doorLocations.put(WallDirection.WEST, westDoorLocation);
        initializeGrid();
    }

    public void render(Graphics g) {
        if (wasChanged){
            recreateGrid();
            wasChanged = false;
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                for (Tile tile : tileGrid[row][col]) {
                    tile.render(g, col * tileWidth, row * tileHeight, tileWidth, tileHeight);
                }
            }
        }
    }

    public void addObject(RoomObject object) {
        objects.add(object);
        wasChanged = true;
    }

    public void setPlayerSpawnLocation(PlayerSpawnPoint spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public void addMobSpawnLocation(MobSpawnLocation mobSpawnLocation){
        mobSpawnLocations.add(mobSpawnLocation);
    }

    public ArrayList<MobSpawnLocation> getMobSpawnLocations() {
        return mobSpawnLocations;
    }

    private void recreateGrid() {
        clearGrid();
        for (RoomObject object : objects) {
            for (Tile tile : object.getTiles()) {
                tileGrid[tile.getX()][tile.getY()].add(tile);
            }
        }
    }

    private void clearGrid() {
        if (tileGrid != null) {
            for (PriorityQueue<Tile>[] priorityQueues : tileGrid) {
                for (PriorityQueue<Tile> priorityQueue : priorityQueues) {
                    priorityQueue.clear();
                }
            }
        }
    }

    private void initializeGrid() {
        tileGrid = new PriorityQueue[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                tileGrid[row][col] = new PriorityQueue<>();
            }
        }
    }

    public void switchedToRoom() {
        wasChanged = true;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }
    
    public ArrayList<Character> getAliveCharacters() {
        return characters.stream()
                .filter(Character::isAlive)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<Character> getAllCharacters() {
        return characters;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getWidth() {
        return numCols * tileWidth;
    }

    public int getHeight() {
        return numRows * tileHeight;
    }

    public PriorityQueue<Tile>[][] getTileGrid() {
        return tileGrid;
    }

    public PlayerSpawnPoint getSpawnLocation() {
        return spawnLocation;
    }

    public Point getDoorLocation(WallDirection direction) {
        return doorLocations.get(direction);
    }

    public void setWidth(int width) {
        int oldWidth = this.getWidth();
        if (oldWidth == 0) return; // Avoid division by zero

        double scaleX = (double) width / oldWidth;
        this.tileWidth = width / numCols;

        for (Character character : characters) {
            int newX = (int) (character.getX() * scaleX);
            character.setX(newX);
        }

        for (RoomObject object : objects) {
            object.setTileWidth(tileWidth);
        }
    }

    public void setHeight(int height) {
        int oldHeight = this.getHeight();
        if (oldHeight == 0) return; // Avoid division by zero

        double scaleY = (double) height / oldHeight;
        this.tileHeight = height / numRows;

        for (Character character : characters) {
            int newY = (int) (character.getY() * scaleY);
            character.setY(newY);
        }

        for (RoomObject object : objects) {
            object.setTileHeight(tileHeight);
        }
    }

    public void addDoor(WallDirection direction){
        Point location = doorLocations.get(direction);
        Door door = DoorFactory.getDoor(location.x, location.y, tileWidth, tileHeight, direction, worldMap);
        doors.put(direction, door);
        objects.add(door);
    }

    public Door getDoor(WallDirection direction){
        return doors.get(direction);
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public void update() {
        //update every character
        ArrayList<Character> aliveCharacters = getAliveCharacters();
        for (Character character : aliveCharacters) {
            character.update();
        }


        //if only the player remains alive, open the doors
        if (aliveCharacters.size() == 1 && aliveCharacters.getFirst() instanceof Player) {
            for (Door door : doors.values()) {
                door.openDoor();
            }
        }
    }
}
