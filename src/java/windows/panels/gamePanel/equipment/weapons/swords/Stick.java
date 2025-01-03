package windows.panels.gamePanel.equipment.weapons.swords;

import windows.panels.gamePanel.components.FaceDirection;
import windows.panels.gamePanel.equipment.weapons.WeaponState;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.stats.WeaponStat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Stick extends Sword{

    public Stick(WeaponStat weaponStat, Player player, GameWorld gameWorld) {
        super(weaponStat, player, 64, 64, gameWorld);
    }

    @Override
    public Point getGripPoint(FaceDirection direction) {
        return switch (direction)
            {
                case SOUTH -> new Point(getWidth() * 3/32, getHeight() * 5 / 32);
                case WEST -> new Point( getWidth() * 29 / 32, getHeight() * 27/32);
                default -> new Point(getWidth() * 3/32, getHeight() * 27/32);
            };
        //3 out of 32 ~
        //27 out of 32 ~
    }


    @Override
    public void loadFrames() {
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/weapons/swords/stickAttack.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/weapons/swords/stickIdle.png"));

            // Scale the images
            //BufferedImage scaledImg1 = ImageUtils.rescaleImage(img1, 1.5);
            //BufferedImage scaledImg2 = ImageUtils.rescaleImage(img2, 1.5);

            this.getWeaponAnimation().addAnimationFrames(WeaponState.ATTACKING, new ImageIcon(img1).getImage());
            this.getWeaponAnimation().addAnimationFrames(WeaponState.IDLE, new ImageIcon(img2).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default stick image");
        }
    }

}
