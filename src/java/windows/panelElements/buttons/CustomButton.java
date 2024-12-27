package windows.panelElements.buttons;

import windows.panelElements.cursors.CursorType;
import windows.panels.CustomPanel;

import java.awt.*;
import java.awt.event.*;

public class CustomButton extends Button {
    private final Color defaultBackground;
    private final Color clickBackground;
    private final Color hoverColor;
    CustomPanel panel;

    public CustomButton(String text, CustomPanel panel) {
        super(text);
        this.panel = panel;

        // Default appearance
        defaultBackground = new Color(153, 98, 76); // Default background color
        hoverColor = new Color(134, 77, 52);        // Color on hover
        clickBackground = new Color(94, 54, 33);    // Color on click

        setFont(new Font("Arial", Font.PLAIN, 50));
        setBackground(defaultBackground);
        setForeground(Color.WHITE);
        this.setFocusable(false);
        // Mouse listener for hover and click effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(clickBackground); // Change color when pressed
                panel.setCustomCursor(CursorType.GRAB_HAND);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor); // Change color when hovered
                panel.setCustomCursor(CursorType.OPEN_HAND);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultBackground); // Revert to default when exited
                panel.setCustomCursor(CursorType.POINTER);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (contains(e.getPoint())) {
                    setBackground(hoverColor); // Stay in hover color if mouse is still over the button
                    panel.setCustomCursor(CursorType.OPEN_HAND);
                } else {
                    setBackground(defaultBackground); // Revert to default otherwise
                    panel.setCustomCursor(CursorType.POINTER);
                }
            }
        });
    }

}
