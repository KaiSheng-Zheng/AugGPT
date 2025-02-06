public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }
    public char[][] getGrids() {
        fillGrids();
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public String toString() {
        return getClass().getSimpleName() + ": (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }

    public int getLocationX() {
        return location.getX();
    }
    public int getLocationY() {
        return location.getY();
    }
    public int ASC() {
        return pattern;
    }
}
