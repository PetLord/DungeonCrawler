package equipment.armors;

public class Armor {
    private final ArmorType armorType;
    private int defense;
    private int maxDurability;
    private int durability;

    public Armor(ArmorType armorType, int defense) {
        this.armorType = armorType;
        this.defense = defense;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public int getDefense() {
        return defense;
    }
}
