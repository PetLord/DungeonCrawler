package objects.structures;

import objects.Entity;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Room {
    private static boolean wasChanged = false;
    private final int numRows, numCols;
    private PriorityQueue<Tile>[][] tileGrid;
    private final ArrayList<RoomObject> objects;
    private final ArrayList<StartPoint> startPoints;
    private ArrayList<Entity> entities;
    private final int tileHeight;
    private final int tileWidth;

    public Room(int numRows, int numCols, int tileWidth, int tileHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.objects = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.startPoints = new ArrayList<>();
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

        if(object instanceof StartPoint){
            startPoints.add((StartPoint) object);
        }
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

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
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

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
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

    public ArrayList<StartPoint> getStartPoints() {
        return startPoints;
    }
}
