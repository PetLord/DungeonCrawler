package characterProfessions;
import stats.CharacterStat;
import stats.CharacterStatDecorator;

public interface CharacterProfession {
     String name = "";
     CharacterStat characterStat = new CharacterStatDecorator();

     String getName();
     CharacterStat getStats();
}
