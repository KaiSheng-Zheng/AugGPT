public abstract class Shape {
    protected char[][] grids;
    protected Location location;
    protected char pattern;
    public Shape(Location location, char pattern){
        this.pattern = pattern;
        this.location = location;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();


    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
