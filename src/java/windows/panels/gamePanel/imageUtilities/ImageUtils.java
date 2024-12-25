package windows.panels.gamePanel.imageUtilities;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ImageUtils {

    public static BufferedImage rescaleImage(BufferedImage originalImage, double scale) {
        int newWidth = (int) (originalImage.getWidth() * scale);
        int newHeight = (int) (originalImage.getHeight() * scale);

        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();

        // Perform scaling
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImage;
    }

    public static BufferedImage verticalFlip(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = flippedImage.createGraphics();

        g2d.scale(1, -1);
        g2d.drawImage(originalImage, 0, -height, null);
        g2d.dispose();

        return flippedImage;
    }

    public static BufferedImage horizontalFlip(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = flippedImage.createGraphics();

        g2d.scale(-1, 1);
        g2d.drawImage(originalImage, -width, 0, null);
        g2d.dispose();

        return flippedImage;
    }
}
