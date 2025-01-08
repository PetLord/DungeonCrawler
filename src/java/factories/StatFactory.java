package factories;

import windows.panels.gamePanel.stats.CharacterStat;
import windows.panels.gamePanel.stats.WeaponStat;

import java.util.Random;

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
        int attackDamage = 50;
        int abilityPower = 1;
        double attackSpeed = 0.75;
        double movementSpeed = 1.5;
        double criticalStrikeChance = 1;
        double criticalStrikeDamage = 2;
        double lifeSteal = 0;
        double spellVamp = 0;

        return new CharacterStat(health, mana, strength, dexterity, intelligence, armor, magicResistance, attackDamage, abilityPower, attackSpeed, movementSpeed, criticalStrikeChance, criticalStrikeDamage, lifeSteal, spellVamp);
    }

    //private int damage;
    //    private int range;
    //    private double attackSpeed;
    //    private double reloadSpeed;

    public static WeaponStat getDefaultWeaponStat(){
        int damage = 5;
        double range = 1;
        double attackSpeed = 2;
        double knockBack = 2;

        return new WeaponStat(damage, range, attackSpeed, knockBack);
    }

    public static CharacterStat getZombieStat(){
        int health = 100;
        int mana = 0;
        int strength = 10;
        int dexterity = 1;
        int intelligence = 1;
        int armor = 1;
        int magicResistance = 1;
        int attackDamage = 1;
        int abilityPower = 1;
        double attackSpeed = 1;
        double movementSpeed = 1;
        double criticalStrikeChance = 0;
        double criticalStrikeDamage = 1;
        double lifeSteal = 0;
        double spellVamp = 0;

        return new CharacterStat(health, mana, strength, dexterity, intelligence, armor, magicResistance, attackDamage, abilityPower, attackSpeed, movementSpeed, criticalStrikeChance, criticalStrikeDamage, lifeSteal, spellVamp);
    }

    public static CharacterStat getSlimeStat(){
        Random random = new Random();
        int health = 40 + random.nextInt(20);
        int mana = 0;
        int strength = 1;
        int dexterity = 1;
        int intelligence = 1;
        int armor = 1;
        int magicResistance = 1;
        int attackDamage = random.nextInt(2) + 1;
        int abilityPower = 1;
        int attackSpeed = 1;
        double movementSpeed = random.nextDouble() + 1;
        double criticalStrikeChance = 0;
        double criticalStrikeDamage = 1;
        double lifeSteal = 0;
        double spellVamp = 0;

        return new CharacterStat(health, mana, strength, dexterity, intelligence, armor, magicResistance, attackDamage, abilityPower, attackSpeed, movementSpeed, criticalStrikeChance, criticalStrikeDamage, lifeSteal, spellVamp);
    }

    public static CharacterStat getMagmaSlimeStat(){
        Random random = new Random();
        int health = 50 + random.nextInt(20);
        int mana = 0;
        int strength = 1;
        int dexterity = 1;
        int intelligence = 1;
        int armor = 1;
        int magicResistance = 1;
        int attackDamage = random.nextInt(3) + 1;
        int abilityPower = 1;
        int attackSpeed = 1;
        double movementSpeed = (random.nextDouble() + 1) / 2;
        double criticalStrikeChance = 0;
        double criticalStrikeDamage = 1;
        double lifeSteal = 0;
        double spellVamp = 0;

        return new CharacterStat(health, mana, strength, dexterity, intelligence, armor, magicResistance, attackDamage, abilityPower, attackSpeed, movementSpeed, criticalStrikeChance, criticalStrikeDamage, lifeSteal, spellVamp);
    }

    public static CharacterStat getMagmaBossStat(){
        Random random = new Random();
        int health = 500;
        int mana = 0;
        int strength = 1;
        int dexterity = 1;
        int intelligence = 1;
        int armor = 1;
        int magicResistance = 1;
        int attackDamage = 5;
        int abilityPower = 1;
        int attackSpeed = 1;
        double movementSpeed = 0.5;
        double criticalStrikeChance = 0;
        double criticalStrikeDamage = 1;
        double lifeSteal = 0;
        double spellVamp = 0;

        return new CharacterStat(health, mana, strength, dexterity, intelligence, armor, magicResistance, attackDamage, abilityPower, attackSpeed, movementSpeed, criticalStrikeChance, criticalStrikeDamage, lifeSteal, spellVamp);
    }


}
