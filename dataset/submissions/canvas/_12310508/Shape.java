public abstract class Shape {
    protected char[][] grids;

    protected char pattern;

    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    protected int width;

    protected int height;

    protected Direction d;

    public abstract char[][] getGrids();


    public abstract void fillGrids();

    public abstract int area();
}


