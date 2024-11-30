package characters;

import characterClasses.CharacterClass;
import characters.attackInterfaces.CanAttackEnemyI;

public class Player extends Character implements CanAttackEnemyI, VulnerableCharacterI, WeaponWieldingCharacterI {

    public Player(String name, CharacterClass characterClass) {
        super(name, characterClass);
    }

    @Override
    public void receiveAttack(int damage) {
        System.out.println("Player received " + damage + " damage.");
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void attack(Enemy target) {
        target.receiveAttack(10);
    }
}
