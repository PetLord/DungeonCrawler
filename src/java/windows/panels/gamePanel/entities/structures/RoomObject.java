package windows.panels.gamePanel.entities.structures;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomObject {
    private final int startRow, startCol;
    private final Tile[][] tiles;
    private int tileHeight;
    private int tileWidth;
    private final int numRows;
    private final int numCols;

    public RoomObject(int startRow, int startCol, int numRows, int numCols, int tileWidth, int tileHeight, Image image) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.numRows = numRows;
        this.numCols = numCols;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tiles = new Tile[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                tiles[row][col] = new Tile(startRow + row, startCol + col, image, isTilePassable(), getPrecedence());
            }
        }
    }

    public RoomObject(int startRow, int startCol, int numRows, int numCols, int tileWidth, int tileHeight, ArrayList<Image> images) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.numRows = numRows;
        this.numCols = numCols;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tiles = new Tile[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int randomIndex = (int) (Math.random() * images.size());
                tiles[row][col] = new Tile(startRow + row, startCol + col, images.get(randomIndex), isTilePassable(), getPrecedence());
            }
        }
    }

    public void setNewImage(Image newImage) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                tiles[row][col].setImage(newImage);
            }
        }
    }

    public ArrayList<Tile> getTiles() {
        return new ArrayList<>(Arrays.stream(tiles).flatMap(Arrays::stream).toList()); // Stream
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }


    public abstract boolean isTilePassable();
    public abstract int getPrecedence();
}
