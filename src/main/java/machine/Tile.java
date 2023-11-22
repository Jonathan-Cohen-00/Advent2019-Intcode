package machine;

public enum Tile {
    EMPTY, WALL, BLOCK, HORIZONTAL_PADDLE, BALL;
    public static Tile tileFromInt(int entier) {
        return switch (entier) {
            case 0 -> EMPTY;
            case 1 -> WALL;
            case 2 -> BLOCK;
            case 3 -> HORIZONTAL_PADDLE;
            case 4 -> BALL;
            default -> null;
        };
    }
}
