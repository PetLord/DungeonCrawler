package characters;
import characterClasses.*;
import stats.CharacterStat;

public class Character{
    protected String name;
    CharacterStat characterStat;
    CharacterClass characterClass;

    public Character(String name, int health, CharacterClass characterClass){
        this.name = name;
    }


}