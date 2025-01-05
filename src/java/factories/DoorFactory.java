package factories;

import windows.panels.gamePanel.entities.structures.Door;
import windows.panels.gamePanel.entities.structures.WallDirection;
import windows.panels.gamePanel.entities.structures.worldMap.WorldMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class DoorFactory {

    public static Door getDoor(int row, int col, int tileWidth, int tileHeight, WallDirection direction, WorldMap worldMap) {
        return new Door(row, col, tileWidth, tileHeight, direction, getDoorImage(), getClosedDoorImage(), worldMap);
    }


    private static Image getDoorImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/OpenDoor.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default door image");
            return null;
        }
    }

    private static Image getClosedDoorImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/tiles/LockedDoor.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default door image");
            return null;
        }
    }
}
