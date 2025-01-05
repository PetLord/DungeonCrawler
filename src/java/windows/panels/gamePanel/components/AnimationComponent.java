package windows.panels.gamePanel.components;

import windows.panels.gamePanel.entities.characters.Character;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnimationComponent {
    private Character character;
    private AnimationState currentState;
    private final Map<AnimationState, ArrayList<Image>> animationFrames = new HashMap<>();
    private final Map<AnimationState, Integer> animationSpeed = new HashMap<>();
    private ArrayList<Image> currentFrames;
    private int currentFrame;
    private long lastFrameTime;

    private static final int FPS_TO_MILLISECONDS = 1000; // Conversion constant

    public AnimationComponent(Character character) {
        this.character = character;
        this.setAnimationState(AnimationState.IDLE_RIGHT);
        this.currentFrames = animationFrames.getOrDefault(currentState, new ArrayList<>());
        this.currentFrame = 0;
        this.lastFrameTime = System.currentTimeMillis();
    }

    public void update() {
        if (currentFrames == null || currentFrames.isEmpty()) {
            //System.out.println("No frames to animate");
            return; // Guard against uninitialized or empty frames
        }

        Integer animSpeed = animationSpeed.get(currentState);
        if (animSpeed == null) {
            return; // Guard against missing animation speed for current state
        }

        if (System.currentTimeMillis() - lastFrameTime >= animSpeed) {
            if(currentState == AnimationState.DEAD && currentFrame == currentFrames.size() - 1){
                character.onDeathAnimationEnd();
                return;
            }

            currentFrame = (currentFrame + 1) % currentFrames.size(); // Loop through frames
            lastFrameTime = System.currentTimeMillis();
        }
    }



    public void setAnimationState(AnimationState state) {
        if(currentState == AnimationState.DEAD){
            return;
        }

        if (currentState != state && animationFrames.containsKey(state)) {
            currentState = state;
            currentFrames = animationFrames.get(state);
            currentFrame = 0; // Reset to the first frame of the new state
        }
    }

    public Image getCurrentFrame() {
        if (currentFrames == null || currentFrames.isEmpty()) {
            return null; // Guard against uninitialized or empty frames
        }
        return currentFrames.get(currentFrame);
    }

    public void addAnimationFrames(AnimationState state, ArrayList<Image> frames, double speed) {
        if (frames == null || frames.isEmpty() || speed <= 0) {
            throw new IllegalArgumentException("Invalid frames or speed");
        }

        animationFrames.put(state, frames);
        animationSpeed.put(state, (int) (FPS_TO_MILLISECONDS / speed));
    }

    public ArrayList<Image> getAnimationFrames(AnimationState state) {
        return animationFrames.get(state);
    }

    public boolean hasAnimationFrames(AnimationState state) {
        return animationFrames.containsKey(state);
    }

    public AnimationState getCurrentState() {
        return currentState;
    }

}
