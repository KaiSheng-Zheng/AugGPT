

public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
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
}
