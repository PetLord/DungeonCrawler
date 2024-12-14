package factories;

import components.GraphicsComponent;
import equipment.weapons.Sword;
import objects.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EquipmentFactory {

    public static Sword getStarterSword(Entity entity) {
        Sword sword = new Sword(StatFactory.getDefaultWeaponStat(), entity);
        sword.setGraphicsComponent(new GraphicsComponent(EquipmentFactory.getDefaultSwordImage(), entity));
        return sword;
    }

    private static Image getDefaultSwordImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/weapons/stick.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default sword image");
            return null;
        }
    }
}
