package windows.panels.gamePanel.equipment.weapons;

import windows.panels.gamePanel.animations.WeaponAnimation;
import windows.panels.gamePanel.components.FaceDirection;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.stats.WeaponStat;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Weapon {
    private final int width;
    private final int height;
    private WeaponAnimation weaponAnimation;
    private final WeaponStat weaponStat;
    private WeaponState state; // idle or attacking
    private FaceDirection direction;
    protected Player owner; // The entity wielding this weapon
    private boolean isVisible;
    private long lastAttackTime; // Time tracking for cooldown
    protected abstract void performAttack(); // Each weapon type implements this
    public abstract Point getGripPoint(FaceDirection direction); // Each weapon type implements this

    public Weapon(WeaponStat weaponStat, Player owner, int width, int height) {
        this.weaponStat = weaponStat;
        this.state = WeaponState.IDLE;
        this.direction = FaceDirection.EAST;
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
            //System.out.println("Weapon is on cooldown. Remaining cooldown: " + (cooldown - (currentTime - lastAttackTime)) + " ms");
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

    public WeaponAnimation getWeaponAnimation() {
        return weaponAnimation;
    }

    public FaceDirection getDirection() {
        return direction;
    }

    public void setDirection(FaceDirection direction) {
        this.direction = direction;
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

    public void render(Graphics2D g) {
        if (isVisible) {
            weaponAnimation.render(g, owner);
        }
    }

    public long getLastAttackTime() {
        return lastAttackTime;
    }

    public long getAttackDuration() {
        return (long)(1000 / weaponStat.getAttackSpeed());
    }

    public void setWeaponAnimation(WeaponAnimation weaponAnimation) {
        this.weaponAnimation = weaponAnimation;
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

    public Point getSwordLocation() {
        if (owner == null || owner.getGameWorld() == null) {
            return new Point(0, 0); // Fallback to a default location or handle gracefully
        }
        Point2D handPosition = owner.getHandPosition(this.getDirection());
        double wScale = owner.getGameWorld().getCurrentWidthScale();
        double hScale = owner.getGameWorld().getCurrentHeightScale();
        Point gripPoint = getGripPoint(this.getDirection());

        // Calculate the pixel position of the hand
        int handX = (int) (owner.getX() + handPosition.getX() * owner.getWidth() * wScale);
        int handY = (int) (owner.getY() + handPosition.getY() * owner.getHeight() * hScale);

        int swordX = handX - (int) (gripPoint.x * wScale);
        int swordY = handY - (int) (gripPoint.y * hScale);
        return new Point(swordX, swordY);
    }

    public Rectangle getHitBox() {
        Point swordLocation = getSwordLocation();
        double wScale = owner.getGameWorld().getCurrentWidthScale();
        double hScale = owner.getGameWorld().getCurrentHeightScale();
        return new Rectangle(swordLocation.x, swordLocation.y, (int) (width * wScale), (int) (height * hScale));
    }
}
