package components;

import equipment.weapons.WeaponState;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class WeaponAnimationComponent {
    private final Map<WeaponState, Image> animations = new HashMap<>();
    private WeaponState currentState;


    public WeaponAnimationComponent() {
        this.currentState = WeaponState.IDLE;
    }

    public void setState(WeaponState state) {
        if (state != currentState) {
            currentState = state;
        }
    }

    public void addAnimationFrames(WeaponState state, Image frame) {
        animations.put(state, frame);
    }

    public Image getCurrentFrame() {
        if (animations.containsKey(currentState)) {
            return animations.get(currentState);
        }
        return null;
    }
}
