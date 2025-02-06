import java.util.ArrayList;
import java.util.List;

public abstract class Shape {

    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected List<Location> locations;
    public Shape(  Location location,char pattern) {
        this.location = location;
        this.pattern = pattern;

    }

    public char[][] getGrids() {
        return this.grids;
    }
public char getPattern() {return this.pattern;}
    public int getX() {return this.location.getX();}
    public int getY() {return this.location.getY();}
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
public String toString() {
return String.format("%s: (%d,%d) area=%d pattern=%s",this.getClass().getSimpleName(), location.getX(), location.getY(),this.area(),this.pattern);
}

    public List<Location> getLocations() {
        return locations;
    }
}
