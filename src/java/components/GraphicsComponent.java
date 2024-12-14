package components;

import java.awt.*;
import objects.Entity;

public class GraphicsComponent {
    private Image image;
    Entity entity;

    public GraphicsComponent(Image image, Entity entity) {
        this.entity = entity;
        this.image = image;
    }

    public void render(Graphics g) { // double scaleX, double scaleY
        if(entity.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = entity.getComponent(AnimationComponent.class);
            animationComponent.update();
            image = animationComponent.getCurrentFrame();
        }
        if(entity.hasComponent(WeaponAnimationComponent.class)) {
            WeaponAnimationComponent weaponAnimationComponent = entity.getComponent(WeaponAnimationComponent.class);
            image = weaponAnimationComponent.getCurrentFrame();
        }
        g.drawImage(image, entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), null);
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
