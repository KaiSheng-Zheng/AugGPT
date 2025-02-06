

public enum Direction {
    LEFT_UP(0), LEFT_DOWN(1), RIGHT_UP(2), RIGHT_DOWN(3);
    private final int  value;

    private Direction(int value) {
        this.value = value;
    }
    public static Direction valueOf(int value) {
        for (Direction direction : values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Direction.class.getName() + "." + value);
    }
}

