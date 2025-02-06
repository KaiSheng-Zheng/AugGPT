public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(char pattern,Location location) {
        this.pattern = pattern;
        this.location = location;
    }

    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    public char[][] getGrids(){
        return grids;
    }
    public abstract char[][] fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract String toString();

    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }
}
