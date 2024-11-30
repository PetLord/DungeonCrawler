package characterProfessions.enemyCharacters;

import characterProfessions.CharacterProfession;
import stats.CharacterStat;
import stats.CharacterStatDecorator;

public interface MobTypeI extends CharacterProfession {
    String name = "";
    CharacterStat statDecorator = new CharacterStatDecorator();
    String rarity = "";

    String getName();
    CharacterStat getStats();
    String getRarity();

}
