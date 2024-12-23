package equipment.weapons.swords;

import animations.SwordAnimation;
import components.DamageComponent;
import components.Direction;
import equipment.weapons.Weapon;
import equipment.weapons.WeaponState;
import gameWindow.GameWorld;
import objects.Entity;
import objects.characters.Player;
import stats.WeaponStat;

import java.awt.*;

public abstract class Sword extends Weapon {
    public abstract void loadFrames();
    public abstract Point getGripPoint(Direction direction);

    public Sword(WeaponStat weaponStat, Player player, int width, int height, GameWorld gameWorld) {
        super(weaponStat, player, width, height);
        this.setAnimationComponent(new SwordAnimation(this, gameWorld));
    }

    @Override
    public void performAttack() {
        int range = getWeaponStat().getRange();
        for (Entity target : owner.getGameWorld().getCurrentRoom().getEntities()) {
            if (target != owner && target.hasComponent(DamageComponent.class) && isInRange(owner, target, range)) {
                target.getComponent(DamageComponent.class).takeDamage(getWeaponStat().getDamage());
            }
        }
    }

    private boolean isInRange(Entity owner, Entity target, int range) {
        return getRectDistance(owner.getHitBox(), target.getHitBox())<= range;
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

}
