package gameWindow;
import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable {
    private final int screenWidth;
    private final int screenHeight;
    private Thread gameThread;

    public gamePanel() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenDimension.getWidth();
        screenHeight = (int) screenDimension.getHeight();
        this.setPreferredSize(screenDimension);

        this.setBackground(Color.BLACK);
    }

    void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null){
            update();
            repaint();
        }
    }

    void update(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
