package windows.panels.gamePanel.animations;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class PlayerAnimations {

    public static ArrayList<Image> getIdleLeftFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Idle/IdleLeft1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Idle/IdleLeft2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Idle/IdleLeft3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Idle/IdleLeft4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getIdleRightFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Idle/IdleRight1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Idle/IdleRight2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Idle/IdleRight3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Idle/IdleRight4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }


    public static ArrayList<Image> getIdleUpFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Idle/IdleUp1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Idle/IdleUp2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Idle/IdleUp3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Idle/IdleUp4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getIdleDownFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Idle/IdleDown1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Idle/IdleDown2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Idle/IdleDown3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Idle/IdleDown4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getWalkLeftFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Walk/WalkLeft1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Walk/WalkLeft2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Walk/WalkLeft3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Walk/WalkLeft4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getWalkRightFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Walk/WalkRight1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Walk/WalkRight2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Walk/WalkRight3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Walk/WalkRight4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getWalkUpFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Walk/WalkUp1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Walk/WalkUp2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Walk/WalkUp3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Walk/WalkUp4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getWalkDownFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Walk/WalkDown1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Walk/WalkDown2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Walk/WalkDown3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Walk/WalkDown4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getRunRightFrames() {
        ArrayList<Image> runFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Run/RunRight1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Run/RunRight2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Run/RunRight3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Run/RunRight4.png"));
            runFrames.add(new ImageIcon(img1).getImage());
            runFrames.add(new ImageIcon(img2).getImage());
            runFrames.add(new ImageIcon(img3).getImage());
            runFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return runFrames;
    }

    public static ArrayList<Image> getRunLeftFrames() {
        ArrayList<Image> runFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Run/RunLeft1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Run/RunLeft2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Run/RunLeft3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Run/RunLeft4.png"));
            runFrames.add(new ImageIcon(img1).getImage());
            runFrames.add(new ImageIcon(img2).getImage());
            runFrames.add(new ImageIcon(img3).getImage());
            runFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return runFrames;
    }

    public static ArrayList<Image> getRunUpFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Run/RunUp1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Run/RunUp2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Run/RunUp3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Run/RunUp4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

    public static ArrayList<Image> getRunDownFrames() {
        ArrayList<Image> idleFrames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/player/Run/RunDown1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/player/Run/RunDown2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/player/Run/RunDown3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/player/Run/RunDown4.png"));
            idleFrames.add(new ImageIcon(img1).getImage());
            idleFrames.add(new ImageIcon(img2).getImage());
            idleFrames.add(new ImageIcon(img3).getImage());
            idleFrames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default tile image");
            return null;
        }
        return idleFrames;
    }

}
