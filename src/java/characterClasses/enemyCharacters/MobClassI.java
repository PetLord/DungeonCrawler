package characterClasses.enemyCharacters;

import characterClasses.CharacterClass;
import stats.CharacterStat;
import stats.CharacterStatDecorator;

public interface MobClassI extends CharacterClass {
    String name = "";
    CharacterStat statDecorator = new CharacterStatDecorator();
    String rarity = "";

    String getName();
    CharacterStat getStats();
    String getRarity();

}
