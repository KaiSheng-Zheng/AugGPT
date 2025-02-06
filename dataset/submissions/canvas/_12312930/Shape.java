public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location,char pattern ) {
        this.pattern = pattern;
        this.location = location;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract String toString();

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }
}
