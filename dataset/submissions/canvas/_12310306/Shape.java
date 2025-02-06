import java.lang.Math;
public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int[][] coordinate;
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public static double distance(int x1, int y1, int x2, int y2 ){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public abstract String toString();
}
