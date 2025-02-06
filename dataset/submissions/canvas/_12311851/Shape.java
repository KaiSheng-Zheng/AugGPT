public abstract class Shape  {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    private int X;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    private int Y;
    public Shape(Location location, char pattern) {

        this.location = location;

        this.pattern = pattern;
this.X=location.getX();
this.Y=location.getY();
    }

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }

    public abstract char[][] getGrids() ;
       //

    public abstract void fillGrids();
    //Fill in the specific shapes with the pattern style into the grids. How to fill grids is determined by the
    //concrete subclass of shape.
    public abstract void enlarge();
    //Enlarge the shape. How to enlarge a shape is determined by the concrete subclass of shape
    public abstract void shrink();
    //Shrink the shape. How to shrink a shape is determined by the concrete subclass of shape
    public abstract int area();




    //Return the count of patterns that being filled in grids.
}
