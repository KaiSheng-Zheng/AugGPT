public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        fillGrids();
    }

    public Location getLocation() {
        return location;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    @Override
    public String toString() {
        return String.format("[%s]: %s area=%d pattern=%s", getClass().getSimpleName(), location, area(), pattern);
    }
}
