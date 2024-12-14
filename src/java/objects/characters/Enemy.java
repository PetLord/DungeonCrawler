package objects.characters;

import characterProfessions.CharacterProfession;

import java.awt.*;

public class Enemy extends Character {
    public Enemy(CharacterProfession characterProfession, int width, int height) {
        super(characterProfession.getName() ,characterProfession, width, height);
    }

    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
