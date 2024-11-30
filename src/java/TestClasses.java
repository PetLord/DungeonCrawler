import characterClasses.Fighter;
import stats.CharacterStat;

public class TestClasses {

    public static void main(String[] args) {
        CharacterStat baseStat = new CharacterStat(20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0);

        Fighter fighter = new Fighter(baseStat);
        System.out.println("Fighter Name: " + fighter.getName());
        System.out.println("Fighter Strength: " + fighter.getStats().getStrength());
        System.out.println("Fighter Dexterity: " + fighter.getStats().getDexterity());
        System.out.println("Fighter Health: " + fighter.getStats().getHealth());

    }

}
