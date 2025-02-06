public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int area;
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
    public abstract char getPattern();
    public abstract int getLocationX();
    public abstract int getLocationY();
}
