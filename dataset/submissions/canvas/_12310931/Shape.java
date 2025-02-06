public abstract class Shape {
    protected char[][] grids = new char[31][31];
    protected char[][] grid = new char[31][31];
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char[][] getGrids() {
        return grids;
    }
    public char getPattern() {
        return pattern;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
