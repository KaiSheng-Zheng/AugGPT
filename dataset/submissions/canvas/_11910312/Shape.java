public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

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
                this.getClass().getSimpleName(), location.getX(), location.getY(), area(), pattern);
    }

    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

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
}
