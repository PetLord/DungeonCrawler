package windows.panels.optionsPanel;

import windows.MainFrame;
import windows.panelElements.buttons.CustomButton;
import windows.panels.CustomPanel;
import windows.panels.PanelType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OptionsPanel extends CustomPanel {
    // buttons to add: fullscreen, sounds, music, back, apply, resolution (maybe)
    private final Image backImage;
    private final OptionsTabbedPane optionsTabbedPane;
    private final ButtonPanel buttonPanel;
    public OptionsPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.setLayout(new BorderLayout());
        backImage = getBackImage();
        optionsTabbedPane = new OptionsTabbedPane(this);
        this.add(optionsTabbedPane, BorderLayout.CENTER);

        buttonPanel = new ButtonPanel(this);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void onPanelActivation(PanelType previousPanelType) {
        if(previousPanelType == PanelType.GAME){
            buttonPanel.continueButton.setVisible(true);
            buttonPanel.exitGameButton.setVisible(true);
            buttonPanel.backButton.setVisible(false);
        } else {
            buttonPanel.continueButton.setVisible(false);
            buttonPanel.exitGameButton.setVisible(false);
            buttonPanel.backButton.setVisible(true);
        }
    }

    @Override
    public void onPanelDeactivation(PanelType newPanelType) {
        buttonPanel.continueButton.setVisible(false);
        buttonPanel.exitGameButton.setVisible(false);
        buttonPanel.backButton.setVisible(false);
    }

    public int getResolutionWidth() {
        return optionsTabbedPane.getResolutionWidth();
    }

    public int getResolutionHeight() {
        return optionsTabbedPane.getResolutionHeight();
    }

    public OptionsTabbedPane getOptionsTabbedPane() {
        return optionsTabbedPane;
    }

    public void saveSettings() {
        optionsTabbedPane.saveSettings();
    }

    public void loadSettings() {
        optionsTabbedPane.loadSettings();
    }

    public boolean isFullScreen() {
        return optionsTabbedPane.isFullScreen();
    }

    public class ButtonPanel extends JPanel{
        private final CustomButton defaultButton;
        private final CustomButton applyButton;
        private final CustomButton backButton;
        private final CustomButton continueButton;
        private final CustomButton exitGameButton;
        public ButtonPanel(CustomPanel customPanel){
            super();
            this.setOpaque(false);
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setHgap(20);
            this.setLayout(flowLayout);

            defaultButton = new CustomButton("Default", customPanel);
            applyButton = new CustomButton("Apply", customPanel);
            backButton = new CustomButton("Back", customPanel);
            continueButton = new CustomButton("Continue", customPanel);
            exitGameButton = new CustomButton("Exit Game", customPanel);

            defaultButton.addActionListener(e -> defaultButtonPressed());
            applyButton.addActionListener(e -> applyButtonPressed());
            backButton.addActionListener(e -> backButtonPressed());
            continueButton.addActionListener(e -> continueButtonPressed());
            exitGameButton.addActionListener(e -> exitGameButtonPressed());
            this.add(defaultButton);
            this.add(applyButton);
            this.add(backButton);
            this.add(continueButton);
            this.add(exitGameButton);
            exitGameButton.setVisible(false);
            continueButton.setVisible(false);
        }

        public CustomButton getContinueButton() {
            return continueButton;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backImage, 0, 0, width, height, this);
    }

    private void defaultButtonPressed() {
        getMasterSlider().setValue(50);
        getMusicSlider().setValue(50);
        getSoundSlider().setValue(50);

        applyButtonPressed();
    }

    private void applyButtonPressed() {
        mainFrame.applySoundSettings();
        mainFrame.applyResolutionSettings();
    }

    private void backButtonPressed() {
        mainFrame.switchToPanel(PanelType.MAIN_MENU);
    }

    private void continueButtonPressed() {
        mainFrame.switchToPanel(PanelType.GAME);
    }

    private void exitGameButtonPressed() {
        mainFrame.switchToPanel(PanelType.GAME);
        mainFrame.switchToPanel(PanelType.MAIN_MENU);
    }

    private static Image getBackImage(){
        try {
            return ImageIO.read(new File("resources/images/menu/orangeMenuBack.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSlider getMusicSlider() {
        return optionsTabbedPane.getMusicSlider();
    }

    public JSlider getSoundSlider() {
        return optionsTabbedPane.getSoundSlider();
    }

    public JSlider getMasterSlider() {
        return optionsTabbedPane.getMasterSlider();
    }



}
