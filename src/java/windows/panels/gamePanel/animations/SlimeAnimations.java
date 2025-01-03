package windows.panels.gamePanel.animations;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public abstract class SlimeAnimations {

    public static ArrayList<Image> getIdleLeftFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleLeft1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleLeft2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleLeft3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleLeft4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getIdleRightFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleRight1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleRight2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleRight3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleRight4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }


    public static ArrayList<Image> getIdleUpFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleUp1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleUp2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleUp3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleUp4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getIdleDownFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleDown1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleDown2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleDown3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleDown4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getWalkLeftFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkLeft1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkLeft2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkLeft3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkLeft4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getWalkRightFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkRight1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkRight2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkRight3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkRight4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getWalkUpFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkUp1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkUp2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkUp3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkUp4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getWalkDownFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkDown1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkDown2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkDown3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Walk/WalkDown4.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }

    public static ArrayList<Image> getDeathFrames() {
        ArrayList<Image> frames = new ArrayList<>();
        try {
            BufferedImage img1 = ImageIO.read(new File("resources/images/enemies/slime/Death/death1.png"));
            BufferedImage img2 = ImageIO.read(new File("resources/images/enemies/slime/Death/death2.png"));
            BufferedImage img3 = ImageIO.read(new File("resources/images/enemies/slime/Death/death3.png"));
            BufferedImage img4 = ImageIO.read(new File("resources/images/enemies/slime/Death/death4.png"));
            BufferedImage img5 = ImageIO.read(new File("resources/images/enemies/slime/Death/death5.png"));
            BufferedImage img6 = ImageIO.read(new File("resources/images/enemies/slime/Death/death6.png"));
            BufferedImage img7 = ImageIO.read(new File("resources/images/enemies/slime/Death/death7.png"));
            frames.add(new ImageIcon(img1).getImage());
            frames.add(new ImageIcon(img2).getImage());
            frames.add(new ImageIcon(img3).getImage());
            frames.add(new ImageIcon(img4).getImage());
            frames.add(new ImageIcon(img5).getImage());
            frames.add(new ImageIcon(img6).getImage());
            frames.add(new ImageIcon(img7).getImage());

        } catch (Exception e) {
            System.out.println("Error loading default Slime image");
            return null;
        }
        return frames;
    }
}
