package objects.characters;

import characterProfessions.CharacterProfession;

public class Enemy extends Character {
    public Enemy(CharacterProfession characterProfession) {
        super(characterProfession.getName() ,characterProfession);
    }

    public void update() {

    }

}
