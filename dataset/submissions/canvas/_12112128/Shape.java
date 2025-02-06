public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        fillGrids();
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public String toString() {
        return String.format("%s: %s area=%d pattern=%c", getClass().getSimpleName(), location, area(), pattern);
    }
}
