package windows.panels.gamePanel.characterProfessions;
import windows.panels.gamePanel.stats.CharacterStat;
import windows.panels.gamePanel.stats.CharacterStatDecorator;

public interface CharacterProfession {
     String name = "";
     CharacterStat characterStat = new CharacterStatDecorator();

     String getName();
     CharacterStat getStats();
}
