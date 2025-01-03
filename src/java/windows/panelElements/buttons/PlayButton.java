package windows.panelElements.buttons;

import windows.MainFrame;
import windows.panels.CustomPanel;
import windows.panels.PanelType;


public class PlayButton extends CustomButton {
    MainFrame mainFrame;

    public PlayButton(CustomPanel panel, MainFrame mainFrame) {
        super("Play", panel);
        this.addActionListener(e -> openGame());
        this.mainFrame = mainFrame;
    }

    private void openGame() {
        mainFrame.switchToPanel(PanelType.GAME);
    }
}
