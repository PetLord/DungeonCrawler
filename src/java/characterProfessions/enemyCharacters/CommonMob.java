package characterProfessions.enemyCharacters;

import stats.CharacterStat;
import stats.FighterStatDecorator;

public class CommonMob implements MobTypeI {
    private String name;
    private CharacterStat statDecorator;

    public CommonMob(String name, CharacterStat baseStat) {
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
