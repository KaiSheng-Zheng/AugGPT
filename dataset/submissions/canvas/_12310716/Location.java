public class Location {
    private static int x;
    private static int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public static int getX(Shape shape) {
        return getX();
    }

    public static int getY(Shape shape) {
        return getY();
    }
}
