package windows.panels.gamePanel.factories;

import windows.panels.gamePanel.stats.CharacterStat;
import windows.panels.gamePanel.stats.WeaponStat;

public abstract class StatFactory {

    //protected int health;
    //    protected int mana;
    //    protected int strength;
    //    protected int dexterity;
    //    protected int intelligence;
    //    protected int armor;
    //    protected int magicResistance;
    //    protected int attackDamage;
    //    protected int abilityPower;
    //    protected int attackSpeed;
    //    protected int movementSpeed;
    //    protected int criticalStrikeChance;
    //    protected int criticalStrikeDamage;
    //    protected int lifeSteal;
    //    protected int spellVamp;

    public static CharacterStat getDefaultCharacterStat(){
        int health = 10;
        int mana = 10;
        int strength = 1;
        int dexterity = 1;
        int intelligence = 1;
        int armor = 1;
        int magicResistance = 1;
        int attackDamage = 1;
        int abilityPower = 1;
        int attackSpeed = 1;
        int movementSpeed = 4;
        int criticalStrikeChance = 1;
        int criticalStrikeDamage = 1;
        int lifeSteal = 1;
        int spellVamp = 1;

        return new CharacterStat(health, mana, strength, dexterity, intelligence, armor, magicResistance, attackDamage, abilityPower, attackSpeed, movementSpeed, criticalStrikeChance, criticalStrikeDamage, lifeSteal, spellVamp);
    }

    //private int damage;
    //    private int range;
    //    private double attackSpeed;
    //    private double reloadSpeed;

    public static WeaponStat getDefaultWeaponStat(){
        int damage = 5;
        int range = 1;
        double attackSpeed = 2;

        return new WeaponStat(damage, range, attackSpeed);
    }
}
