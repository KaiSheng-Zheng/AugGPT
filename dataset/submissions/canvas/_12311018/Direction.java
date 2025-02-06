public enum Direction {
    LEFT_UP(0), LEFT_DOWN(1), RIGHT_UP(2), RIGHT_DOWN(3);
    final int value;
    Direction(int value) {
        this.value = value;
    }
    public static Direction GetCorrespondingDirection(int value) {
        for (Direction direction : Direction.values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in enum Direction");
    }
}
