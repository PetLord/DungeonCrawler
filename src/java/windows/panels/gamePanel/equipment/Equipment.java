package windows.panels.gamePanel.equipment;

import windows.panels.gamePanel.equipment.armors.Armor;
import windows.panels.gamePanel.equipment.weapons.Weapon;

public class Equipment {
    Armor armor;
    Weapon weapon;

    public Equipment() {
        armor = null;
        weapon = null;
    }

    Equipment(Armor armor, Weapon weapon) {
        this.armor = armor;
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void addEquipment(EquipmentType type, Object equipment) {
        switch (type) {
            case WEAPON:
                weapon = (Weapon) equipment;
                break;
            case ARMOR:
                armor = (Armor) equipment;
                break;
        }

    }
}
