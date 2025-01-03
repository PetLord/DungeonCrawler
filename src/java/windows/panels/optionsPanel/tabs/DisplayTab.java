package windows.panels.optionsPanel.tabs;

import settings.SettingsManager;
import windows.panelElements.buttons.FullScreenButton;
import windows.panelElements.buttons.ResolutionSelector;
import windows.panels.CustomPanel;

import java.awt.*;

public class DisplayTab extends CustomTab {
    CustomPanel panel;
    FullScreenButton fullScreenButton;
    ResolutionSelector resolutionSelector;

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
        resolutionSelector = new ResolutionSelector(panel.getMainFrame());
        fullScreenButton = new FullScreenButton(panel, resolutionSelector);
        this.add(fullScreenButton, gbc);
        gbc.gridy++;
        this.add(resolutionSelector, gbc);
    }

    public int getResolutionWidth() {
        return resolutionSelector.getResolution().getFirst();
    }

    public int getResolutionHeight() {
        return resolutionSelector.getResolution().getSecond();
    }

    public void saveSettings() {
        SettingsManager settingsManager = SettingsManager.getInstance();
        settingsManager.saveResolution(getResolutionWidth(), getResolutionHeight());
        settingsManager.saveFullScreen(fullScreenButton.isFullScreen());
    }

    public void loadSettings() {
        SettingsManager settingsManager = SettingsManager.getInstance();
        resolutionSelector.setResolution(settingsManager.getSavedResolution());
        fullScreenButton.setFullScreen(settingsManager.getSavedFullScreen());
    }
}
