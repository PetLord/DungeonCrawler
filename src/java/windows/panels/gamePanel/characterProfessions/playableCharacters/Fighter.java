package windows.panels.gamePanel.characterProfessions.playableCharacters;

import windows.panels.gamePanel.characterProfessions.CharacterProfession;
import windows.panels.gamePanel.stats.FighterStatDecorator;
import windows.panels.gamePanel.stats.CharacterStat;

public class Fighter implements CharacterProfession {
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
