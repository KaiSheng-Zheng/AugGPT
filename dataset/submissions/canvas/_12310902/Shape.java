import java.util.Objects;

public abstract class Shape {
    protected char[][]grids;
    protected char pattern;
    protected  Location location;

    public Shape(Location location, char pattern) {
        fillGrids();
        this.pattern = pattern;
        this.location = location;
    }

    public Shape() {

    }
    public char[][] getGrids() {
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract char getPattern();
    public abstract Location getLocation();
}
