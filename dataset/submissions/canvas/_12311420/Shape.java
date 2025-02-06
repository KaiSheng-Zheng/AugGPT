import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> , Comparator<Shape> {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public Shape(){}
    public char[][] getGrids(){
        char[][]grids=new char[this.grids.length][];
        for (int i = 0; i < this.grids.length; i++) {
            grids[i]=new char[this.grids[i].length];
            for (int j = 0; j < this.grids[i].length; j++) {
                grids[i][j]=this.grids[i][j];
            }
        }
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    @Override
    public int compareTo(Shape o) {
        int compareArea=Double.compare(this.area(),o.area());
        if (compareArea!=0)
            return compareArea;
        else
            return Character.compare(this.pattern,o.pattern);
    }

    protected Location getLocation() {
        return location;
    }

}
