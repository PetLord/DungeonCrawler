package windows.panelElements.cursors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class OpenHand extends CustomCursor {
    private final Cursor cursor;

    public OpenHand() {
        super(CursorType.OPEN_HAND);
        cursor = Toolkit.getDefaultToolkit().createCustomCursor(getImage(), new Point(8, 4), "openHand");
    }

    public void applyToComponent(Component component) {
        component.setCursor(cursor);
    }

    public Image getImage(){
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/cursors/openHand.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading OpenHand cursor image");
            return null;
        }
    }
}
