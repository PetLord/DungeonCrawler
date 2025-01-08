package windows.panels.HUD;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {
    private final JLabel healthLabel;

    public HUDPanel() {
        // Set the panel as non-opaque (transparent)
        this.setOpaque(false);
        // Initialize the health label
        healthLabel = new JLabel("Health:");
        healthLabel.setOpaque(true); // Make the label opaque to show the background color
        healthLabel.setBackground(new Color(200, 50, 50, 255)); // Set background color
        healthLabel.setForeground(Color.WHITE); // Set the text color
        healthLabel.setFont(new Font("Arial", Font.PLAIN, 25)); // Set the font and size

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.add(healthLabel);
    }

    // Method to update health displayed on the HUD
    public void updateHealth(int health, int maxHealth) {
        healthLabel.setText("Health: " + health + "/" + maxHealth);
    }

    public void render(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Custom rendering: Draw the health label manually
        g2.setFont(new Font("Arial", Font.PLAIN, 25)); // Set the font
        g2.setColor(Color.WHITE); // Set the text color
        g2.drawString(healthLabel.getText(), 10, 30); // Draw the label at specific position

        // If you want to add custom background behind the label
        g2.setColor(new Color(200, 50, 50, 255)); // Set background color
        g2.fillRect(0, 0, this.getWidth(), this.getHeight()); // Fill the background of the panel
    }
}
