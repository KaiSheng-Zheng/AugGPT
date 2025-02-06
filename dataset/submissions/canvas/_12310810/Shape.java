public abstract class Shape {
    protected char[][]grids;
    protected char pattern;
    protected Location location;
    public int area;
    public Shape(Location location,char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract char[][] fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

}
