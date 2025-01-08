package windows.panels.gamePanel.entities.characters.enemies.bosses;

import factories.EnemyFactory;
import factories.SoundFactory;
import factories.StatFactory;
import windows.panels.gamePanel.GamePanel;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.components.*;
import windows.panels.gamePanel.entities.characters.enemies.enemyBehaviours.*;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.stats.CharacterStat;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class MagmaBoss extends Boss {
    private final MagmaBossAI bossAI;
    private static final int defaultBossHeight = 200;
    private static final int defaultBossWidth = 200;

    public MagmaBoss(String name, GamePanel gamePanel, GameWorld gameWorld, Room myRoom) {
        super(name, defaultBossWidth, defaultBossHeight, StatFactory.getMagmaBossStat(), gamePanel, myRoom);
        double speed = this.getStats().getMovementSpeed();
        Image image = EnemyFactory.getDefaultSlimeImage();
        this.addComponent(MovementComponent.class, new MovementComponent(speed, false));
        this.addComponent(GraphicsComponent.class, new GraphicsComponent(image, this, gameWorld));
        this.addComponent(AnimationComponent.class, new AnimationComponent(this));
        this.addComponent(CollisionComponent.class, new CollisionComponent(this));
        this.addComponent(DamageComponent.class, new DamageComponent(this));
        this.addComponent(AttackComponent.class, new AttackComponent(this));
        this.addComponent(SoundComponent.class, new SoundComponent(gamePanel.getMainFrame()));
        loadSlimeSounds();
        this.bossAI = new MagmaBossAI(this);
    }

    private void loadSlimeSounds(){
        SoundComponent soundComponent = this.getComponent(SoundComponent.class);
        soundComponent.addDamageSound(SoundFactory.getSlimeDamage1Sound());
        soundComponent.addDamageSound(SoundFactory.getSlimeDamage2Sound());
        soundComponent.addDamageSound(SoundFactory.getSlimeDamage3Sound());
        soundComponent.addDeathSound(SoundFactory.getSlimeDeathSound());
    }

    @Override
    public Point2D getHandPosition(FaceDirection direction) {
        return null;
    }

    @Override
    public CharacterStat getStats() {
        return StatFactory.getMagmaBossStat();
    }

    @Override
    public void die() {
        this.isAlive = false;
        this.getComponent(SoundComponent.class).playDeathSound();
        this.getComponent(AnimationComponent.class).setAnimationState(AnimationState.DEAD);
    }

    @Override
    public void update() {
        this.bossAI.update();
        this.getComponent(MovementComponent.class).updatePosition(this);
        this.getComponent(AttackComponent.class).attack();

    }

    @Override
    public void render(Graphics2D g) {
        this.getComponent(GraphicsComponent.class).render(g);
    }

    public class MagmaBossAI {
        private final MagmaBoss slime;
        private final int detectRange = 1000;
        private final Map<BehaviourStrategyType, EnemyBehaviourStrategy> behaviourStrategies;

        public MagmaBossAI(MagmaBoss slime) {
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
            return this.behaviourStrategies.get(BehaviourStrategyType.AGGRESSIVE);
        }
    }
}
