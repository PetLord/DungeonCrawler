package factories;

import windows.panels.gamePanel.entities.structures.Floor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class FloorFactory {
    public static Floor getDefaultFloor1(int x, int y, int rows, int cols, int tileWidth, int tileHeight) {
        return new Floor(x, y, rows, cols, tileWidth, tileHeight, getDefaultFloorImage());
    }

    public static Floor getVoidFloor(int x, int y, int rows, int cols, int tileWidth, int tileHeight) {
        return new Floor(x, y, rows, cols, tileWidth, tileHeight, getVoidImage());
    }


    public static Image getDefaultFloorImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/DarkRockTile.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
    }

    public static Image getVoidImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/Void3.jpg"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
    }


}
