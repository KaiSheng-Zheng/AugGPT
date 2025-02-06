import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char[][] getGrids(){
        return this.grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public int compareTo(Shape s){
        if (location.getX() != s.location.getX())
            return location.getX() - s.location.getX();
        else if (location.getY() != s.location.getY())
            return location.getY() - s.location.getY();
        else return pattern - s.pattern;
    }
}

