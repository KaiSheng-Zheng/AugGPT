public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int compare(Location location1, Location location2) {
        if (location1.getX() < location2.getX()) {
            return -1;
        } else if (location1.getX() > location2.getX()) {
            return 1;
        } else {
            return Integer.compare(location1.getY(), location2.getY());
        }
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
