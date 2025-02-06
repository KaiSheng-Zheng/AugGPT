public abstract class Shape {

    protected Location location;
    protected char pattern;
    protected char[][] grids;


    protected int area;

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

    public String toString() {
        return String.format("%s: %s area=%d pattern=%c", this.getClass().getName(), this.location, this.area, this.pattern);
    }

    public int getX() {
        return location.getX();
    }

    public int getY() {
        return location.getY();
    }

    public char getPattern() {
        return pattern;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
