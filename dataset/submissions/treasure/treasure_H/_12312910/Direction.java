public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
    public static String toString(Direction direction) {
        switch (direction) {
            case UP:
                return "UP";

            case DOWN:
                return "DOWN";

            case LEFT:
                return "LEFT";

            case RIGHT:
                return "RIGHT";

            default:
                return "";
        }
    }
}