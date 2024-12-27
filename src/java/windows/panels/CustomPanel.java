package windows.panels;

import windows.MainFrame;
import windows.panelElements.cursors.CursorType;
import windows.panelElements.cursors.CustomCursor;

import javax.swing.*;

public abstract class CustomPanel extends JPanel {
    protected int width;
    protected int height;
    protected MainFrame mainFrame;
    public abstract void onPanelActivation(PanelType previousPanelType);
    public abstract void onPanelDeactivation(PanelType newPanelType);

    public CustomPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setCustomCursor(CursorType.POINTER);
    }

    public void setCustomCursor(CursorType cursorType) {
        CustomCursor customCursor = mainFrame.getCursor(cursorType);
        customCursor.applyToComponent(this);
    }

    public void toggleFullScreen() {
        mainFrame.toggleFullScreen();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
