package animations;

import equipment.weapons.Weapon;
import equipment.weapons.WeaponState;
import objects.characters.Player;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class WeaponAnimation {
    protected final Map<WeaponState, Image> animations = new HashMap<>();
    protected final Weapon weapon;

    public WeaponAnimation(Weapon weapon) {
        this.weapon = weapon;
    }

    public Image getCurrentFrame() {
        if (animations.containsKey(weapon.getState())) {
            return animations.get(weapon.getState());
        }
        return null;
    }

    public void addAnimationFrames(WeaponState state, Image frame) {
        animations.put(state, frame);
    }

    public abstract void render(Graphics2D g, Player owner);

}
