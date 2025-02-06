import java.util.Comparator;

public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern) {
        this.location=location;
        this.pattern=pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}
class OrderByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape o1,Shape o2) {
        if(o1.area()<o2.area())
            return -1;
        else if(o1.area()>o2.area())
            return 1;
        else {
            if(o1.pattern<o2.pattern)
                return -1;
            else if(o1.pattern>o2.pattern)
                return 1;
            return 0;
        }
    }
}
class OrderByLocation implements Comparator<Shape> {
    @Override
    public int compare(Shape o1,Shape o2) {
        if(o1.location.getX()<o2.location.getX())
            return -1;
        else if(o1.location.getX()>o2.location.getX())
            return 1;
        else {
            if(o1.location.getY()<o2.location.getY())
                return -1;
            else if(o1.location.getY()>o2.location.getY())
                return 1;
            else {
                if(o1.pattern<o2.pattern)
                    return -1;
                else if(o1.pattern>o2.pattern)
                    return 1;
                return 0;
            }
        }
    }
}