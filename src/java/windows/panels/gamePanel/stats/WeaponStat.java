package windows.panels.gamePanel.stats;

public class WeaponStat {
    private int damage;
    private double range;
    private double attackSpeed;
    private double knockback;

    public WeaponStat(int damage, double range, double attackSpeed, double knockback) {
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
        this.knockback = knockback;
    }

    public int getDamage() {
        return damage;
    }

    public double getRange() {
        return range;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getKnockback() {
        return knockback;
    }

}
