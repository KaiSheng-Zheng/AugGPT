public abstract class Shape {
    protected char[][] grids;
    protected char pattern;

    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    protected Location location;

    public Shape(Location location, char pattern) {

    }

    public Shape() {

    }

    public char[][] getGrids() {
        return new char[0][];
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
