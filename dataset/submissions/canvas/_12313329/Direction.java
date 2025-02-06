public enum Direction {
    LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN;
    public static Direction getByIndex(int index) {
        Direction[] directions = Direction.values();
        return directions[index];
    }
}
