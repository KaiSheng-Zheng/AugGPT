public abstract class Shape {
    //abstract class
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int[] params;
    protected char[][] canvas;
    public Shape(Location location, char pattern,int...params) {
        this.location = location;
        this.pattern = pattern;
        this.params= params;
    }
    public void setParams(int[] params) {
        this.params = params;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public Location getLocation() {
        return location;
    }
    public char getPattern() {
        return pattern;
    }
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public String toString(){
        return getClass().getName() +": "+location+" area="+area()+" pattern="+pattern;
    }

}
