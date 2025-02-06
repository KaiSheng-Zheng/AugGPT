public abstract class Shape  {
    protected char[][] grids;
    protected int area;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){}
    public char[][] getGrids(){
        return this.grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
