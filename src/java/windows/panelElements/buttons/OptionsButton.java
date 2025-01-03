package windows.panelElements.buttons;

import windows.MainFrame;
import windows.panels.CustomPanel;
import windows.panels.PanelType;

public class OptionsButton extends CustomButton {
    MainFrame mainFrame;

    public OptionsButton(CustomPanel panel, MainFrame mainFrame) {
        super("Options", panel);
        this.mainFrame = mainFrame;
        this.addActionListener(e -> openOptions());
    }

    private void openOptions() {
        mainFrame.switchToPanel(PanelType.OPTIONS_MENU);
    }
}
