package windows.panels.optionsPanel.tabs;

import windows.panels.CustomPanel;
import javax.swing.*;
import java.awt.*;

public class AudioTab extends CustomTab {
    CustomPanel panel;
    SliderBox masterBox;
    SliderBox musicBox;
    SliderBox effectBox;

    public AudioTab(CustomPanel panel) {
        super(CustomTabType.DISPLAY);
        this.panel = panel;

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        // Define GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Start from the first column
        gbc.gridy = 0; // Start from the first row
        gbc.insets = new Insets(20, 20, 20, 20); // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch only horizontally

        // Create the SliderBox components
        masterBox = new SliderBox(new JSlider(), new JLabel("Master volume"));
        musicBox = new SliderBox(new JSlider(), new JLabel("Music volume"));
        effectBox = new SliderBox(new JSlider(), new JLabel("Effect volume"));

        // Add components to the layout
        this.add(masterBox, gbc);

        gbc.gridy = 1; // Move to the next row
        this.add(musicBox, gbc);

        gbc.gridy = 2; // Move to the next row
        this.add(effectBox, gbc);
    }

    public static class SliderBox extends JPanel {
        JSlider slider;
        JLabel label;

        public SliderBox(JSlider slider, JLabel label) {
            this.setOpaque(false);
            this.setLayout(new GridLayout(1, 2)); // Horizontal layout for label and slider

            this.label = label;
            label.setOpaque(false);
            this.add(label);
            label.setFont(new Font("Arial", Font.PLAIN, 40));
            label.setForeground(Color.WHITE);

            slider.setBackground(new Color(153, 98, 76)); // Transparent background
            this.slider = slider;
            this.add(slider);
        }

        public JSlider getSlider() {
            return slider;
        }
    }

    public JSlider getMasterSlider() {
        return masterBox.getSlider();
    }

    public JSlider getMusicSlider() {
        return musicBox.getSlider();
    }

    public JSlider getSoundSlider() {
        return effectBox.getSlider();
    }

}
