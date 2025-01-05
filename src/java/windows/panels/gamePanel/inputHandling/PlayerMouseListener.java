package windows.panels.gamePanel.inputHandling;

import windows.panels.gamePanel.entities.characters.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerMouseListener extends MouseAdapter {
    private final Player player;

    public PlayerMouseListener(Player player) {
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> player.playerLeftClick();
            case MouseEvent.BUTTON3 -> player.playerRightClick(e.getX() - player.getGameWorld().getOffsetX(), e.getY() - player.getGameWorld().getOffsetY());
            default -> { }
        }
    }

}
