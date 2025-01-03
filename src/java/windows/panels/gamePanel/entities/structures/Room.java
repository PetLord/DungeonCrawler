package windows.panels.gamePanel.entities.structures;

import windows.panels.gamePanel.entities.characters.Character;

import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Room {
    private static boolean wasChanged = false;
    private final int numRows, numCols;
    private PriorityQueue<Tile>[][] tileGrid;
    private final ArrayList<RoomObject> objects;
    private final ArrayList<PlayerEntrance> playerEntrances;
    private final ArrayList<MobSpawnLocation> mobSpawnLocations;
    private ArrayList<Character> characters;

    private int tileHeight;
    private int tileWidth;

    public Room(int numRows, int numCols, int tileWidth, int tileHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.objects = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.playerEntrances = new ArrayList<>();
        this.mobSpawnLocations = new ArrayList<>();
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

    public void addPlayerEntrance(PlayerEntrance playerEntrance){
        playerEntrances.add(playerEntrance);
        addObject(playerEntrance);
    }

    public void addMobSpawnLocation(MobSpawnLocation mobSpawnLocation){
        mobSpawnLocations.add(mobSpawnLocation);
    }

    public ArrayList<MobSpawnLocation> getMobSpawnLocations() {
        return mobSpawnLocations;
    }

    public void recreateGrid() {
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

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public PriorityQueue<Tile>[][] getTileGrid() {
        return tileGrid;
    }

    public ArrayList<Tile> getTiles() {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                tiles.addAll(tileGrid[row][col]);
            }
        }
        return tiles;
    }

    public ArrayList<PlayerEntrance> getPlayerEntrances() {
        return playerEntrances;
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
    }

}
