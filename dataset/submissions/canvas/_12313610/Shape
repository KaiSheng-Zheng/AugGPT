public abstract class Shape {
    protected Location location;
    protected char pattern;
    protected char[][] grids;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        this.grids = new char[0][0];
    }

    public Location getLocation() {

        return location;
    }

    public char getPattern() {
        return pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    protected abstract void fillGrids();


    public abstract void enlarge();

    public abstract void shrink();



    public abstract int area();
    public abstract int getHeight();
    public abstract int getWidth();


    @Override
    public String toString() {
        return getClass().getSimpleName() + ": (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}