public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {}

    public Shape() {
        pattern = ' ';

    }

    public char[][] getGrids() {
        return grids;
    }

    public Location getLocation() { return location; }
    public char getPattern() { return pattern; }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

}
