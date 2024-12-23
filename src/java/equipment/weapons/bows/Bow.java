package equipment.weapons.bows;

import equipment.weapons.Weapon;
import objects.characters.Player;
import stats.WeaponStat;

public abstract class Bow extends Weapon {
    protected abstract void setScale();
    public Bow(WeaponStat weaponStat, Player player, int baseWidth, int baseHeight) {
        super(weaponStat, player, baseWidth, baseHeight);
    }

    @Override
    public void performAttack() {
        System.out.println("Firing arrow!");
        // Pseudocode for firing a projectile
        // Create a projectile entity, set its direction, and add it to the game world
        //Projectile arrow = new Projectile(getOwner().getX(), getOwner().getY(), getWeaponStat().getDamage());
        //getOwner().getGameWorld().addEntity(arrow);

    }

}
