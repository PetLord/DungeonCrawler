package characters;

import characterProfessions.CharacterProfession;
import characters.attackInterfaces.CanAttackEnemyI;

public class Player extends Character implements CanAttackEnemyI, VulnerableCharacterI, WeaponWieldingCharacterI {

    public Player(String name, CharacterProfession characterClass) {
        super(name, characterClass);
    }

    @Override
    public void receiveAttack(int damage) {
        System.out.println("Player received " + damage + " damage.");
        currentHealth -= damage;

        if (!isAlive()) {
            die();
            currentHealth = 0;
        }
    }

    @Override
    public void heal(int healAmount) {
        System.out.println("Player healed " + healAmount + " health.");
        currentHealth += healAmount;
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public void die() {
        System.out.println("Player died.");
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void attack(Enemy target) {
        target.receiveAttack(10);
    }
}
