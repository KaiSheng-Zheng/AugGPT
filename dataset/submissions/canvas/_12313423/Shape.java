public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected int X;
    protected int Y;

    public Shape(Location location, char pattern){
        this.pattern = pattern;
        this.X = location.getX();
        this.Y = location.getY();
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
