public enum Direction {
    LEFT_DOWN,
    RIGHT_UP,
    RIGHT_DOWN,
    LEFT_UP;
    public static Direction fromIndex(int index) {
        switch (index) {
            case 0: return LEFT_UP;
            case 1: return LEFT_DOWN;
            case 2: return RIGHT_UP;
            case 3: return RIGHT_DOWN;
            default: return null;
        }
    }
}