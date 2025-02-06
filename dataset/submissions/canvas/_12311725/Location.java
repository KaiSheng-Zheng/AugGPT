public class Location {
    protected int x;
    protected int y;
    public Location(int x, int y) {
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
