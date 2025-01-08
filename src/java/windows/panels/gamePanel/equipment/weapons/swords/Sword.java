package windows.panels.gamePanel.equipment.weapons.swords;

import windows.panels.gamePanel.animations.SwordAnimation;
import windows.panels.gamePanel.components.DamageComponent;
import windows.panels.gamePanel.components.FaceDirection;
import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.entities.characters.Character;
import windows.panels.gamePanel.equipment.weapons.Weapon;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.stats.WeaponStat;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Sword extends Weapon {
    public abstract void loadFrames();
    public abstract Point getGripPoint(FaceDirection direction);

    public Sword(WeaponStat weaponStat, Player player, int width, int height, GameWorld gameWorld) {
        super(weaponStat, player, width, height);
        this.setWeaponAnimation(new SwordAnimation(this, gameWorld));
    }

    @Override
    public void performAttack() {
        double range = Math.max(getWeaponStat().getRange() * owner.getGameWorld().getCurrentWidthScale(), getWeaponStat().getRange() * owner.getGameWorld().getCurrentHeightScale());

        int ownerX = owner.getX();
        int ownerY = owner.getY();


        for (Character target : owner.getGameWorld().getCurrentRoom().getAliveCharacters()) {
            if (target != owner && !(target instanceof Player) && target.hasComponent(DamageComponent.class) && isInRange(owner, target, range)) {
                int targetX = target.getX();
                int targetY = target.getY();

                target.getComponent(DamageComponent.class).takeDamage(getWeaponStat().getDamage() + owner.getStats().getAttackDamage());

                if(target.hasComponent(MovementComponent.class)){
                    Point2D knockBackForce = getKnockBackForce(ownerX, ownerY, targetX, targetY);
                    target.getComponent(MovementComponent.class).applyKnockBack(knockBackForce);
                }
            }
        }
    }

    private Point2D getKnockBackForce(int ownerX, int ownerY, int targetX, int targetY) {
        int deltaX = targetX - ownerX;
        int deltaY = targetY - ownerY;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double knockBackForce = this.getWeaponStat().getKnockback();

        if (distance > 0) { // Avoid division by zero
            double normalizedX = deltaX / distance;
            double normalizedY = deltaY / distance;

            double knockBackX = normalizedX * knockBackForce;
            double knockBackY = normalizedY * knockBackForce;

            return new Point2D.Double(knockBackX, knockBackY) {
            };
        }

        return new Point(0,0);
    }

    private boolean isInRange(Player owner, Character target, double range) {
        return getRectDistance(owner.getEquipment().getWeapon().getHitBox(), target.getHitBox())<= range;
    }

    private static double getRectDistance(Rectangle rect1, Rectangle rect2) {
        int deltaX = 0;
        int deltaY = 0;

        // Check horizontal distance
        if (rect1.x + rect1.width < rect2.x) {
            deltaX = rect2.x - (rect1.x + rect1.width); // Right of rect1
        } else if (rect2.x + rect2.width < rect1.x) {
            deltaX = rect1.x - (rect2.x + rect2.width); // Right of rect2
        }

        // Check vertical distance
        if (rect1.y + rect1.height < rect2.y) {
            deltaY = rect2.y - (rect1.y + rect1.height); // Below rect1
        } else if (rect2.y + rect2.height < rect1.y) {
            deltaY = rect1.y - (rect2.y + rect2.height); // Below rect2
        }

        // Calculate Euclidean distance
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public int getRange(){
        return (int) Math.max(this.getWidth() * owner.getGameWorld().getCurrentWidthScale(), this.getHeight() * owner.getGameWorld().getCurrentHeightScale());
    }

}
