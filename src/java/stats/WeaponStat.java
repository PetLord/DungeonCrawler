package stats;

public class WeaponStat {
    private int damage;
    private int range;
    private double attackSpeed;

    public WeaponStat(int damage, int range, int attackSpeed) {
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

}
