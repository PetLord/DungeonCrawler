package components;

import gameWindow.GamePanel;

import inputHandling.PlayerKeyboardListener;
import inputHandling.PlayerMouseListener;
import objects.characters.Player;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class PlayerInputComponent {
    private final Player player;
    private final KeyListener keylistener;
    private final MouseListener mouselistener;
    private GamePanel gamePanel;

    public PlayerInputComponent(Player player, GamePanel gamePanel) {
        this.player = player;
        this.keylistener = new PlayerKeyboardListener(player);
        this.mouselistener = new PlayerMouseListener(player);
        this.gamePanel = gamePanel;
        gamePanel.addKeyListener(keylistener);
        gamePanel.addMouseListener(mouselistener);
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void addKeyListener() {
        gamePanel.addKeyListener(keylistener);
    }
}
