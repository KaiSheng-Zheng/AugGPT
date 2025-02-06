public enum Direction {
    LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN;
    public static Direction getByIndex(int index) {
        if (index < 0 || index >= values().length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return values()[index];
    }
}
