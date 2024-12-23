package factories;

import characterProfessions.CharacterProfession;
import components.*;
import equipment.EquipmentType;
import equipment.weapons.swords.Sword;
import gameWindow.GamePanel;
import gameWindow.GameWorld;
import objects.characters.Player;
import animations.PlayerAnimations;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class PlayerFactory {
    static final double runAnimationSpeed = 6;
    static final double idleAnimationSpeed = 1.5;
    static final double walkAnimationSpeed = 3;

    public static Player createDefaultPlayer(CharacterProfession profession, GamePanel gamePanel, GameWorld gameWorld) {
        String defaultName = "Player1";
        Image defaultImage = loadDefaultPlayerImage();

        Player tempPlayer = new Player(defaultName, profession, gamePanel);
        loadDefaultPlayerAnimationFrames(tempPlayer);

        int tileWidth = gameWorld.getCurrentRoom().getTileWidth();
        int tileHeight = gameWorld.getCurrentRoom().getTileHeight();

        tempPlayer.moveTo(gameWorld.getCurrentRoom().getStartPoints().getFirst());
        //tempPlayer.setHeight((int)(tileHeight* 1.5));
        //tempPlayer.setWidth(tileWidth);
        tempPlayer.addComponent(MovementComponent.class, new MovementComponent(tempPlayer.getCharacterProfession().getStats().getMovementSpeed(), tileWidth, tileHeight));
        tempPlayer.addComponent(PlayerInputComponent.class, new PlayerInputComponent(tempPlayer, gamePanel));
        tempPlayer.addComponent(GraphicsComponent.class, new GraphicsComponent(defaultImage, tempPlayer, gameWorld));
        tempPlayer.addComponent(CollisionComponent.class, new CollisionComponent(gameWorld));

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

    private static void loadDefaultPlayerAnimationFrames(Player player){
        player.addAnimationFrames(AnimationState.IDLE_LEFT, PlayerAnimations.getIdleLeftFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.IDLE_RIGHT, PlayerAnimations.getIdleRightFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.IDLE_UP, PlayerAnimations.getIdleUpFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.IDLE_DOWN, PlayerAnimations.getIdleDownFrames(), idleAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_LEFT, PlayerAnimations.getRunLeftFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_RIGHT, PlayerAnimations.getRunRightFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_UP, PlayerAnimations.getRunUpFrames(), runAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_LEFT, PlayerAnimations.getWalkLeftFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_RIGHT, PlayerAnimations.getWalkRightFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_UP, PlayerAnimations.getWalkUpFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.WALKING_DOWN, PlayerAnimations.getWalkDownFrames(), walkAnimationSpeed);
        player.addAnimationFrames(AnimationState.RUNNING_DOWN, PlayerAnimations.getRunDownFrames(), runAnimationSpeed);

         //player.addAnimationFrames(AnimationState.WALKING, PlayerAnimations.getWalkFrames());

    }

}
