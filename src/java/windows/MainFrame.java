package windows;

import audio.Sound;
import audio.SoundFactory;
import audio.SoundPlayer;
import windows.panelElements.cursors.*;
import windows.panels.CustomPanel;
import windows.panels.PanelType;
import windows.panels.gameOverPanel.GameOverPanel;
import windows.panels.gamePanel.GamePanel;
import windows.panels.menuPanel.MenuPanel;
import windows.panels.optionsPanel.OptionsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final CardLayout cardLayout;
    private Map<CursorType, CustomCursor> cursors;
    private Map<PanelType, CustomPanel> panels;
    private SoundPlayer soundPlayer;
    private int height;
    private int width;
    private PanelType currentPanel; // Tracks the active panel
    private final GraphicsDevice gd;

    public MainFrame() {
        this.setResizable(false);
        this.setTitle("Dungeon Crawler");
        this.setDimension(1280, 720);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2);
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Color.BLACK);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gd = ge.getDefaultScreenDevice();

        this.handleClosing();
        this.createCursors();
        this.createPanels();
        this.createSoundPlayer();


        this.setVisible(true);
        switchToPanel(PanelType.MAIN_MENU);
        this.loadSettings();
    }

    private void handleClosing(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                closeOperation();
            }
        });
    }

    public void closeOperation(){
        soundPlayer.unloadAllSounds();
        saveSettings();
        System.exit(0);
    }

    private void saveSettings(){
        ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).saveSettings();
    }

    private void loadSettings( ){
        ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).loadSettings();
        applyResolutionSettings();
        applySoundSettings();
    }

    private void createSoundPlayer(){
        JSlider musicSlider = ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).getMusicSlider();
        JSlider soundSlider = ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).getSoundSlider();
        JSlider masterSlider = ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).getMasterSlider();
        soundPlayer = new SoundPlayer(musicSlider, soundSlider, masterSlider);
        loadDefaultSounds();
    }

    public void loadDefaultSounds(){
        soundPlayer.loadSound(SoundFactory.getButtonClickSound());
    }

    private void createPanels() {
        panels = new HashMap<>();
        MenuPanel menuPanel = new MenuPanel(this);
        GamePanel gamepanel = new GamePanel(this);
        OptionsPanel optionsPanel = new OptionsPanel(this);
        GameOverPanel gameOverPanel = new GameOverPanel(this);

        panels.put(PanelType.GAME, gamepanel);
        panels.put(PanelType.MAIN_MENU, menuPanel);
        panels.put(PanelType.OPTIONS_MENU, optionsPanel);
        panels.put(PanelType.GAME_OVER, gameOverPanel);
        this.add(menuPanel, PanelType.MAIN_MENU.toString());
        this.add(gamepanel, PanelType.GAME.toString());
        this.add(optionsPanel, PanelType.OPTIONS_MENU.toString());
        this.add(gameOverPanel, PanelType.GAME_OVER.toString());
    }

    public void switchToPanel(PanelType panelType) {
        if (panelType == currentPanel) {
            return; // Prevent redundant switching
        }
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).onPanelDeactivation(panelType);
        }

        panels.get(panelType).onPanelActivation(currentPanel);

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

    public void applySoundSettings(){
        soundPlayer.updateVolumes();
    }

    public void applyResolutionSettings(){
        this.width = ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).getResolutionWidth();
        this.height = ((OptionsPanel)panels.get(PanelType.OPTIONS_MENU)).getResolutionHeight();
        this.setSize(width, height);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2);
        notifyPanelSize();
    }

    public void playSound(Sound sound){
        soundPlayer.playSound(sound);
    }

    public void stopSound(Sound sound){
        if(sound == null){
            System.out.println("Sound is null");
            return;
        }
        soundPlayer.stopSound(sound.getSoundType());


    }

    public void toggleFullScreen() {
        this.dispose();
        if (this.getExtendedState() == JFrame.MAXIMIZED_BOTH || gd.getFullScreenWindow() != null) {
            this.setExtendedState(JFrame.NORMAL);
            this.setUndecorated(false);
            this.applyResolutionSettings();
            gd.setFullScreenWindow(null); // Exit fullscreen mode
        } else {
            // Switch to fullscreen mode
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setDimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
            this.setUndecorated(true);
            gd.setFullScreenWindow(this); // Enter fullscreen mode
            notifyPanelSize();
        }
        this.setVisible(true);
    }

    private void notifyPanelSize(){
        for(CustomPanel panel : panels.values()){
            panel.setDimensions(width, height);
        }
    }

    public GamePanel getGamePanel(){
        return (GamePanel)panels.get(PanelType.GAME);
    }

    public void setDimension(int width, int height){
        this.width = width;
        this.height = height;
        this.setSize(width, height);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public SoundPlayer getSoundPlayer(){
        return soundPlayer;
    }


}
