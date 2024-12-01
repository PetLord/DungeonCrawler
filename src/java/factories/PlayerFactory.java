package factories;

import characterProfessions.CharacterProfession;
import components.GraphicsComponent;
import objects.characters.Player;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import components.MovementComponent;
import components.PlayerInputComponent;



public class PlayerFactory {
    private static final int PLAYERHEIGHT = 75;
    private static final int PLAYERWIDTH = 50;

    public static Player createDefaultPlayer(CharacterProfession profession) {
        String defaultName = "Default Player";
        Image defaultImage = loadDefaultPlayerImage();
        List<Image> defaultAnimationFrames = loadDefaultAnimationFrames();

        Player tempPlayer = new Player(defaultName, profession, defaultImage, defaultAnimationFrames);
        tempPlayer.setHeight(PLAYERHEIGHT);
        tempPlayer.setWidth(PLAYERWIDTH);
        tempPlayer.addComponent(MovementComponent.class, new MovementComponent(25, tempPlayer));
        tempPlayer.addComponent(PlayerInputComponent.class, new PlayerInputComponent(tempPlayer.getComponent(MovementComponent.class)));
        tempPlayer.addComponent(GraphicsComponent.class, new GraphicsComponent(defaultImage));

        return tempPlayer;
    }

    private static Image loadDefaultPlayerImage(){
        try {
            BufferedImage img = ImageIO.read(new File("resources/images/Idle1.png"));
            return new ImageIcon(img).getImage();
        } catch (Exception e) {
            System.out.println("Error loading default player image");
            return null;
        }
    }

    private static List<Image> loadDefaultAnimationFrames() {
        return List.of(loadDefaultPlayerImage());
    }
}
