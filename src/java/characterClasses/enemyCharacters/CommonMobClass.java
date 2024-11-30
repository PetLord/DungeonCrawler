package characterClasses.enemyCharacters;

import stats.CharacterStat;
import stats.FighterStatDecorator;

public class CommonMobClass implements MobClassI {
    private String name;
    private CharacterStat statDecorator;

    public CommonMobClass(String name, CharacterStat baseStat) {
        this.name = name;
        this.statDecorator = new FighterStatDecorator(baseStat);
    }

    public String getName() {
        return name;
    }

    public CharacterStat getStats() {
        return statDecorator;
    }

    public String getRarity() {
        return "";
    }
}
