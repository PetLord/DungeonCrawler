package windows.panels.gamePanel.components;

import windows.panels.gamePanel.entities.characters.Character;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.characters.enemies.Enemy;
import windows.panels.gamePanel.equipment.weapons.Weapon;

public class AttackComponent {
    private final Character character;
    private long lastAttackTime; // Time tracking for cooldown

    public AttackComponent(Character character) {
        this.character = character;
        this.lastAttackTime = System.currentTimeMillis();
    }

    public void attack() {
        if (character instanceof Player) {
            playerAttack();
        } else if (character instanceof Enemy) {
            enemyAttack();
        }
    }

    private void playerAttack(){
        Weapon w = ((Player) character).getEquipment().getWeapon();
        if(w != null && w.canAttack()){
            w.attack();
        }
    }

    private void enemyAttack(){
        long currentTime = System.currentTimeMillis();
        int cooldown = 1000 / (int)(character.getStats().getAttackSpeed());

        if (currentTime - lastAttackTime < cooldown) {
            return;
        }
        lastAttackTime = currentTime;

        character.getMyRoom().getAliveCharacters().forEach(target -> {
            if (target instanceof Enemy) {
                return;
            }
            if(target.hasComponent(DamageComponent.class) && character.collidesWith(target)) {
                target.getComponent(DamageComponent.class).takeDamage(character.getStats().getAttackDamage());
            }
        });
    }
}
