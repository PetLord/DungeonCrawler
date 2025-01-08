package factories;

import windows.panels.gamePanel.entities.structures.Floor;
import windows.panels.gamePanel.entities.structures.RoomObject;
import windows.panels.gamePanel.entities.structures.Wall;
import windows.panels.gamePanel.entities.structures.WallDirection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

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

    public static RoomObject getBossWall(Floor f, WallDirection direction) {
        int x = f.getStartRow();
        int y = f.getStartCol();
        int rows = f.getNumRows();
        int cols = f.getNumCols();
        int tileHeight = f.getTileHeight();
        int tileWidth = f.getTileWidth();

        ArrayList<Image> bossWallImages = getBossWallImages();


        return switch (direction) {
            case NORTH -> new Wall(x, y, 1, cols, tileWidth, tileHeight, getBossWallImages());
            case SOUTH -> new Wall(x + rows - 1, y, 1, cols, tileWidth, tileHeight, getBossWallImages());
            case EAST -> new Wall(x, y + cols - 1, rows, 1, tileWidth, tileHeight, getBossWallImages());
            case WEST -> new Wall(x, y, rows, 1, tileWidth, tileHeight, getBossWallImages());
        };
    }

    public static ArrayList<Image> getBossWallImages() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/BossWall1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/tiles/BossWall2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/tiles/BossWall3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/tiles/BossWall4.png"));

            ArrayList<Image> images = new ArrayList<>();
            images.add(new ImageIcon(img).getImage());
            images.add(new ImageIcon(img2).getImage());
            images.add(new ImageIcon(img3).getImage());
            images.add(new ImageIcon(img4).getImage());
            return images;
        } catch (Exception e) {
            System.out.println("Error loading default wall image");
            return null;
        }
    }


}
