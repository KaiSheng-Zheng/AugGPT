import java.util.Comparator;

public abstract class Shape{
    protected char[][] grids; // row for longest vertical length; col for widest horizontal width
    protected char pattern; // the symbol thing
    protected Location location; //
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




}
