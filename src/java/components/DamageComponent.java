package components;

import objects.Entity;

// if an entity has a DamageComponent, it can take damage from other entities
public class DamageComponent {
    private final Entity entity;

    public DamageComponent(Entity entity) {
        this.entity = entity;
    }

    public void takeDamage(int damage) {
        //entity.setHealth(entity.getHealth() - calculateDamage(damage));
    }

    public int calculateDamage(){
        // calculate damage based on entity's stats
        return 0;
    }
}
