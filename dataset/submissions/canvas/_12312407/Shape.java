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

    protected abstract void fillGrids();

    protected abstract void enlarge();

    protected abstract void shrink();

    public abstract int area();

    public String toString() {
        String className = this.getClass().getSimpleName();
        String locationStr = location.toString();
        int area = area();
        String patternStr = String.valueOf(pattern);
        return String.format("%s: %s area=%d pattern=%c", className, locationStr, area, pattern);
    }
}