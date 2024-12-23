package factories;

import equipment.weapons.swords.Stick;
import equipment.weapons.swords.Sword;
import gameWindow.GameWorld;
import objects.characters.Player;

public abstract class EquipmentFactory {

    public static Sword getStarterSword(Player player, GameWorld gameWorld) {
        Sword stick = new Stick(StatFactory.getDefaultWeaponStat(), player, gameWorld);
        stick.loadFrames();
        return stick;
    }

}
