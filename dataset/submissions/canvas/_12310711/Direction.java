public enum Direction {
    LEFT_UP,
    LEFT_DOWN,
    RIGHT_UP,
    RIGHT_DOWN

    }
class A {
    public static Direction int2dir(int num) {
        switch (num) {
            case 0:
                return Direction.LEFT_UP;
            case 1:
                return Direction.LEFT_DOWN;
            case 2:
                return Direction.RIGHT_UP;
            case 3:
                return Direction.RIGHT_DOWN;
            default:
                return null;
        }
    }
}