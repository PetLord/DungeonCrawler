package windows.panels.gamePanel.components;

import java.awt.*;

import windows.panels.gamePanel.animations.SwordAnimation;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.objects.Entity;

public class GraphicsComponent {
    private Image image;
    Entity entity;
    GameWorld gameWorld;

    public GraphicsComponent(Image image, Entity entity, GameWorld gameWorld) {
        this.entity = entity;
        this.image = image;
        this.gameWorld = gameWorld;
    }

    public void render(Graphics g) {
        if(entity.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = entity.getComponent(AnimationComponent.class);
            animationComponent.update();
            image = animationComponent.getCurrentFrame();
        }
        if(entity.hasComponent(SwordAnimation.class)) {
            SwordAnimation weaponAnimationComponent = entity.getComponent(SwordAnimation.class);
            image = weaponAnimationComponent.getCurrentFrame();
        }

        double hScale = gameWorld.getCurrentHeightScale();
        double wScale = gameWorld.getCurrentWidthScale();
        g.drawImage(image, entity.getX(), entity.getY(), (int)(entity.getWidth() * wScale), (int)(entity.getHeight() * hScale), null);
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
