package characters;
import characterProfessions.*;
import stats.CharacterStat;

public class Character{
    protected String name;
    protected int currentHealth;
    CharacterProfession characterProfession;
    CharacterStat characterStat;

    public Character(String name, CharacterProfession characterClass){
        this.name = name;
        this.characterProfession = characterClass;
        this.characterStat = characterClass.getStats();
        currentHealth = characterStat.getHealth();
    }

    public String getName() {
        return name;
    }

    public CharacterStat getCharacterStat() {
        return characterStat;
    }

    public CharacterProfession getCharacterProfession() {
        return characterProfession;
    }

    public void printMainStats(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + currentHealth + " /" + characterStat.getHealth());
        System.out.println("Mana: " + characterStat.getMana());
    }

    public void printStats(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + currentHealth + " /" + characterStat.getHealth());
        System.out.println("Mana: " + characterStat.getMana());
        System.out.println("Strength: " + characterStat.getStrength());
        System.out.println("Dexterity: " + characterStat.getDexterity());
        System.out.println("Intelligence: " + characterStat.getIntelligence());
        System.out.println("Armor: " + characterStat.getArmor());
        System.out.println("Magic Resistance: " + characterStat.getMagicResistance());
        System.out.println("Attack Damage: " + characterStat.getAttackDamage());
        System.out.println("Ability Power: " + characterStat.getAbilityPower());
        System.out.println("Attack Speed: " + characterStat.getAttackSpeed());
        System.out.println("Movement Speed: " + characterStat.getMovementSpeed());
        System.out.println("Critical Strike Chance: " + characterStat.getCriticalStrikeChance());
        System.out.println("Critical Strike Damage: " + characterStat.getCriticalStrikeDamage());
        System.out.println("Life Steal: " + characterStat.getLifeSteal());
        System.out.println("Spell Vamp: " + characterStat.getSpellVamp());
    }
}