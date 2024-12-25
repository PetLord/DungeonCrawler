package windows.panels.optionsPanel;

import windows.panels.CustomPanel;
import windows.panels.optionsPanel.tabs.AudioTab;
import windows.panels.optionsPanel.tabs.CustomTab;
import windows.panels.optionsPanel.tabs.DisplayTab;
import windows.panels.optionsPanel.tabs.CustomTabType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class OptionsTabbedPane extends JTabbedPane {
    Map<CustomTabType, CustomTab> tabs = new HashMap<>();
    CustomPanel panel;

    public OptionsTabbedPane(CustomPanel panel) {
        super();
        this.panel = panel;
        createTabs();
        this.setOpaque(false); // Make the tabbed pane background transparent
        setBackground(new Color(0, 0, 0, 0)); // Fully transparent background for the whole tabbed pane
        setFont(new Font("Arial", Font.PLAIN, 50));

        // Apply custom UI for padding and styling the tab headers
        this.setUI(new CustomTabbedPaneUI(10));
    }

    public void createTabs() {
        AudioTab audioTab = new AudioTab(panel);
        DisplayTab displayTab = new DisplayTab(panel);

        tabs.put(CustomTabType.AUDIO, audioTab);
        tabs.put(CustomTabType.DISPLAY, displayTab);

        this.addTab("Audio", audioTab);
        this.addTab("Display", displayTab);
    }

    // Custom TabbedPaneUI class to customize tab headers
    private static class CustomTabbedPaneUI extends BasicTabbedPaneUI {
        private int tabMargin;
        Color defaultColor = new Color(153, 98, 76); // Default background color
        Color activeColor = new Color(134, 77, 52);  // Color on click

        public CustomTabbedPaneUI(int tabMargin) {
            this.tabMargin = tabMargin;
        }

        @Override
        protected void installDefaults() {
            super.installDefaults();
        }

        @Override
        protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            // Set the color for the tab button background (only for the tab header area)
            g.setColor(isSelected ? activeColor : defaultColor); // Change color based on selection
            g.fillRect(x, y, w, h); // Draw the background for the tab header
        }

        @Override
        protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
            for (int i = 0; i < rects.length; i++) {
                if (i > 0) {
                    rects[i].x += i * tabMargin; // Add margin between tabs
                }
            }
            super.paintTabArea(g, tabPlacement, selectedIndex);
        }

        @Override
        protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            // Do nothing to avoid painting content border (we don't want any background in the content area)
        }
    }
}
