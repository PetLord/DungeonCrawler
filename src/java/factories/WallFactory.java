package factories;

import windows.panels.gamePanel.entities.structures.Floor;
import windows.panels.gamePanel.entities.structures.Wall;
import windows.panels.gamePanel.entities.structures.WallDirection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class WallFactory {
    public static Wall getWall(Floor f, WallDirection direction) {
        int x = f.getStartRow();
        int y = f.getStartCol();
        int rows = f.getNumRows();
        int cols = f.getNumCols();
        int tileHeight = f.getTileHeight();
        int tileWidth = f.getTileWidth();

        return switch (direction) {
            case NORTH -> new Wall(x, y, 1, cols, tileWidth, tileHeight, getDefaultWallImage());
            case SOUTH -> new Wall(x + rows - 1, y, 1, cols, tileWidth, tileHeight, getDefaultWallImage());
            case EAST -> new Wall(x, y + cols - 1, rows, 1, tileWidth, tileHeight, getDefaultWallImage());
            case WEST -> new Wall(x, y, rows, 1, tileWidth, tileHeight, getDefaultWallImage());
        };
    }

    public static Image getDefaultWallImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/SeamlessWall.jpg"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default wall image");
            return null;
        }
    }

    public static Image getOpenDoorImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/OpenDoor.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default open door image");
            return null;
        }
    }

    public static Image getLockedDoorImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/LockedDoor.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default locked door image");
            return null;
        }
    }

}
