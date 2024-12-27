package windows.panelElements.buttons;

import windows.panels.CustomPanel;

public class FullScreenButton extends CustomButton {
    public FullScreenButton(CustomPanel panel) {
        super("Full Screen", panel);
        this.addActionListener(e -> buttonPressed());
    }

    public void buttonPressed() {
        panel.toggleFullScreen();
    }

}
