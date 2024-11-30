package characterClasses.playableCharacters;

import characterClasses.CharacterClass;
import stats.FighterStatDecorator;
import stats.CharacterStat;

public class Fighter implements CharacterClass {
    private String name;
    private CharacterStat statDecorator;

    public Fighter(CharacterStat baseStat) {
        this.name = "Fighter";
        this.statDecorator = new FighterStatDecorator(baseStat);
    }

    public String getName() {
        return name;
    }

    public CharacterStat getStats() {
        return statDecorator;
    }

}
