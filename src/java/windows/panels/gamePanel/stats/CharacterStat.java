package windows.panels.gamePanel.stats;

public class CharacterStat {
    protected int maxHealth;
    protected int mana;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int armor;
    protected int magicResistance;
    protected int attackDamage;
    protected int abilityPower;
    protected double attackSpeed;
    protected double movementSpeed;
    protected double criticalStrikeChance;
    protected double criticalStrikeDamage;
    protected double lifeSteal;
    protected double spellVamp;

    public CharacterStat(int health, int mana, int strength, int dexterity, int intelligence, int armor, int magicResistance, int attackDamage, int abilityPower, double attackSpeed, double movementSpeed, double criticalStrikeChance, double criticalStrikeDamage, double lifeSteal, double spellVamp){
        this.maxHealth = health;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.armor = armor;
        this.magicResistance = magicResistance;
        this.attackDamage = attackDamage;
        this.abilityPower = abilityPower;
        this.attackSpeed = attackSpeed;
        this.movementSpeed = movementSpeed;
        this.criticalStrikeChance = criticalStrikeChance;
        this.criticalStrikeDamage = criticalStrikeDamage;
        this.lifeSteal = lifeSteal;
        this.spellVamp = spellVamp;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getArmor() {
        return armor;
    }

    public int getMagicResistance() {
        return magicResistance;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAbilityPower() {
        return abilityPower;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public double getCriticalStrikeChance() {
        return criticalStrikeChance;
    }

    public double getCriticalStrikeDamage() {
        return criticalStrikeDamage;
    }

    public double getLifeSteal() {
        return lifeSteal;
    }

    public double getSpellVamp() {
        return spellVamp;
    }
}
