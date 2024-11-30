import characterProfessions.enemyCharacters.CommonMob;
import characterProfessions.playableCharacters.Fighter;
import characters.Enemy;
import characters.Player;
import stats.CharacterStat;

public class TestClasses {

    public static void main(String[] args) {
        CharacterStat baseStat = new CharacterStat(20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0);

        Fighter fighter = new Fighter(baseStat);
        Player player = new Player("Player", fighter);

        CommonMob commonMobClass = new CommonMob("Goblin", baseStat);
        Enemy e1 = new Enemy(commonMobClass);

        e1.printMainStats();

        player.attack(e1);
        player.attack(e1);
        player.attack(e1);

        e1.printMainStats();
    }

}
