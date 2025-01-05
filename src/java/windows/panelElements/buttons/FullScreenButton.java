package windows.panelElements.buttons;

import windows.panels.CustomPanel;

public class FullScreenButton extends CustomButton {
    private boolean isFullScreen = false;
    private final ResolutionSelector resolutionSelector;
    public FullScreenButton(CustomPanel panel, ResolutionSelector resolutionSelector) {
        super("Full Screen", panel);
        this.resolutionSelector = resolutionSelector;
        this.addActionListener(e -> buttonPressed());
    }

    public void buttonPressed() {
        isFullScreen = !isFullScreen;
        resolutionSelector.setEnabled(!isFullScreen);
        panel.toggleFullScreen();

    }

    public boolean isFullScreen() {
        return isFullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        isFullScreen = fullScreen;
        if (isFullScreen) {
            resolutionSelector.setEnabled(false);
            panel.toggleFullScreen();
        }
    }

}
