package windows;

import windows.panelElements.cursors.*;
import windows.panels.CustomPanel;
import windows.panels.PanelType;
import windows.panels.gamePanel.GamePanel;
import windows.panels.menuPanel.MenuPanel;
import windows.panels.optionsPanel.OptionsPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final CardLayout cardLayout;
    private Map<CursorType, CustomCursor> cursors;
    private Map<PanelType, CustomPanel> panels;
    private int height;
    private int width;
    private PanelType currentPanel; // Tracks the active panel

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setTitle("Dungeon Crawler");
        this.height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setSize(width, height);
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Color.BLACK);

        this.createCursors();
        this.createPanels();

        this.pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setVisible(true);

        // Start with the main menu
        switchToPanel(PanelType.MAIN_MENU);
    }

    private void createPanels() {
        panels = new HashMap<>();
        MenuPanel menuPanel = new MenuPanel(this);
        GamePanel gamepanel = new GamePanel(this);
        OptionsPanel optionsPanel = new OptionsPanel(this);
        currentPanel = PanelType.MAIN_MENU;

        panels.put(PanelType.GAME, gamepanel);
        panels.put(PanelType.MAIN_MENU, menuPanel);
        panels.put(PanelType.OPTIONS_MENU, optionsPanel);
        this.add(menuPanel, PanelType.MAIN_MENU.toString());
        this.add(gamepanel, PanelType.GAME.toString());
        this.add(optionsPanel, PanelType.OPTIONS_MENU.toString());
    }

    public void switchToPanel(PanelType panelType) {
        if (panelType == currentPanel) {
            return; // Prevent redundant switching
        }
        panels.get(currentPanel).onPanelDeactivation();
        panels.get(panelType).onPanelActivation();

        cardLayout.show(this.getContentPane(), panelType.toString());
        currentPanel = panelType; // Update current panel
    }

    private void createCursors() {
        cursors = new HashMap<>();
        cursors.put(CursorType.POINTER, new Pointer());
        cursors.put(CursorType.OPEN_HAND, new OpenHand());
        cursors.put(CursorType.GRAB_HAND, new GrabHand());
    }

    public CustomCursor getCursor(CursorType cursorType) {
        return cursors.get(cursorType);
    }
}
