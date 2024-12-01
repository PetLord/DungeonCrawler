import characterProfessions.CharacterProfession;
import characterProfessions.playableCharacters.Fighter;
import factories.PlayerFactory;
import gameWindow.GameFrame;
import objects.characters.Player;
import stats.*;
import java.util.concurrent.TimeUnit;

public class TestWindows {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        CharacterStat baseStats = new CharacterStat(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        CharacterProfession f = new Fighter(baseStats);
        Player p1 = PlayerFactory.createDefaultPlayer(f);

        frame.getGamePanel().addEntity(p1);
    }
}
