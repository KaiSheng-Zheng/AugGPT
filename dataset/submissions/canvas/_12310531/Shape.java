public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape() {}
    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        // The initialization of grids array will be done in the subclasses based on specific shape dimensions.
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
        return String.format(this.getClass().getSimpleName() + ": " + "(" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern);
    }
}


