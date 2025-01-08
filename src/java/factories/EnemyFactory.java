package factories;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.animations.MagmaSlimeAnimations;
import windows.panels.gamePanel.animations.SlimeAnimations;
import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.entities.characters.enemies.Enemy;
import windows.panels.gamePanel.entities.characters.enemies.MagmaSlime;
import windows.panels.gamePanel.entities.characters.enemies.Slime;
import windows.panels.gamePanel.entities.characters.enemies.bosses.Boss;
import windows.panels.gamePanel.entities.characters.enemies.bosses.MagmaBoss;
import windows.panels.gamePanel.entities.structures.MobSpawnLocation;
import windows.panels.gamePanel.entities.structures.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EnemyFactory {

    public static Slime createSlime(GamePanel gamePanel, GameWorld gameWorld, Room myRoom, MobSpawnLocation spawnLocation) {
        Slime slime = new Slime("Slime", gamePanel, gameWorld, myRoom);
        slime.moveTo(spawnLocation);
        loadDefaultSlimeAnimationFrames(slime);
        return slime;
    }

    public static Image getDefaultSlimeImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/enemies/slime/Idle/IdleRight1.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default slime image");
            return null;
        }
    }

    public static void loadDefaultSlimeAnimationFrames(Slime slime){
        final double idleAnimationSpeed = 2;
        final double walkAnimationSpeed = 4;
        final double deathAnimationSpeed = 5;
        slime.addAnimationFrames(AnimationState.IDLE_LEFT,     SlimeAnimations.getIdleLeftFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_RIGHT,    SlimeAnimations.getIdleRightFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_UP,       SlimeAnimations.getIdleUpFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_DOWN,     SlimeAnimations.getIdleDownFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_LEFT,  SlimeAnimations.getWalkLeftFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_RIGHT, SlimeAnimations.getWalkRightFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_UP,    SlimeAnimations.getWalkUpFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_DOWN,  SlimeAnimations.getWalkDownFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.DEAD,          SlimeAnimations.getDeathFrames(), deathAnimationSpeed);
        //player.addAnimationFrames(AnimationState.WALKING, PlayerAnimations.getWalkFrames());

    }

    public static MagmaSlime createMagmaSlime(GamePanel gamePanel, GameWorld gameWorld, Room myRoom, MobSpawnLocation spawnLocation) {
        MagmaSlime slime = new MagmaSlime("Magma Slime", gamePanel, gameWorld, myRoom);
        slime.moveTo(spawnLocation);
        loadDefaultMagmaSlimeAnimationFrames(slime);
        return slime;
    }

    public static void loadDefaultMagmaSlimeAnimationFrames(MagmaSlime slime){
        final double idleAnimationSpeed = 2;
        final double walkAnimationSpeed = 4;
        final double deathAnimationSpeed = 5;
        slime.addAnimationFrames(AnimationState.IDLE_LEFT,     MagmaSlimeAnimations.getIdleLeftFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_RIGHT,    MagmaSlimeAnimations.getIdleRightFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_UP,       MagmaSlimeAnimations.getIdleUpFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_DOWN,     MagmaSlimeAnimations.getIdleDownFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_LEFT,  MagmaSlimeAnimations.getWalkLeftFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_RIGHT, MagmaSlimeAnimations.getWalkRightFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_UP,    MagmaSlimeAnimations.getWalkUpFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_DOWN,  MagmaSlimeAnimations.getWalkDownFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.DEAD,          MagmaSlimeAnimations.getDeathFrames(), deathAnimationSpeed);
    }

    public static Enemy createRandomEnemy(GamePanel gamePanel, GameWorld gameWorld, Room myRoom, MobSpawnLocation spawnLocation){
        double random = Math.random();
        if(random < 0.5){
            return createSlime(gamePanel, gameWorld, myRoom, spawnLocation);
        } else {
            return createMagmaSlime(gamePanel, gameWorld, myRoom, spawnLocation);
        }
    }

    public static Boss getBoss(GamePanel gamePanel, GameWorld gameWorld, Room myRoom, MobSpawnLocation spawnLocation){
        MagmaBoss slime = new MagmaBoss("Magma Boss", gamePanel, gameWorld, myRoom);
        slime.moveTo(spawnLocation);
        loadDefaultMagmaBossAnimationFrames(slime);
        return slime;
    }

    public static void loadDefaultMagmaBossAnimationFrames(MagmaBoss slime){
        final double idleAnimationSpeed = 2;
        final double walkAnimationSpeed = 4;
        final double deathAnimationSpeed = 5;
        slime.addAnimationFrames(AnimationState.IDLE_LEFT,     MagmaSlimeAnimations.getIdleLeftFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_RIGHT,    MagmaSlimeAnimations.getIdleRightFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_UP,       MagmaSlimeAnimations.getIdleUpFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.IDLE_DOWN,     MagmaSlimeAnimations.getIdleDownFrames(), idleAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_LEFT,  MagmaSlimeAnimations.getWalkLeftFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_RIGHT, MagmaSlimeAnimations.getWalkRightFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_UP,    MagmaSlimeAnimations.getWalkUpFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.WALKING_DOWN,  MagmaSlimeAnimations.getWalkDownFrames(), walkAnimationSpeed);
        slime.addAnimationFrames(AnimationState.DEAD,          MagmaSlimeAnimations.getDeathFrames(), deathAnimationSpeed);
    }
}
