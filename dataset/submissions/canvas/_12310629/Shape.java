import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>{

    protected Location location;
    protected char pattern;
    protected char[][] grids;


    protected int area;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public String toString(){
        return String.format("%s: %s area=%d pattern=%c",this.getClass().getName(),this.location,this.area,this.pattern);
    }

    public char getPattern() {
        return pattern;
    }

    public int compareTo(Shape shape){
        if (this.area<shape.area){
            return -1;
        }else if (this.area>shape.area){
            return 1;
        }else if (this.pattern>shape.pattern){
            return 1;
        }else if (this.pattern<shape.pattern){
            return -1;
        }else {
            return 0;
        }
    }

    public Location getLocation() {
        return location;
    }
}
