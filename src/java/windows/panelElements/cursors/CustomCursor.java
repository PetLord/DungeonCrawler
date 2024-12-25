package windows.panelElements.cursors;

import java.awt.*;

public abstract class CustomCursor {
    private CursorType cursorType;
    public abstract Image getImage();
    public abstract void applyToComponent(Component component);

    public CustomCursor(CursorType cursorType) {
        this.cursorType = cursorType;
    }

}
