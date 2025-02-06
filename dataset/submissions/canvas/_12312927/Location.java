public class Location {
    private int x;
    private int y;

    public Location(int y, int x) { // reversed order.
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
