public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction fromString(String directionStr) {
        switch (directionStr.toUpperCase()) {
            case "UP":
                return UP;
            case "DOWN":
                return DOWN;
            case "LEFT":
                return LEFT;
            case "RIGHT":
                return RIGHT;
            default:
                throw new IllegalArgumentException("Invalid direction: " + directionStr);
        }
    }
}