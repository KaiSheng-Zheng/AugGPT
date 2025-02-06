public abstract class Shape {
    protected Location location;
    protected char pattern;
    protected char[][] grids;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }
    public Location getLocation() {
        return location;
    }
    protected abstract void fillGrids();

    public char[][] getGrids() {
        return grids;
    }
    public abstract int area();
    public abstract void enlarge();
    public abstract void shrink();

    @Override
    public abstract String toString();

    public char getPattern() {
        return this.pattern;
    }

    public int getArea() {
        return area();
    }
}