package windows.panels.gamePanel.components;

import windows.panels.gamePanel.entities.characters.Character;

// if an entity has a DamageComponent, it can take damage from other entities
public class DamageComponent {
    private final Character character;

    public DamageComponent(Character character) {
        this.character = character;
    }

    public void takeDamage(int damage) {
        int newHealth = character.getCurrentHealth() - calculateDamage(damage);

        if (newHealth <= 0) {
            character.die();
            newHealth = 0;
        }
        character.setCurrentHealth(newHealth);
        System.out.println(character.getName() + ":" + character.getStats().getMaxHealth() + "/" + character.getCurrentHealth());
    }


    public int calculateDamage(int damage) {
        // 5 armor means -5% damage taken
        int totalArmor = character.getStats().getArmor();

        if(character.getStats().getArmor() > 0){
            damage = (int) Math.max(1, damage * ( 1 - character.getStats().getArmor()/100f));
        }
        return damage;
    }
}
