public enum Direction {
    LEFT_UP,
    LEFT_DOWN,
    RIGHT_UP,
    RIGHT_DOWN;

    public static Direction fromInteger(int value) {
        switch (value) {
            case 0:
                return LEFT_UP;
            case 1:
                return LEFT_DOWN;
            case 2:
                return RIGHT_UP;
            case 3:
                return RIGHT_DOWN;
            default:
                throw new IllegalArgumentException("Invalid integer value for Direction.");
        }
    }
}