public abstract class Shape implements Comparable<Shape> {
    protected char[][] grids;
    protected char pattern;
    protected Location location; // will be useful in assignment 6(need to define setter and getter)

    //Constructor
    public Shape(Location location, char pattern) {
        this.location = location; // need to check back
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
    public int compareTo(Shape other) {
        return Character.compare(this.pattern, other.pattern);
    }

}

//u may need toString here
