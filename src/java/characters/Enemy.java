package characters;

import characterProfessions.CharacterProfession;
import characters.attackInterfaces.CanAttackPlayerI;

public class Enemy extends Character implements VulnerableCharacterI, CanAttackPlayerI, WeaponWieldingCharacterI {

    public Enemy(CharacterProfession characterClass) {
        super(characterClass.getName() ,characterClass);
    }

    @Override
    public void receiveAttack(int damage) {
        System.out.println(characterProfession.getName() + " received " + damage + " damage.");
        currentHealth -= damage;

        if (!isAlive()) {
            die();
            currentHealth = 0;
        }
    }

    @Override
    public void heal(int healAmount) {
        System.out.println(characterProfession.getName() + " healed " + healAmount + " health.");
        currentHealth = Math.min(currentHealth + healAmount, characterProfession.getStats().getHealth());
    }

    @Override
    public void die() {
        System.out.println(characterProfession.getName() + " died.");
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public void attack(Player target) {
        target.receiveAttack(10);
    }
}
