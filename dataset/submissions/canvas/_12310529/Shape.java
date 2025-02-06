public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    @Override
    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%c",
                this.getClass().getName(), this.location.getX(), this.location.getY(), this.area(), this.pattern);
    }
}
