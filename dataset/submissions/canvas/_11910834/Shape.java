public abstract class Shape {

    protected Location location;
    protected int x, y;
    protected char pattern;
    protected char[][] grids;


    protected int area;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
        this.x = location.getX();
        this.y = location.getY();
    }

    public char[][] getGrids() {
        return grids;
    }

    public Location getLocation() {
        return location;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getPattern() {
        return pattern;
    }

    public int getArea() {
        return area;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public String toString(){
        return String.format("%s: %s area=%d pattern=%c",this.getClass().getName(),this.location,this.area,this.pattern);
    }
}
