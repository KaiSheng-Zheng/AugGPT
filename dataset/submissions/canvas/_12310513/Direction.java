public enum Direction {
    LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN;
    public static Direction direction(int index) {
        return switch (index) {
            case 0 -> Direction.LEFT_UP;
            case 1 -> Direction.LEFT_DOWN;
            case 2 -> Direction.RIGHT_UP;
            case 3 -> Direction.RIGHT_DOWN;
            default -> throw new IllegalArgumentException("Invalid index for Direction");
        };
    }
    }