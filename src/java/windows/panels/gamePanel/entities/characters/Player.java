package windows.panels.gamePanel.entities.characters;

import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.equipment.Equipment;
import windows.panels.gamePanel.equipment.weapons.Weapon;
import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.factories.PlayerFactory;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.*;
import java.awt.geom.Point2D;

public class Player extends Character {
    private static final int defaultPlayerHeight = 75;
    private static final int defaultPlayerWidth = 50;
    private final Equipment equipment;

    public Player(String name, CharacterStat characterStat, GamePanel gamePanel, Room myRoom) {
        super(name, defaultPlayerWidth, defaultPlayerHeight, characterStat, gamePanel, myRoom);
        PlayerFactory.loadDefaultPlayerAnimationFrames(this);
        this.equipment = new Equipment();
    }


    public void render(Graphics2D g) {
        Weapon weapon = getEquipment().getWeapon();

        if(weapon != null && weapon.getDirection() == FaceDirection.NORTH){
            weapon.render(g);
        }

        this.getComponent(GraphicsComponent.class).render(g);

        if(weapon != null && weapon.getDirection() != FaceDirection.NORTH){
            weapon.render(g);
        }

    }

    public void playerLeftClick(){
        if(this.hasComponent(AttackComponent.class)) {
            this.getComponent(AttackComponent.class).attack();
        }
    }

    public void playerRightClick(){
        // Right click logic
    }

    public boolean hasWeapon(){
        return getEquipment().getWeapon() != null;
    }

    @Override
    public Point2D getHandPosition(FaceDirection direction) {
        return switch (direction) {
            case NORTH -> playerHandPosition.NORTH;
            case SOUTH -> playerHandPosition.SOUTH;
            case EAST -> playerHandPosition.EAST;
            case WEST -> playerHandPosition.WEST;
            default -> null;
        };
    }

    @Override
    public CharacterStat getStats() {
        return characterStat;
    }

    @Override
    public void update() {
        if (this.hasComponent(MovementComponent.class)) {
            MovementComponent movement = this.getComponent(MovementComponent.class);
            if (movement != null) {
                movement.updatePosition(this);
            }
        }
    }

    @Override
    public void die() {
        System.out.println("Player died");
        this.isAlive = false;
        this.getComponent(AnimationComponent.class).setAnimationState(AnimationState.DEAD);
    }

    public static class playerHandPosition{
        public static final int playerHeight = 26;
        public static final int playerWidth = 22;

        public static final Point2D NORTH = new Point2D.Float((float) 19 / playerWidth, (float) 18 / playerHeight);
        public static final Point2D SOUTH = new Point2D.Float((float) 2 / playerWidth, (float) 18 / playerHeight);
        public static final Point2D EAST = new Point2D.Float((float) 6 / playerWidth, (float) 19 / playerHeight);
        public static final Point2D WEST = new Point2D.Float((float) 2 / playerWidth, (float) 19 / playerHeight);
    }

    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public void setDirection(FaceDirection direction) {
        if(equipment.getWeapon() != null){
            equipment.getWeapon().setDirection(direction);
        }
        this.direction = direction;
    }

    @Override
    public void onDeathAnimationEnd() {
        super.onDeathAnimationEnd();
        gamePanel.gameOver();
    }
}
