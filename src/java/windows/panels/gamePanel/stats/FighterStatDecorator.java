package windows.panels.gamePanel.stats;

public class FighterStatDecorator extends CharacterStatDecorator {

    public FighterStatDecorator(CharacterStat baseStat) {
        super(baseStat);
    }

    @Override
    public int getStrength() {
        return super.getStrength() + 5;
    }

    @Override
    public int getDexterity() {
        return super.getDexterity() + 5;
    }

    @Override
    public int getHealth() {
        return super.getHealth() + 10;
    }
}
