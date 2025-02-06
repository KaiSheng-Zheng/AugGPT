
public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public char[][] getGrids() {
        return grids;
    }

    @Override
    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%c", this.getClass().getSimpleName(), location.getX(), location.getY(), area(), pattern);
    }
}
