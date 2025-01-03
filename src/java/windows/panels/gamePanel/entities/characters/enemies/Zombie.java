package windows.panels.gamePanel.entities.characters.enemies;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.components.FaceDirection;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.factories.StatFactory;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.*;
import java.awt.geom.Point2D;

public class Zombie extends Enemy{
    public Zombie(String name, int width, int height, GamePanel gamePanel, Room myRoom) {
        super(name, width, height, StatFactory.getZombieStat(), gamePanel, myRoom);
        this.characterStat = StatFactory.getZombieStat();
    }

    @Override
    public void update() {

    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public Point2D getHandPosition(FaceDirection direction) {
        return new Point2D.Double(0,0);
    }

    @Override
    public CharacterStat getStats() {
        return this.characterStat;
    }
}
