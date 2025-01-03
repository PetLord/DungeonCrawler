package windows.panels.gamePanel.factories;

import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.equipment.EquipmentType;
import windows.panels.gamePanel.equipment.weapons.swords.Sword;
import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.animations.PlayerAnimations;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class PlayerFactory {
    static final double runAnimationSpeed = 6;
    static final double idleAnimationSpeed = 1.5;
    static final double walkAnimationSpeed = 3;
    static final double deathAnimationSpeed = 5;

    public static Player createDefaultPlayer(GamePanel gamePanel, GameWorld gameWorld, Room myRoom) {
        String defaultName = "Player1";
        Image defaultImage = loadDefaultPlayerImage();
        CharacterStat defaultStat = StatFactory.getDefaultCharacterStat();
        Player tempPlayer = new Player(defaultName, defaultStat, gamePanel, myRoom);
        //loadDefaultPlayerAnimationFrames(tempPlayer);

        int tileWidth = gameWorld.getCurrentRoom().getTileWidth();
        int tileHeight = gameWorld.getCurrentRoom().getTileHeight();

        tempPlayer.addComponent(MovementComponent.class, new MovementComponent(defaultStat.getMovementSpeed(),true));
        tempPlayer.addComponent(PlayerInputComponent.class, new PlayerInputComponent(tempPlayer, gamePanel));
        tempPlayer.addComponent(GraphicsComponent.class, new GraphicsComponent(defaultImage, tempPlayer, gameWorld));
        tempPlayer.addComponent(CollisionComponent.class, new CollisionComponent(tempPlayer));
        tempPlayer.addComponent(AttackComponent.class, new AttackComponent(tempPlayer));
        tempPlayer.addComponent(DamageComponent.class, new DamageComponent(tempPlayer));

        tempPlayer.moveTo(gameWorld.getCurrentRoom().getPlayerEntrances().getFirst());
        Sword playerSword = EquipmentFactory.getStarterSword(tempPlayer, gameWorld);
        tempPlayer.getEquipment().addEquipment(EquipmentType.WEAPON, playerSword);

        return tempPlayer;
    }

    private static Image loadDefaultPlayerImage(){
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/player/Idle/IdleRight1.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default player image");
            return null;
        }
    }

    public static void loadDefaultPlayerAnimationFrames(Player player){
        player.addAnimationFrames(AnimationState.IDLE_LEFT, PlayerAnimations.getIdleLeftFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.IDLE_RIGHT, PlayerAnimations.getIdleRightFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.IDLE_UP, PlayerAnimations.getIdleUpFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.IDLE_DOWN, PlayerAnimations.getIdleDownFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_LEFT, PlayerAnimations.getRunLeftFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_RIGHT, PlayerAnimations.getRunRightFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_UP, PlayerAnimations.getRunUpFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_DOWN, PlayerAnimations.getRunDownFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_LEFT, PlayerAnimations.getWalkLeftFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_RIGHT, PlayerAnimations.getWalkRightFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_UP, PlayerAnimations.getWalkUpFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_DOWN, PlayerAnimations.getWalkDownFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.DEAD, PlayerAnimations.getDeathFrames(), deathAnimationSpeed);


         //player.addAnimationFrames(AnimationState.WALKING, PlayerAnimations.getWalkFrames());

    }

}
