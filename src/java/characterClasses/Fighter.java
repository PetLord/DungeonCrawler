package characterClasses;

import stats.FighterStatDecorator;
import stats.CharacterStat;

public class Fighter implements CharacterClass {
    private String name;
    private FighterStatDecorator statDecorator;

    public Fighter(CharacterStat baseStat) {
        this.name = "Fighter";
        this.statDecorator = new FighterStatDecorator(baseStat);
    }

    public String getName() {
        return name;
    }

    public FighterStatDecorator getStats() {
        return statDecorator;
    }

}
