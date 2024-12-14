package equipment;

import equipment.accessories.Accessory;
import equipment.armors.Armor;
import equipment.weapons.Weapon;

public class Equipment {
    Armor armor;
    Weapon weapon;
    Accessory accessory;

    public Equipment() {
        armor = null;
        weapon = null;
        accessory = null;
    }

    Equipment(Armor armor, Weapon weapon, Accessory accessory) {
        this.armor = armor;
        this.weapon = weapon;
        this.accessory = accessory;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void addEquipment(EquipmentType type, Object equipment) {
        switch (type) {
            case WEAPON:
                weapon = (Weapon) equipment;
                break;
            case ARMOR:
                armor = (Armor) equipment;
                break;
            case ACCESSORY:
                accessory = (Accessory) equipment;
                break;
        }

    }
}
