package objects.characters;

import characterProfessions.CharacterProfession;
import components.Direction;
import gameWindow.GamePanel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Enemy extends Character {
    public Enemy(CharacterProfession characterProfession, int width, int height, GamePanel gamePanel) {
        super(characterProfession.getName() ,characterProfession, width, height, gamePanel);
    }

    public void update() {

    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public Point2D getHandPosition(Direction direction) {
        return null;
    }
}
