public abstract class Shape{
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;

    }

    public char[][] getGrids(){
        return grids;
    }

    public abstract void setGrids(char[][] grids);

    public abstract void enlarge();

    public abstract void shrink();

    public abstract void setArea(int area);

    public abstract int area();

    public abstract String toString();
}