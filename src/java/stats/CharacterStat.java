package stats;

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

    protected int getHealth() {
        return health;
    }

    protected int getMana() {
        return mana;
    }

    protected int getStrength() {
        return strength;
    }

    protected int getDexterity() {
        return dexterity;
    }

    protected int getIntelligence() {
        return intelligence;
    }

    protected int getArmor() {
        return armor;
    }

    protected int getMagicResistance() {
        return magicResistance;
    }

    protected int getAttackDamage() {
        return attackDamage;
    }

    protected int getAbilityPower() {
        return abilityPower;
    }

    protected int getAttackSpeed() {
        return attackSpeed;
    }

    protected int getMovementSpeed() {
        return movementSpeed;
    }

    protected int getCriticalStrikeChance() {
        return criticalStrikeChance;
    }

    protected int getCriticalStrikeDamage() {
        return criticalStrikeDamage;
    }

    protected int getLifeSteal() {
        return lifeSteal;
    }

    protected int getSpellVamp() {
        return spellVamp;
    }
}
