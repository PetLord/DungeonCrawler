package objects.characters;

import characterProfessions.CharacterProfession;
import components.AnimationComponent;
import components.AnimationState;
import components.GraphicsComponent;
import components.MovementComponent;

import java.awt.*;
import java.util.List;

public class Player extends Character {
    private MovementComponent movementComponent;
    private GraphicsComponent graphicsComponent;
    private AnimationComponent animationComponent;

    public Player(String name, CharacterProfession characterProfession) {
        super(name, characterProfession);
        this.movementComponent = new MovementComponent(5);  // Speed of 5
        this.movementComponent = null;
        this.graphicsComponent = null;
        this.animationComponent = null;
    }

    public Player(String name, CharacterProfession characterProfession, Image playerImage, List<Image> animationFrames) {
        super(name, characterProfession);

        this.movementComponent = new MovementComponent(5);
        this.graphicsComponent = new GraphicsComponent(playerImage);
        this.animationComponent = new AnimationComponent();

        this.addComponent(MovementComponent.class, movementComponent);
        this.addComponent(GraphicsComponent.class, graphicsComponent);
        this.addComponent(AnimationComponent.class, animationComponent);
    }

    public void setMovementComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }

    public void setPlayerImage(Image playerImage) {
       if(this.hasComponent(GraphicsComponent.class)){
           this.graphicsComponent.setImage(playerImage);
       } else {
           this.graphicsComponent = new GraphicsComponent(playerImage);
           this.addComponent(GraphicsComponent.class, graphicsComponent);
       }
    }

    public void setIdleFrames(List<Image> idleFrames) {
        if(this.hasComponent(AnimationComponent.class)){
            this.animationComponent.setIdleFrames(idleFrames);
        } else {
            this.animationComponent = new AnimationComponent();
            this.animationComponent.setIdleFrames(idleFrames);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
    }

    public void setWalkFrames(List<Image> walkFrames) {
        if(this.hasComponent(AnimationComponent.class)){
            this.animationComponent.setWalkFrames(walkFrames);
        } else {
            this.animationComponent = new AnimationComponent();
            this.animationComponent.setWalkFrames(walkFrames);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
    }

    public void setRunFrames(List<Image> runFrames) {
        if(this.hasComponent(AnimationComponent.class)){
            this.animationComponent.setRunFrames(runFrames);
        } else {
            this.animationComponent = new AnimationComponent();
            this.animationComponent.setRunFrames(runFrames);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
    }

    public void setAnimationState(AnimationState state) {
        if(this.hasComponent(AnimationComponent.class)){
            this.animationComponent.setAnimationState(state);
        } else {
            this.animationComponent = new AnimationComponent();
            this.animationComponent.setAnimationState(state);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
    }

    public void update() {
        movementComponent.move();
        animationComponent.update();
    }

    public void render(Graphics g) {
        animationComponent.update();
        graphicsComponent.render(g, getX(), getY(), getWidth(), getHeight());
    }

}
