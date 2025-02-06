public abstract class Shape {
    protected char pattern;
    protected int area;
    protected Location location;
    protected char[][] grids;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() { return grids; }

    protected abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();
    public Location getLocation() {
        return location;
    }

    public char getPattern() {
        return pattern;
    }
    public abstract int area();

    public abstract double getArea();

    public int compareTo(Shape other) {
        int areaCompare = Double.compare(this.getArea(), other.getArea());
        if (areaCompare == 0) {
            return Character.compare(this.pattern, other.pattern);
        }
        return areaCompare;
    }
    @Override
    public String toString() {
        return String.format("[%s]:(%d,%d) area=%d pattern=%c",
                getClass().getSimpleName(), location.getX(), location.getY(), area(), pattern);
    }
}