package components;

import equipment.weapons.Weapon;
import objects.Entity;
import stats.WeaponStat;

public class AttackComponent {
    private final Entity owner;
    private Weapon equippedWeapon;
    private long lastAttackTime;

    public AttackComponent(Entity owner) {
        this.owner = owner;
        this.lastAttackTime = 0;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public boolean isWeaponReady() {
        if (equippedWeapon == null) return false;
        WeaponStat stats = equippedWeapon.getWeaponStat();
        return System.currentTimeMillis() - lastAttackTime >= 1000 / stats.getAttackSpeed();
    }

    public void attack() {
        if (isWeaponReady() && equippedWeapon != null) {
            System.out.println("Attacking");
            equippedWeapon.performAttack();
            lastAttackTime = System.currentTimeMillis();
        }
    }

}
