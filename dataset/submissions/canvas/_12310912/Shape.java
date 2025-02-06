public abstract class Shape {
    protected char[][] grids;

    public char getPattern() {
        return pattern;
    }

    protected char pattern;

    public Location getLocation() {
        return location;
    }

    protected Location location;

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public Shape(Location location, char pattern) {
        this.pattern = pattern;
        this.location = location;
    }

    public String toString() {
        return String.format("%s: %s area=%d pattern=%c", getClass().getSimpleName(), location.toString(), area(), pattern);
    }
}