package windows.panels.gamePanel.factories;

import windows.panels.gamePanel.objects.structures.StartPoint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class StartPointFactory {

    public static StartPoint getDefaultStartPoint(int startRow, int startCol, int tileWidth, int tileHeight) {
        return new StartPoint(startRow, startCol, tileWidth, tileHeight, getDefaultStartPointImage());
    }

    public static Image getDefaultStartPointImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/startPoints/start1.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
    }
}
