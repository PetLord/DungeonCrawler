package objects.characters.player;

import characterProfessions.CharacterProfession;
import components.*;
import gameWindow.GamePanel;
import objects.characters.Character;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Character {
    private GamePanel gamePanel;
    private static final int defaultPlayerHeight = 75;
    private static final int defaultPlayerWidth = 50;

    public Player(String name, CharacterProfession characterProfession, GamePanel gamePanel) {
        super(name, characterProfession, defaultPlayerWidth, defaultPlayerHeight);

        this.gamePanel = gamePanel;
    }

    public void addAnimationFrames(AnimationState state, ArrayList<Image> frames, double speed) {
        if (!this.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = new AnimationComponent(this);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
        this.getComponent(AnimationComponent.class).addAnimationFrames(state, frames, speed);

    }

    public void setPlayerImage(Image playerImage) {
       if(this.hasComponent(GraphicsComponent.class)){
           this.getComponent(GraphicsComponent.class).setImage(playerImage);
       } else {
           GraphicsComponent graphicsComponent = new GraphicsComponent(playerImage, this);
           this.addComponent(GraphicsComponent.class, graphicsComponent);
       }
    }

    public void update() {
        this.getComponent(MovementComponent.class).updatePosition(this);
        this.getComponent(AnimationComponent.class).update();
    }

    public void render(Graphics g) {
        this.getComponent(GraphicsComponent.class).render(g);
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        if(hasComponent(PlayerInputComponent.class)){
            this.getComponent(PlayerInputComponent.class).setGamePanel(gamePanel);
        } else {
            this.addComponent(PlayerInputComponent.class, new PlayerInputComponent(this, gamePanel));
        }
        this.getComponent(PlayerInputComponent.class).addKeyListener();
    }

}
