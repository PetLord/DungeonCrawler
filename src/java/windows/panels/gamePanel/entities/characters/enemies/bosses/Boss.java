package windows.panels.gamePanel.entities.characters.enemies.bosses;

import windows.panels.gamePanel.GamePanel;

import windows.panels.gamePanel.entities.characters.enemies.Enemy;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.stats.CharacterStat;

public abstract class Boss extends Enemy {
    // ability handling comes here
    public Boss(String name, int width, int height, CharacterStat characterStat, GamePanel gamePanel, Room myRoom) {
        super(name, width, height, characterStat, gamePanel, myRoom);
    }

}
