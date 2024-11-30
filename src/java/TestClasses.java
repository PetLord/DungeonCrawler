import characterClasses.enemyCharacters.CommonMobClass;
import characterClasses.playableCharacters.Fighter;
import characters.Enemy;
import characters.Player;
import stats.CharacterStat;

public class TestClasses {

    public static void main(String[] args) {
        CharacterStat baseStat = new CharacterStat(20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0);

        Fighter fighter = new Fighter(baseStat);
        Player player = new Player("Player", fighter);


        CommonMobClass commonMobClass = new CommonMobClass("Goblin", baseStat);
        Enemy e1 = new Enemy(commonMobClass);

        player.attack(e1);


    }

}
