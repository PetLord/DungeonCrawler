package windows.panels.gamePanel.entities.structures;

public enum WallDirection {
    NORTH, EAST, SOUTH, WEST;

    public WallDirection opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }

    public int getDeltaX() {
        return switch (this) {
            case NORTH, SOUTH -> 0;
            case EAST -> 1;
            case WEST -> -1;
        };
    }

    public int getDeltaY() {
        return switch (this) {
            case NORTH -> -1;
            case EAST, WEST -> 0;
            case SOUTH -> 1;
        };
    }
}
