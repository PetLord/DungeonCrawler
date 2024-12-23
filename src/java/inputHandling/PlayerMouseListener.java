package inputHandling;

import objects.characters.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerMouseListener implements MouseListener {
    private final Player player;

    public PlayerMouseListener(Player player) {
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> player.playerLeftClick();
            case MouseEvent.BUTTON3 -> player.playerRightClick();
            default -> { }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
