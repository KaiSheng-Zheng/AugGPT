import java.util.*;

public abstract class Shape implements Comparable<Shape> {

    protected Location location;
    protected char pattern;
    protected char[][] grids;


    protected int area;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }
    public Location getLocation() {
        return location;
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
    public int compareToByArea(Shape other) {
        if (this.area < other.area) {
            return -1;
        } else if (this.area > other.area){
            return 1;
        }else {
            return Character.compare(this.pattern, other.pattern);
        }

    }

    public int compareToByLocation(Shape other){
        if (this.location.getX()<other.location.getX()){
            return  -1;
        } else if (this.location.getX()>other.location.getX()) {
            return  1;
        }else {
            if (this.location.getY()<other.location.getY()){
                return -1;
            } else if (this.location.getY()>other.location.getY()) {
                return  1;
            }else {
                return Character.compare(this.pattern, other.pattern);
            }
        }
    }


    public int getArea() {
        return area;
    }

    public abstract char getPattern();
}