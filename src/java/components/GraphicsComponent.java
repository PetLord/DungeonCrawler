package components;

import java.awt.*;

public class GraphicsComponent {
    private Image image;

    public GraphicsComponent(Image image) {
        this.image = image;
    }

    public void render(Graphics g, int x, int y, int width, int height) {
        g.drawImage(image, x, y, width, height, null);
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
