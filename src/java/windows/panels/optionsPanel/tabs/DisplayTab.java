package windows.panels.optionsPanel.tabs;

import windows.panelElements.buttons.FullScreenButton;
import windows.panels.CustomPanel;

import javax.swing.*;
import java.awt.*;

public class DisplayTab extends CustomTab {
    CustomPanel panel;

    public DisplayTab(CustomPanel panel) {
        super(CustomTabType.DISPLAY);
        this.panel = panel;

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(20, 20, 20, 20); // Add padding: top, left, bottom, right
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        gbc.fill = GridBagConstraints.NONE; // Do not stretch

        // Add your button(s)
        FullScreenButton fullScreenButton = new FullScreenButton(panel);
        this.add(fullScreenButton, gbc);
    }
}
