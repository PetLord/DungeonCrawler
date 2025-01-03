package windows.panels.gameOverPanel;

import windows.MainFrame;
import windows.panelElements.buttons.CustomButton;
import windows.panels.CustomPanel;
import windows.panels.PanelType;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends CustomPanel{
    public GameOverPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0, 0, 0, 100));
        this.setOpaque(true);
        CustomButton exitToMenuButton = new CustomButton("Exit to Menu", this);
        exitToMenuButton.addActionListener(e -> exitToMenu());
        this.add(exitToMenuButton, BorderLayout.SOUTH);
    }

    private void exitToMenu() {
        mainFrame.switchToPanel(PanelType.MAIN_MENU);
    }

    @Override
    public void onPanelActivation(PanelType previousPanelType) {
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    @Override
    public void onPanelDeactivation(PanelType newPanelType) {

    }
}
