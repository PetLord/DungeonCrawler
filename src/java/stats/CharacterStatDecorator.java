package stats;

public class CharacterStatDecorator extends CharacterStat {
    private final CharacterStat stats;

    public CharacterStatDecorator() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.stats = null;
    }

    public CharacterStatDecorator(CharacterStat baseStats) {
        super(baseStats.getHealth(), baseStats.getMana(), baseStats.getStrength(),
                baseStats.getDexterity(), baseStats.getIntelligence(), baseStats.getArmor(),
                baseStats.getMagicResistance(), baseStats.getAttackDamage(), baseStats.getAbilityPower(),
                baseStats.getAttackSpeed(), baseStats.getMovementSpeed(), baseStats.getCriticalStrikeChance(),
                baseStats.getCriticalStrikeDamage(), baseStats.getLifeSteal(), baseStats.getSpellVamp());
        this.stats = baseStats;
    }

    // You can now override individual methods to add modifications or additional behavior
    @Override
    public int getHealth() {
        // Example: You can modify stats if necessary
        return stats != null ? stats.getHealth() : super.getHealth();
    }

    @Override
    public int getMana() {
        return stats != null ? stats.getMana() : super.getMana();
    }

    @Override
    public int getStrength() {
        return stats != null ? stats.getStrength() : super.getStrength();
    }

    @Override
    public int getDexterity() {
        return stats != null ? stats.getDexterity() : super.getDexterity();
    }

    @Override
    public int getIntelligence() {
        return stats != null ? stats.getIntelligence() : super.getIntelligence();
    }

    @Override
    public int getArmor() {
        return stats != null ? stats.getArmor() : super.getArmor();
    }

    @Override
    public int getMagicResistance() {
        return stats != null ? stats.getMagicResistance() : super.getMagicResistance();
    }

    @Override
    public int getAttackDamage() {
        return stats != null ? stats.getAttackDamage() : super.getAttackDamage();
    }

    @Override
    public int getAbilityPower() {
        return stats != null ? stats.getAbilityPower() : super.getAbilityPower();
    }

    @Override
    public int getAttackSpeed() {
        return stats != null ? stats.getAttackSpeed() : super.getAttackSpeed();
    }

    @Override
    public int getMovementSpeed() {
        return stats != null ? stats.getMovementSpeed() : super.getMovementSpeed();
    }

    @Override
    public int getCriticalStrikeChance() {
        return stats != null ? stats.getCriticalStrikeChance() : super.getCriticalStrikeChance();
    }

    @Override
    public int getCriticalStrikeDamage() {
        return stats != null ? stats.getCriticalStrikeDamage() : super.getCriticalStrikeDamage();
    }

    @Override
    public int getLifeSteal() {
        return stats != null ? stats.getLifeSteal() : super.getLifeSteal();
    }

    @Override
    public int getSpellVamp() {
        return stats != null ? stats.getSpellVamp() : super.getSpellVamp();
    }
}
