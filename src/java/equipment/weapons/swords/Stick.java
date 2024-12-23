package equipment.weapons.swords;

import components.Direction;
import equipment.weapons.WeaponState;
import gameWindow.GameWorld;
import imageUtilities.ImageUtils;
import objects.characters.Player;
import stats.WeaponStat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Stick extends Sword{

    public Stick(WeaponStat weaponStat, Player player, GameWorld gameWorld) {
        super(weaponStat, player, 48, 48, gameWorld);
    }

    @Override
    public Point getGripPoint(Direction direction) {
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

            this.getAnimationComponent().addAnimationFrames(WeaponState.ATTACKING, new ImageIcon(img1).getImage());
            this.getAnimationComponent().addAnimationFrames(WeaponState.IDLE, new ImageIcon(img2).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default stick image");
        }
    }

}
