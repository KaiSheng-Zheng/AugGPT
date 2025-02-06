abstract class Shape implements Comparable<Shape> {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        this.grids = new char[0][0];
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    @Override
    public int compareTo(Shape other) {
        int areaComparison = Integer.compare(this.area(), other.area());
        if (areaComparison == 0) {
            return Character.compare(this.pattern, other.pattern);
        }
        return areaComparison;
    }
}


