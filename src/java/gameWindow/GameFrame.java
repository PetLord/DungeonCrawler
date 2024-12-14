package gameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;

public class GameFrame extends JFrame {
    private GamePanel gamepanel;
    private int height;
    private int width;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setTitle("Dungeon Crawler");
        this.height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
        //this.setUndecorated(true);

        gamepanel = new GamePanel(this);
        this.add(gamepanel);
        this.pack();
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setVisible(true);
    }


    public GamePanel getGamePanel() {
        return gamepanel;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
