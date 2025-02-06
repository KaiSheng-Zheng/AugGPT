//package src;

public abstract class Shape {
    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    protected char[][] grids;

    public char getPattern() {
        return pattern;
    }

    public void setPattern(char pattern) {
        this.pattern = pattern;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    protected char pattern;

    public Shape(Location location, char pattern) {
        this.pattern = pattern;
        this.location = location;
    }

    protected Location location;


    public char[][] getGrids() {
        fillGrids();
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public abstract String toString();
}
