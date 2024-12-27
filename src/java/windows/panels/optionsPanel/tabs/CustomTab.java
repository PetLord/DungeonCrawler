package windows.panels.optionsPanel.tabs;

import javax.swing.*;
import java.awt.*;

public class CustomTab extends JPanel {
    CustomTabType type;

    public CustomTab(CustomTabType type) {
        this.type = type;
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
    }

}
