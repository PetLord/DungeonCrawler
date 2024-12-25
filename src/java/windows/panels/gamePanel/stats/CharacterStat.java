package windows.panels.gamePanel.stats;

public class CharacterStat {
    protected int health;
    protected int mana;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int armor;
    protected int magicResistance;
    protected int attackDamage;
    protected int abilityPower;
    protected int attackSpeed;
    protected int movementSpeed;
    protected int criticalStrikeChance;
    protected int criticalStrikeDamage;
    protected int lifeSteal;
    protected int spellVamp;

    public CharacterStat(int health, int mana, int strength, int dexterity, int intelligence, int armor, int magicResistance, int attackDamage, int abilityPower, int attackSpeed, int movementSpeed, int criticalStrikeChance, int criticalStrikeDamage, int lifeSteal, int spellVamp){
        this.health = health;
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

    public int getHealth() {
        return health;
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

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getCriticalStrikeChance() {
        return criticalStrikeChance;
    }

    public int getCriticalStrikeDamage() {
        return criticalStrikeDamage;
    }

    public int getLifeSteal() {
        return lifeSteal;
    }

    public int getSpellVamp() {
        return spellVamp;
    }
}
