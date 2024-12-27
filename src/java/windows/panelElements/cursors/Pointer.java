package windows.panelElements.cursors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Pointer extends CustomCursor {
    private final Cursor cursor;

    public Pointer() {
        super(CursorType.POINTER);
        cursor = Toolkit.getDefaultToolkit().createCustomCursor(getImage(), new Point(8, 4), "pointer");
    }

    public void applyToComponent(Component component) {
        component.setCursor(cursor);
    }

    public Image getImage(){
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/cursors/pointer.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading Pointer cursor image");
            return null;
        }
    }
}
