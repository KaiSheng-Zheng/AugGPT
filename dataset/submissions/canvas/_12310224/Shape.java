public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids() {
        return this.grids;
    }
    public void fillGrids(){}
    public void enlarge(){}
    public void shrink(){}
    public abstract int area();
}

