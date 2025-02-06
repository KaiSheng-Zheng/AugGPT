public enum Direction {
    UP, DOWN, LEFT, RIGHT;
    public int dx() {
        switch (this) {
            case UP: return 0;
            case DOWN: return 0;
            case LEFT: return -1;
            case RIGHT: return 1;
            default: return 0;
        }
    }

    public int dy() {
        switch (this) {
            case UP: return -1;
            case DOWN: return 1;
            case LEFT: return 0;
            case RIGHT: return 0;
            default: return 0;
        }
    }
}