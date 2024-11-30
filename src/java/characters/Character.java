package characters;
import characterClasses.*;
import stats.CharacterStat;

public class Character{
    protected String name;
    CharacterClass characterClass;
    CharacterStat characterStat;

    public Character(String name, CharacterClass characterClass){
        this.name = name;
        this.characterClass = characterClass;
        this.characterStat = characterClass.getStats();
    }

    public String getName() {
        return name;
    }

    public CharacterStat getCharacterStat() {
        return characterStat;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}