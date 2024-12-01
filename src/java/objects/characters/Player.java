package objects.characters;

import characterProfessions.CharacterProfession;
import components.*;
import gameWindow.GamePanel;

import java.awt.*;
import java.util.List;
import java.util.SimpleTimeZone;

public class Player extends Character {
    private GamePanel gamePanel;
    private MovementComponent movementComponent;
    private GraphicsComponent graphicsComponent;
    private AnimationComponent animationComponent;
    private PlayerInputComponent playerinputComponent;

    public Player(String name, CharacterProfession characterProfession, Image playerImage, List<Image> animationFrames, GamePanel gamePanel) {
        super(name, characterProfession);

        this.gamePanel = gamePanel;
        this.movementComponent = new MovementComponent(5);
        this.playerinputComponent = new PlayerInputComponent(movementComponent, gamePanel);
        this.graphicsComponent = new GraphicsComponent(playerImage);
        this.animationComponent = new AnimationComponent();

        this.addComponent(MovementComponent.class, movementComponent);
        this.addComponent(GraphicsComponent.class, graphicsComponent);
        this.addComponent(AnimationComponent.class, animationComponent);
        this.addComponent(PlayerInputComponent.class, playerinputComponent);
    }

    public void setMovementComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }

    private void setAnimationFrames(List<Image> frames, String type) {
        if (!this.hasComponent(AnimationComponent.class)) {
            this.animationComponent = new AnimationComponent();
            this.addComponent(AnimationComponent.class, animationComponent);
        }
        switch (type) {
            case "walk":
                this.animationComponent.setWalkFrames(frames);
                break;
            case "idle":
                this.animationComponent.setIdleFrames(frames);
                break;
            case "run":
                this.animationComponent.setRunFrames(frames);
                break;
        }
    }

    public void setPlayerImage(Image playerImage) {
       if(this.hasComponent(GraphicsComponent.class)){
           this.graphicsComponent.setImage(playerImage);
       } else {
           this.graphicsComponent = new GraphicsComponent(playerImage);
           this.addComponent(GraphicsComponent.class, graphicsComponent);
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

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        if(hasComponent(PlayerInputComponent.class)){
            playerinputComponent.setGamePanel(gamePanel);
            playerinputComponent.addKeyListener();
        } else {
            playerinputComponent = new PlayerInputComponent(movementComponent, gamePanel);
            playerinputComponent.addKeyListener();
            this.addComponent(PlayerInputComponent.class, playerinputComponent);
        }
    }

}
