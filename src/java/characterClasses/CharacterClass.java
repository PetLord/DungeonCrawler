package characterClasses;
import stats.CharacterStat;
import stats.CharacterStatDecorator;

public interface CharacterClass {
     String name = "";
     CharacterStat characterStat = new CharacterStatDecorator();

     String getName();
     CharacterStat getStats();
}
