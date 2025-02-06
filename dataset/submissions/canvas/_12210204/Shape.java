public abstract class Shape implements Comparable<Shape> {
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

    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    @Override
    public String toString() {
        return String.format("%s: %s area=%d pattern=%c",
                getClass().getSimpleName(),
                location.toString(),
                area(), pattern);
    }

    @Override
    public int compareTo(Shape other) {
        int areaCompare = Integer.compare(this.area(), other.area());
        if (areaCompare != 0) {
            return areaCompare;
        }
        return Character.compare(this.pattern, other.pattern);
    }
}
