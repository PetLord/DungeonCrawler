package windows.panels.gamePanel.characterProfessions.enemyCharacters;

import windows.panels.gamePanel.characterProfessions.CharacterProfession;
import windows.panels.gamePanel.stats.CharacterStat;
import windows.panels.gamePanel.stats.CharacterStatDecorator;

public interface MobTypeI extends CharacterProfession {
    String name = "";
    CharacterStat statDecorator = new CharacterStatDecorator();
    String rarity = "";

    String getName();
    CharacterStat getStats();
    String getRarity();

}
