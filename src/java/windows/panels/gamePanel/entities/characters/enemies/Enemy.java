package windows.panels.gamePanel.entities.characters.enemies;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.components.DamageComponent;
import windows.panels.gamePanel.entities.characters.Character;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.*;

public abstract class Enemy extends Character {
    public Enemy(String name, int width, int height, CharacterStat characterStat, GamePanel gamePanel, Room myRoom) {
        super(name, width, height, characterStat, gamePanel, myRoom);
    }

    public abstract void update();
    public abstract void render(Graphics2D g);


}
