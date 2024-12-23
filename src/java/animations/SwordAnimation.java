package animations;

import components.Direction;
import equipment.weapons.WeaponState;
import equipment.weapons.swords.Sword;
import gameWindow.GameWorld;
import imageUtilities.ImageUtils;
import objects.characters.Player;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class SwordAnimation extends WeaponAnimation {
    private static final int BASE_ANGLE = 0;
    private static final int MOVE_ANGLE = 60; // Rotation angle for the swing
    private final GameWorld gameWorld;

    public SwordAnimation(Sword sword, GameWorld gameWorld) {
        super(sword);
        this.gameWorld = gameWorld;
    }

    private Image getTransformedImage(Player owner, Image frame, Direction direction, double angle, double wScale, double hScale) {
        if (frame == null) {
            return null;
        }

        // Convert Image to BufferedImage
        BufferedImage bufferedFrame = new BufferedImage(
                frame.getWidth(null),
                frame.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2d = bufferedFrame.createGraphics();
        g2d.drawImage(frame, 0, 0, null);
        g2d.dispose();

        // Create a new BufferedImage for the transformed image
        BufferedImage transformedFrame = new BufferedImage(
                bufferedFrame.getWidth(),
                bufferedFrame.getHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2dTransformed = transformedFrame.createGraphics();

        // Set up the transformation (rotation based on grip point)
        AffineTransform transform = new AffineTransform();

        // Get the player's hand position based on their direction
        Point2D handPosition = owner.getHandPosition(weapon.getDirection());

        Point gripPoint = weapon.getGripPoint(weapon.getDirection());

        transform.translate(gripPoint.x * wScale, gripPoint.y * hScale);
        transform.rotate(Math.toRadians(angle));
        transform.translate(-gripPoint.x * wScale, -gripPoint.y * hScale);

        // Draw the transformed image
        g2dTransformed.drawImage(bufferedFrame, transform, null);
        g2dTransformed.dispose();

        return transformedFrame;
    }


    @Override
    public void render(Graphics2D g, Player owner) {
        Image frame = getCurrentFrame();

        // Return if no frame is available
        if (frame == null) {
            return;
        }

        // Calculate scaling based on the current game room
        double wScale = gameWorld.getCurrentWidthScale();
        double hScale = gameWorld.getCurrentHeightScale();

        // Get the player's hand position based on their direction
        Point2D handPosition = owner.getHandPosition(weapon.getDirection());

        // Calculate the pixel position of the hand
        int handX = (int) (owner.getX() + handPosition.getX() * owner.getWidth() * wScale);
        int handY = (int) (owner.getY() + handPosition.getY() * owner.getHeight() * hScale);

        if (weapon.getDirection() == Direction.WEST) {
            //handX -= (int) (weapon.getWidth() * wScale) - (int) (handPosition.getX() * owner.getWidth() * wScale);
            frame = ImageUtils.horizontalFlip((BufferedImage) frame);
        }

        if (weapon.getDirection() == Direction.SOUTH) {
            frame = ImageUtils.verticalFlip((BufferedImage) frame);
        }

        // Get the grip point of the weapon
        Point gripPoint = weapon.getGripPoint(weapon.getDirection());

        // Adjust frame for attacking state
        if (weapon.getState() == WeaponState.ATTACKING) {
            frame = getAttackImage(owner, frame, wScale, hScale);
        }

        // Scale the weapon's size
        int newWidth = (int) (weapon.getWidth() * wScale);
        int newHeight = (int) (weapon.getHeight() * hScale);

        // Draw the weapon image at the calculated position and size
        g.drawImage(frame, handX - (int) (gripPoint.x * wScale), handY - (int) (gripPoint.y * hScale), newWidth, newHeight, null);
    }

    public Image getAttackImage(Player owner, Image frame, double wScale, double hScale) {
        Direction direction = weapon.getDirection();

        // Determine the angle of rotation based on the direction
        double angle = switch (direction) {
            case EAST -> castTimeToAngle(weapon.getLastAttackTime(), weapon.getAttackDuration(), BASE_ANGLE, BASE_ANGLE + MOVE_ANGLE);
            case WEST -> castTimeToAngle(weapon.getLastAttackTime(), weapon.getAttackDuration(), BASE_ANGLE, BASE_ANGLE - MOVE_ANGLE);
            case NORTH -> castTimeToAngle(weapon.getLastAttackTime(), weapon.getAttackDuration(), BASE_ANGLE, BASE_ANGLE - MOVE_ANGLE);
            case SOUTH -> castTimeToAngle(weapon.getLastAttackTime(), weapon.getAttackDuration(), BASE_ANGLE, BASE_ANGLE + MOVE_ANGLE);
        };

        return getTransformedImage(owner, frame, direction, angle, wScale, hScale);
    }

    public double castTimeToAngle(long startTime, long duration, int startAngle, int finishAngle) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = Math.min(currentTime - startTime, duration); // Clamp elapsed time
        int totalAngle = finishAngle - startAngle;
        return startAngle + (double) totalAngle * elapsedTime / duration;
    }
}