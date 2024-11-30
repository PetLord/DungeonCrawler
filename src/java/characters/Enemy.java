package characters;

import characterClasses.CharacterClass;
import characters.attackInterfaces.CanAttackPlayerI;
import stats.CharacterStat;

public class Enemy extends Character implements VulnerableCharacterI, CanAttackPlayerI, WeaponWieldingCharacterI {
    String name;
    CharacterStat characterStat;

    public Enemy(CharacterClass characterClass) {
        super(characterClass.getName() ,characterClass);
    }


    @Override
    public void receiveAttack(int damage) {
        System.out.println(characterClass.getName() + " received " + damage + " damage.");
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void attack(Player target) {
        target.receiveAttack(10);
    }
}
