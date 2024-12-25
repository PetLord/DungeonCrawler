package windows.panels.gamePanel.objects.characters;
import windows.panels.gamePanel.characterProfessions.*;
import windows.panels.gamePanel.components.Direction;
import windows.panels.gamePanel.equipment.Equipment;
import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.objects.Entity;
import windows.panels.gamePanel.objects.structures.StartPoint;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.geom.Point2D;

public abstract class Character extends Entity {
    public abstract Point2D getHandPosition(Direction direction);

    private final String name;
    private int currentHealth;
    private final CharacterProfession characterProfession;
    private CharacterStat characterStat;
    private Equipment equipment;

    public Character(String name, CharacterProfession characterProfession, int width, int height, GamePanel gamePanel) {
        super(0, 0, width, height, gamePanel);
        this.name = name;
        this.characterProfession = characterProfession;
        this.characterStat = characterProfession.getStats();
        currentHealth = characterStat.getHealth();
        this.equipment = new Equipment();

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

    public void printMainStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + currentHealth + " /" + characterStat.getHealth());
        System.out.println("Mana: " + characterStat.getMana());
    }

    public void printStats() {
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

    public void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void moveTo(StartPoint sp) {
        if (sp == null) {
            return;
        }
        this.setX(sp.getStartRow() * sp.getTileWidth());
        this.setY(sp.getStartCol() * sp.getTileHeight());
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public void setDirection(Direction direction) {
        if(equipment.getWeapon() != null){
            equipment.getWeapon().setDirection(direction);
        }
        super.setDirection(direction);
    }
}