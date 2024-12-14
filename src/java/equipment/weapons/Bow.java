package equipment.weapons;

import objects.Entity;
import stats.WeaponStat;

public class Bow extends Weapon {

    public Bow(WeaponStat weaponStat, Entity entity) {
        super(weaponStat, entity);
    }

    @Override
    public void performAttack() {
        System.out.println("Firing arrow!");
        // Pseudocode for firing a projectile
        // Create a projectile entity, set its direction, and add it to the game world
        //Projectile arrow = new Projectile(getOwner().getX(), getOwner().getY(), getWeaponStat().getDamage());
        //getOwner().getGameWorld().addEntity(arrow);

        setState(WeaponState.RELOADING);
    }
}
