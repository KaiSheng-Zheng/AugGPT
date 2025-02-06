public abstract class Shape {
    protected char[][] grids;
    protected Location location;
    protected char pattern;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public abstract String toString();

    public char[][] getGrids(){
        return grids;
    }

    public Location getLocation() {
        return location;
    }

    public char getPattern() {
        return pattern;
    }
}
