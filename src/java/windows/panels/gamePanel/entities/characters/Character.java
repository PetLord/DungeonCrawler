package windows.panels.gamePanel.entities.characters;
import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.components.AnimationComponent;
import windows.panels.gamePanel.components.AnimationState;
import windows.panels.gamePanel.components.FaceDirection;
import windows.panels.gamePanel.entities.structures.MobSpawnLocation;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.Entity;
import windows.panels.gamePanel.entities.structures.PlayerSpawnPoint;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class Character extends Entity {
    public abstract Point2D getHandPosition(FaceDirection direction);
    public abstract CharacterStat getStats();
    public abstract void update();
    public abstract void die();

    private final String name;
    protected int currentHealth;
    protected CharacterStat characterStat;
    protected FaceDirection direction;

    public Character(String name, int width, int height, CharacterStat characterStat, GamePanel gamepanel, Room myRoom) {
        super(0, 0, width, height, gamepanel, myRoom);
        this.name = name;
        this.direction = FaceDirection.EAST;
        this.currentHealth = characterStat.getMaxHealth();
        this.characterStat = characterStat;
    }

    public CharacterStat getCharacterStat() {
        return characterStat;
    }

    public void printMainStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + currentHealth + " /" + characterStat.getMaxHealth());
        System.out.println("Mana: " + characterStat.getMana());
    }

    public void printStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + currentHealth + " /" + characterStat.getMaxHealth());
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

    public void moveTo(MobSpawnLocation mobSpawnLocation){
        if(mobSpawnLocation == null){
            return;
        }

        this.setX(mobSpawnLocation.getStartRow() * mobSpawnLocation.getTileWidth());
        this.setY(mobSpawnLocation.getStartCol() * mobSpawnLocation.getTileHeight());
    }

    public void moveTo(PlayerSpawnPoint sp) {
        if (sp == null) {
            return;
        }
        this.setX(sp.getStartRow() * sp.getTileWidth());
        this.setY(sp.getStartCol() * sp.getTileHeight());
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public FaceDirection getDirection() {
        return direction;
    }

    public void setDirection(FaceDirection direction) {
        this.direction = direction;
    }

    public void onDeathAnimationEnd() {
        this.myRoom.removeCharacter(this);
    }

    public void addAnimationFrames(AnimationState state, ArrayList<Image> frames, double speed) {
        if (!this.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = new AnimationComponent(this);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
        this.getComponent(AnimationComponent.class).addAnimationFrames(state, frames, speed);
    }


}