package windows.panels.gamePanel.equipment.weapons;

import windows.panels.gamePanel.animations.WeaponAnimation;
import windows.panels.gamePanel.components.Direction;
import windows.panels.gamePanel.objects.Entity;
import windows.panels.gamePanel.objects.characters.Player;
import windows.panels.gamePanel.stats.WeaponStat;

import java.awt.*;

public abstract class Weapon {
    private int width;
    private int height;
    private WeaponAnimation animationComponent;
    private final WeaponStat weaponStat;
    private WeaponState state; // idle or attacking
    private Direction direction;
    protected Player owner; // The entity wielding this weapon
    private boolean isVisible;
    private long lastAttackTime; // Time tracking for cooldown
    protected abstract void performAttack(); // Each weapon type implements this
    public abstract Point getGripPoint(Direction direction); // Each weapon type implements this

    public Weapon(WeaponStat weaponStat, Player owner, int width, int height) {
        this.weaponStat = weaponStat;
        this.state = WeaponState.IDLE;
        this.direction = Direction.EAST;
        this.owner = owner;
        this.isVisible = true;
        this.lastAttackTime = System.currentTimeMillis();
        this.width = width;
        this.height = height;
    }

    public void attack() {
        long currentTime = System.currentTimeMillis();
        int cooldown = 1000 / (int)(weaponStat.getAttackSpeed()); // Attack speed as cooldown in milliseconds

        if (currentTime - lastAttackTime < cooldown) {
            System.out.println("Weapon is on cooldown. Remaining cooldown: " + (cooldown - (currentTime - lastAttackTime)) + " ms");
            return;
        }
            // Enough time has passed since the last attack
            lastAttackTime = currentTime;

            // Set weapon state and trigger attack logic
            setState(WeaponState.ATTACKING);
            performAttack();
            resetAfterAttack();
    }

    private void resetAfterAttack() {
        new Thread(() -> {
            try {
                Thread.sleep((int)(1000 / weaponStat.getAttackSpeed()));
                setState(WeaponState.IDLE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public WeaponAnimation getAnimationComponent() {
        return animationComponent;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public Entity getOwner() {
        return owner;
    }

    public WeaponStat getWeaponStat() {
        return weaponStat;
    }

    public WeaponState getState() {
        return state;
    }

    public void setState(WeaponState state) {
        this.state = state;
    }

    public void setWeaponState(WeaponState state) {
        this.state = state;
    }

    public void render(Graphics2D g) {
        if (isVisible) {
            animationComponent.render(g, owner);
        }
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public long getLastAttackTime() {
        return lastAttackTime;
    }

    public long getAttackDuration() {
        return (long)(1000 / weaponStat.getAttackSpeed());
    }

    public void setAnimationComponent(WeaponAnimation animationComponent) {
        this.animationComponent = animationComponent;
    }

    public boolean canAttack() {
        return state == WeaponState.IDLE;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
