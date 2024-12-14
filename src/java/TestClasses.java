import characterProfessions.enemyCharacters.CommonMob;
import characterProfessions.playableCharacters.Fighter;
import stats.CharacterStat;

public class TestClasses {

    public static void main(String[] args) {
        CharacterStat baseStat = new CharacterStat(20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0);

        Fighter fighter = new Fighter(baseStat);
        CommonMob commonMobClass = new CommonMob("Goblin", baseStat);

    }

}
