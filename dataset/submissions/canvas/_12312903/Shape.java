
//I deleted some of the getter setter method
public abstract class Shape {
    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public int numberOfFilledGrids = 0;

    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }




    public Location getLocation() {
        return location;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

}
