

abstract public class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location,char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract char pattern();
    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
}
