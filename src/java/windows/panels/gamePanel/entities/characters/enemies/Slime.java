package windows.panels.gamePanel.entities.characters.enemies;

import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.characters.enemies.enemyBehaviours.*;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.factories.EnemyFactory;
import windows.panels.gamePanel.factories.StatFactory;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class Slime extends Enemy {
    private final SlimeAI slimeAI;
    private static final int defaultSlimeHeight = 50;
    private static final int defaultSlimeWidth = 50;

    public Slime(String name,  GamePanel gamePanel, GameWorld gameWorld, Room myRoom) {
        super(name, defaultSlimeWidth, defaultSlimeHeight, StatFactory.getSlimeStat(), gamePanel, myRoom);
        double speed = this.getStats().getMovementSpeed();
        Image image = EnemyFactory.getDefaultSlimeImage();
        this.addComponent(MovementComponent.class, new MovementComponent(speed, false));
        this.addComponent(GraphicsComponent.class, new GraphicsComponent(image, this, gameWorld));
        this.addComponent(AnimationComponent.class, new AnimationComponent(this));
        this.addComponent(CollisionComponent.class, new CollisionComponent(this));
        this.addComponent(DamageComponent.class, new DamageComponent(this));
        this.addComponent(AttackComponent.class, new AttackComponent(this));

        this.slimeAI = new SlimeAI(this);
    }

    @Override
    public void update() {
        this.slimeAI.update();
        this.getComponent(MovementComponent.class).updatePosition(this);
        this.getComponent(AttackComponent.class).attack();
    }

    @Override
    public void die() {
        System.out.println("Slime died");

        this.isAlive = false;
        this.getComponent(AnimationComponent.class).setAnimationState(AnimationState.DEAD);
    }

    @Override
    public void render(Graphics2D g) {
        this.getComponent(GraphicsComponent.class).render(g);
    }

    @Override
    public Point2D getHandPosition(FaceDirection direction) {
        return new Point2D.Double(this.getX() + this.getWidth() / 2.0, this.getY() + this.getHeight() / 2.0);
    }


    @Override
    public CharacterStat getStats() {
        return this.characterStat;
    }

    public class SlimeAI {
        private final Slime slime;
        private final int detectRange = 400;
        private final Map<BehaviourStrategyType, EnemyBehaviourStrategy> behaviourStrategies;

        public SlimeAI(Slime slime) {
            this.slime = slime;
            behaviourStrategies = new HashMap<>();
            behaviourStrategies.put(BehaviourStrategyType.AGGRESSIVE, new AggressiveBehaviorStrategy());
            behaviourStrategies.put(BehaviourStrategyType.PASSIVE, new WanderingBehaviourStrategy());
            behaviourStrategies.put(BehaviourStrategyType.DEFENSIVE, new DefensiveBehaviorStrategy());
        }

        public void update() {
            EnemyBehaviourStrategy behaviour = chooseBehaviour();
            //System.out.println(behaviour);
            if (behaviour != null) {
                behaviour.execute(slime);
            }
        }

        private EnemyBehaviourStrategy chooseBehaviour() {
             Player player = myRoom.getAliveCharacters().stream()
                    .filter(character -> character instanceof Player)
                    .map(character -> (Player) character)
                    .findFirst().orElse(null);

             if (player == null || slime.getDistance(player) > detectRange) {
                 return behaviourStrategies.get(BehaviourStrategyType.PASSIVE);
             }

             if(slime.getCurrentHealth() < slime.getStats().getMaxHealth() / 10){
                return this.behaviourStrategies.get(BehaviourStrategyType.DEFENSIVE);
             } else{
                return this.behaviourStrategies.get(BehaviourStrategyType.AGGRESSIVE);
             }
        }


    }

}
