public abstract class Shape {
    protected static char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        fillGrids();
    }

    public Shape() {

    }




    public  char[][] getGrids() {
        fillGrids();
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}