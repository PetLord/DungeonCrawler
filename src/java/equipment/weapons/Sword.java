package equipment.weapons;

import components.DamageComponent;
import objects.Entity;
import stats.WeaponStat;

import java.awt.*;

public class Sword extends Weapon {

    public Sword(WeaponStat weaponStat, Entity entity) {
        super(weaponStat, entity);
    }

    @Override
    public void performAttack() {
        setState(WeaponState.ATTACKING);
        int range = getWeaponStat().getRange();
        Entity owner = getOwner();

        for (Entity target : owner.getGameWorld().getCurrentRoom().getEntities()) {
            if (target != owner && target.hasComponent(DamageComponent.class) && isInRange(owner, target, range)) {
                target.getComponent(DamageComponent.class).takeDamage(getWeaponStat().getDamage());
            }
        }

        setState(WeaponState.IDLE); // Return to idle state after attack
    }

    private boolean isInRange(Entity owner, Entity target, int range) {
        return getRectDistance(owner.getHitBox(), target.getHitBox())<= range;
    }

    public static double getRectDistance(Rectangle rect1, Rectangle rect2) {
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

}
