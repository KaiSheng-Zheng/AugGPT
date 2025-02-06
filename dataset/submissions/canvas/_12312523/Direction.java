public enum Direction {
    LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN;

    public static Direction matchIntToDir(int para) {
        Direction d = LEFT_UP;
        if (para == 0) {
            d = LEFT_UP;
        } else if (para == 1) {
            d = LEFT_DOWN;
        } else if (para == 2) {
            d = RIGHT_UP;
        } else if (para == 3) {
            d = RIGHT_DOWN;
        }
        return d;
    }
}
