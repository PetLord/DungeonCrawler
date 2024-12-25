package windows.panels;

import windows.MainFrame;
import windows.panelElements.cursors.CursorType;
import windows.panelElements.cursors.CustomCursor;

import javax.swing.*;

public abstract class CustomPanel extends JPanel {
    protected MainFrame mainFrame;
    public abstract void onPanelActivation();
    public abstract void onPanelDeactivation();

    public CustomPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setCustomCursor(CursorType.POINTER);
    }

    public void setCustomCursor(CursorType cursorType) {
        CustomCursor customCursor = mainFrame.getCursor(cursorType);
        customCursor.applyToComponent(this);
    }

}
