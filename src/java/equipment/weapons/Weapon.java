package equipment.weapons;
import components.GraphicsComponent;
import components.WeaponAnimationComponent;
import objects.Entity;
import stats.WeaponStat;

import java.awt.*;

public abstract class Weapon {
    private WeaponAnimationComponent animationComponent;
    private GraphicsComponent graphicsComponent;
    private final WeaponStat weaponStat;
    private WeaponState state;
    private WeaponPosition verticalPosition;
    private WeaponPosition horizontalPosition;
    private Entity owner; // The entity wielding this weapon
    private boolean isVisible;

    public abstract void performAttack(); // Each weapon type implements this

    public Weapon(WeaponStat weaponStat, Entity owner) {
        this.weaponStat = weaponStat;
        this.state = WeaponState.IDLE;
        verticalPosition = WeaponPosition.EAST;
        horizontalPosition = WeaponPosition.NORTH;
        isVisible = true;
    }

    public void setAnimationComponent(WeaponAnimationComponent animationComponent) {
        this.animationComponent = animationComponent;
    }

    public void setGraphicsComponent(GraphicsComponent graphicsComponent) {
        this.graphicsComponent = graphicsComponent;
    }

    public Entity getOwner() {
        return owner;
    }

    public WeaponStat getWeaponStat() {
        return weaponStat;
    }

    public WeaponState getState() {
        return state;
    }

    public void setState(WeaponState state) {
        this.state = state;
    }

    public void update() {
        // Handle weapon-specific updates
        if (state == WeaponState.ATTACKING) {
            performAttack();
        }
    }

    public void setWeaponState(WeaponState state) {
        this.state = state;
    }

    public void render(Graphics g) {
        if (graphicsComponent != null) {
            graphicsComponent.render(g);
        }
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

}
