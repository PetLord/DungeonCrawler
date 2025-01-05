package factories;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.animations.SlimeAnimations;
import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.entities.characters.enemies.Slime;
import windows.panels.gamePanel.entities.characters.enemies.Zombie;
import windows.panels.gamePanel.entities.structures.MobSpawnLocation;
import windows.panels.gamePanel.entities.structures.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EnemyFactory {

    public static Zombie createZombie(GamePanel gamePanel, Room currentRoom) {
        Zombie zombie = new Zombie("Zombie", 32, 32, gamePanel, currentRoom);
        double speed = zombie.getStats().getMovementSpeed();
        Image image = getDefaultZombieImage();

        zombie.addComponent(MovementComponent.class, new MovementComponent(speed, false));
        //zombie.addComponent(GraphicsComponent.class, new GraphicsComponent());
        return zombie;
    }

    private static Image getDefaultZombieImage() {
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default player image");
            return null;
        }
    }

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
}
