
import java.util.*;
public abstract class Shape
{
    protected int m;
    protected int n;
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected static final char EMPTY=' ';
    public Shape(Location location,char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public int area(){
        int area = 0;
        for (int i = 0; i <m; i++)
            for (int j = 0; j <n; j++)
                if (grids[i][j] == pattern)
                    area++;
        return area;
    }
    public ArrayList<Location> occupiedLocations(){
        ArrayList<Location> locations=new ArrayList<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grids[i][j]==pattern)
                    locations.add(new Location(location.getX()+i,location.getY()+j));
        return locations;
    }
    @Override public String toString(){
        StringBuilder out=new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                out.append(grids[i][j]);
            out.append('\n');
        }
        return out.toString();
    }
    static class AreaComparator
    implements Comparator<Shape>
    {
        @Override public int compare(Shape shape1,Shape shape2){
            if(shape1.area()-shape2.area()!=0)
                return shape1.area()-shape2.area();
            return shape1.pattern-shape2.pattern;
        }
    }
    static class LocationComparator
    implements Comparator<Shape>
    {
        @Override public int compare(Shape shape1,Shape shape2){
            if(shape1.location.getX()-shape2.location.getX()!=0)
                return shape1.location.getX()-shape2.location.getX();
            if(shape1.location.getY()-shape2.location.getY()!=0)
                return shape1.location.getY()-shape2.location.getY();
            return shape1.pattern-shape2.pattern;
        }
    }
}
