package gameWindow;

import javax.swing.*;

public class gameFrame extends JFrame {
    private gamePanel gamepanel;

    public gameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Dungeon Crawler");
        //this.setUndecorated(true);

        gamepanel = new gamePanel();
        this.add(gamepanel);

        this.pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setVisible(true);
    }
}
