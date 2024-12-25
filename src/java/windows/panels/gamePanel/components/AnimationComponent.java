package windows.panels.gamePanel.components;
import windows.panels.gamePanel.objects.Entity;
import windows.panels.gamePanel.objects.characters.Character;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnimationComponent {
    private final Character character;
    private AnimationState currentState;
    private final Map<AnimationState, ArrayList<Image>> animationFrames = new HashMap<>();
    private final Map<AnimationState, Integer> animationSpeed = new HashMap<>();
    private ArrayList<Image> currentFrames;
    private int currentFrame;
    private long lastFrameTime;

    public AnimationComponent(Character character) {
        this.currentFrame = 0;
        this.currentState = null;
        this.currentFrames = null;
        this.character = character;
        this.lastFrameTime = System.currentTimeMillis();
    }

    public void update() {
        int animSpeed = animationSpeed.get(currentState);

        if (System.currentTimeMillis() - lastFrameTime >= animSpeed) {
            currentFrame = (currentFrame + 1) % currentFrames.size();  // Loop through frames
            lastFrameTime = System.currentTimeMillis();
        }
    }

    public void setAnimationState(AnimationState state) {
        if (currentState != state && animationFrames.containsKey(state)) {
            currentState = state;
            currentFrames = animationFrames.get(state);
            currentFrame = 0;
        }
    }

    public Image getCurrentFrame() {
        if(character.hasComponent(MovementComponent.class)){
            MovementComponent movementComponent = character.getComponent(MovementComponent.class);
        }
        return currentFrames.get(currentFrame);
    }

    public void setCurrentState(AnimationState currentState) {
        this.currentState = currentState;
        currentFrames = animationFrames.get(currentState);
    }

   public void addAnimationFrames(AnimationState state, ArrayList<Image> frames, double speed)
   {
        if(this.animationFrames.containsKey(state)){
            this.animationFrames.replace(state, frames);
            this.animationSpeed.replace(state, (int)(1000 / speed));
        } else {
            this.animationFrames.put(state, frames);
            this.animationSpeed.put(state, (int)(1000 / speed));
        }
   }

   public ArrayList<Image> getAnimationFrames(AnimationState state)
   {
       return this.animationFrames.get(state);
   }

   public boolean hasAnimationFrames(AnimationState state)
   {
       return this.animationFrames.containsKey(state);
   }

   public AnimationState getCurrentState() {
       return this.currentState;
   }

}
