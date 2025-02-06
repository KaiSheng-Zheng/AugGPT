public abstract class Shape {
    protected char[][] grids;
    protected char pattern;

    public char getPattern() {
        return pattern;
    }

    protected Location location;

    public Location getLocation() {
        return location;
    }

    public Shape(Location location, char pattern) {
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
