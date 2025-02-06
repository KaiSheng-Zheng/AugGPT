public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int filledgrids;
    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        filledgrids = 0;
    }
    public char[][] getGrids() {
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
