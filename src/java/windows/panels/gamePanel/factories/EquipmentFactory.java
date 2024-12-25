package windows.panels.gamePanel.factories;

import windows.panels.gamePanel.equipment.weapons.swords.Stick;
import windows.panels.gamePanel.equipment.weapons.swords.Sword;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.objects.characters.Player;

public abstract class EquipmentFactory {

    public static Sword getStarterSword(Player player, GameWorld gameWorld) {
        Sword stick = new Stick(StatFactory.getDefaultWeaponStat(), player, gameWorld);
        stick.loadFrames();
        return stick;
    }

}
