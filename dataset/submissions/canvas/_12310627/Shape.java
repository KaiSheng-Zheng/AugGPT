import java.util.Comparator;

public abstract class Shape{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int sum=0;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    @Override
    public String toString() {
        return String.format("%s: %s area=%d pattern=%c",this.getClass().getName(),this.location,this.area(),this.pattern);
    }

    public int compareTo(Shape o) {

        return 0;
    }
}

class AreaComparator implements Comparator<Shape>{
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.area()<o2.area()){
            return -1;
        }
        if (o1.area()>o2.area()){
            return 1;
        }
        if (o1.area()==o2.area()){
            if(o1.pattern<o2.pattern){
                return -1;
            }
            if(o1.pattern>o2.pattern){
                return 1;
            }
        }
        return 0;
    }
}
class LocationComparator implements Comparator<Shape>{
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.location.getX()<o2.location.getX()){
            return -1;
        }
        if(o1.location.getX()>o2.location.getX()){
            return 1;
        }
        if(o1.location.getX()==o2.location.getX()){
            if(o1.location.getY()<o2.location.getY()){
                return -1;
            }
            if(o1.location.getY()>o2.location.getY()){
                return 1;
            }
            if(o1.location.getY()==o2.location.getY()){
                if(o1.pattern<o2.pattern){
                    return -1;
                }
                if(o1.pattern>o2.pattern){
                    return 1;
                }
            }
        }
        return 0;
    }
}