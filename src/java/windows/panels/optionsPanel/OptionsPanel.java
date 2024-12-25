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
    private Image backImage;
    private int width;
    private int height;
    private OptionsTabbedPane optionsTabbedPane;
    public OptionsPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.setLayout(new BorderLayout());
        width = Toolkit.getDefaultToolkit().getScreenSize().width;
        height = Toolkit.getDefaultToolkit().getScreenSize().height;
        backImage = getBackImage();
        optionsTabbedPane = new OptionsTabbedPane(this);
        this.add(optionsTabbedPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(20);
        buttonsPanel.setLayout(flowLayout);

        CustomButton defaultButton = new CustomButton("Default", this);
        CustomButton applyButton = new CustomButton("Apply", this);
        CustomButton backButton = new CustomButton("Back", this);
        defaultButton.addActionListener(e -> defaultButtonPressed());
        applyButton.addActionListener(e -> applyButtonPressed());
        backButton.addActionListener(e -> backButtonPressed());
        buttonsPanel.add(defaultButton);
        buttonsPanel.add(applyButton);
        buttonsPanel.add(backButton);


        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void onPanelActivation() {

    }

    @Override
    public void onPanelDeactivation() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backImage, 0, 0, width, height, this);
    }

    private void defaultButtonPressed() {
        // Set all options to default
    }

    private void applyButtonPressed() {
        // Apply the changes
    }

    private void backButtonPressed() {
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
}
