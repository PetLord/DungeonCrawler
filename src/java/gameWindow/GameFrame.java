package gameWindow;

import javax.swing.*;

public class GameFrame extends JFrame {
    private GamePanel gamepanel;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Dungeon Crawler");
        //this.setUndecorated(true);

        gamepanel = new GamePanel();
        this.add(gamepanel);

        this.pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setVisible(true);
    }

    public GamePanel getGamePanel() {
        return gamepanel;
    }
}
