package windows.panels.menuPanel;

import audio.Sound;
import audio.SoundFactory;
import windows.MainFrame;
import windows.panelElements.buttons.ExitButton;
import windows.panelElements.buttons.OptionsButton;
import windows.panelElements.buttons.PlayButton;
import windows.panels.CustomPanel;
import windows.panels.PanelType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MenuPanel extends CustomPanel {
    private final GridBagLayout gb;
    private final GridBagConstraints gbc;
    private final Image backImage;
    private Sound currentSound;


    public MenuPanel(MainFrame mainFrame) {
        super(mainFrame);
        gb = new GridBagLayout();
        gbc = new GridBagConstraints();
        width = mainFrame.getWidth();
        height = mainFrame.getHeight();
        setPreferredSize(new Dimension(width, height));
        backImage = getBackImage();

        handleLayout();
    }

    private void handleLayout(){
        this.setLayout(gb);

        // Set default GridBagConstraints
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around buttons
        gbc.fill = GridBagConstraints.NONE; // Do not stretch buttons
        gbc.anchor = GridBagConstraints.CENTER; // Center buttons horizontally and vertically
        gbc.weightx = 0; // No extra horizontal space
        gbc.weighty = 1; // Allow vertical space to distribute

        // Add Play button (row 0)
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.weighty = 0; // Set to 0 so buttons don't stretch vertically
        Button button1 = new PlayButton(this, mainFrame);
        add(button1, gbc);

        // Add Options button (row 1)
        gbc.gridx = 0; // Same column (0), different row (1)
        gbc.gridy = 1; // Row 1
        Button button2 = new OptionsButton(this, mainFrame);
        add(button2, gbc);

        // Add Exit button (row 2)
        gbc.gridx = 0; // Same column (0), different row (2)
        gbc.gridy = 2; // Row 2
        Button button3 = new ExitButton(this);
        add(button3, gbc);

        // Add the control to center the panel (this panel will be centered in the JFrame)
        gbc.weighty = 1; // Allow vertical space to center the buttons
        gbc.gridheight = 1; // Buttons should not stretch vertically, no span
    }

    private void playMenuSound(){
        Random rand = new Random();
        currentSound = switch(rand.nextInt(4)) {
            default -> SoundFactory.getMenuSound1();
            case 1 -> SoundFactory.getMenuSound2();
            case 2 -> SoundFactory.getMenuSound3();
            case 3 -> SoundFactory.getMenuSound4();
        };
        mainFrame.playSound(currentSound);
    }


    private static Image getBackImage(){
        try {
            return ImageIO.read(new File("resources/images/menu/orangeMenuBack.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backImage, 0, 0, width, height, this);
    }

    @Override
    public void onPanelActivation(PanelType previousPanelType) {
        if(previousPanelType != PanelType.OPTIONS_MENU){
            playMenuSound();
        }
    }

    @Override
    public void onPanelDeactivation(PanelType newPanelType) {
        if(newPanelType != PanelType.OPTIONS_MENU){
            mainFrame.stopSound(currentSound);
        }
    }
}
