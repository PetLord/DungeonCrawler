package factories;

import characterProfessions.CharacterProfession;
import objects.characters.Player;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

public class PlayerFactory {

    public static Player createDefaultPlayer(CharacterProfession profession) {
        String defaultName = "Default Player";
        Image defaultImage = loadDefaultPlayerImage();
        List<Image> defaultAnimationFrames = loadDefaultAnimationFrames();

        return new Player(defaultName, profession, defaultImage, defaultAnimationFrames);
    }

    private static Image loadDefaultPlayerImage() {
        return new ImageIcon("imgs/playerImages/idlePlayerImage").getImage();
    }

    private static List<Image> loadDefaultAnimationFrames() {
        return List.of(loadDefaultPlayerImage());  // Example with one frame for simplicity
    }
}
