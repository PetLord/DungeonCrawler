package windows.panels.gamePanel.objects.characters;

import windows.panels.gamePanel.characterProfessions.CharacterProfession;
import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.equipment.weapons.Weapon;
import windows.panels.gamePanel.GamePanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Player extends Character {
    private GamePanel gamePanel;
    private static final int defaultPlayerHeight = 75;
    private static final int defaultPlayerWidth = 50;

    public Player(String name, CharacterProfession characterProfession, GamePanel gamePanel) {
        super(name, characterProfession, defaultPlayerWidth, defaultPlayerHeight, gamePanel);
    }

    public void addAnimationFrames(AnimationState state, ArrayList<Image> frames, double speed) {
        if (!this.hasComponent(AnimationComponent.class)) {
            AnimationComponent animationComponent = new AnimationComponent(this);
            this.addComponent(AnimationComponent.class, animationComponent);
        }
        this.getComponent(AnimationComponent.class).addAnimationFrames(state, frames, speed);

    }

    public void render(Graphics2D g) {
        Weapon weapon = getEquipment().getWeapon();

        if(weapon != null && weapon.getDirection() == Direction.NORTH){
            weapon.render(g);
        }

        this.getComponent(GraphicsComponent.class).render(g);

        if(weapon != null && weapon.getDirection() != Direction.NORTH){
            weapon.render(g);
        }

    }

    public void playerLeftClick(){
        Weapon w = getEquipment().getWeapon();
        if(w != null && w.canAttack()){
            w.attack();
        }
    }

    public void playerRightClick(){
        // Right click logic
    }

    public boolean hasWeapon(){
        return getEquipment().getWeapon() != null;
    }

    @Override
    public Point2D getHandPosition(Direction direction) {
        return switch (direction) {
            case NORTH -> playerHandPosition.NORTH;
            case SOUTH -> playerHandPosition.SOUTH;
            case EAST -> playerHandPosition.EAST;
            case WEST -> playerHandPosition.WEST;
            default -> null;
        };
    }

    public static class playerHandPosition{
        public static final int playerHeight = 26;
        public static final int playerWidth = 22;

        public static final Point2D NORTH = new Point2D.Float((float) 19 / playerWidth, (float) 18 / playerHeight);
        public static final Point2D SOUTH = new Point2D.Float((float) 2 / playerWidth, (float) 18 / playerHeight);
        public static final Point2D EAST = new Point2D.Float((float) 6 / playerWidth, (float) 19 / playerHeight);
        public static final Point2D WEST = new Point2D.Float((float) 2 / playerWidth, (float) 19 / playerHeight);
    }

}
