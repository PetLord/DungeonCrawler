package windows.panels.gamePanel.equipment.weapons.bows;

import windows.panels.gamePanel.equipment.weapons.Weapon;
import windows.panels.gamePanel.objects.characters.Player;
import windows.panels.gamePanel.stats.WeaponStat;

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
