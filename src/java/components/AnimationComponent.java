package components;
import java.awt.*;
import java.util.List;

public class AnimationComponent {
    private AnimationState currentState;
    private List<Image> idleFrames;
    private List<Image> walkFrames;
    private List<Image> runFrames;
    private List<Image> currentFrames;
    private int frameRate;
    private int currentFrame;
    private long lastFrameTime;

    public AnimationComponent(){
        this.idleFrames = null;
        this.walkFrames = null;
        this.runFrames = null;
        this.frameRate = 0;
        this.currentFrame = 0;
        this.currentState = AnimationState.IDLE;
        this.currentFrames = null;
        this.lastFrameTime = 0;
    }

    public AnimationComponent(List<Image> idleFrames, List<Image> walkFrames, List<Image> runFrames, int frameRate) {
        this.idleFrames = idleFrames;
        this.walkFrames = walkFrames;
        this.runFrames = runFrames;
        this.frameRate = frameRate;
        this.currentFrame = 0;
        this.currentState = AnimationState.IDLE;
        this.currentFrames = idleFrames;
        this.lastFrameTime = System.currentTimeMillis();
    }

    public void update() {
        if (System.currentTimeMillis() - lastFrameTime >= frameRate) {
            currentFrame = (currentFrame + 1) % currentFrames.size();  // Loop through frames
            lastFrameTime = System.currentTimeMillis();
        }
    }

    public void setAnimationState(AnimationState state) {
        if (state != currentState) {
            currentState = state;
            switch (state) {
                case IDLE:
                    currentFrames = idleFrames;
                    break;
                case WALKING:
                    currentFrames = walkFrames;
                    break;
                case RUNNING:
                    currentFrames = runFrames;
                    break;
            }
            currentFrame = 0;
        }
    }

    public Image getCurrentFrame() {
        return currentFrames.get(currentFrame);
    }

    public void setCurrentState(AnimationState currentState) {
        this.currentState = currentState;
    }

    public void setIdleFrames(List<Image> idleFrames) {
        this.idleFrames = idleFrames;
    }

    public void setWalkFrames(List<Image> walkFrames) {
        this.walkFrames = walkFrames;
    }

    public void setRunFrames(List<Image> runFrames) {
        this.runFrames = runFrames;
    }
}
