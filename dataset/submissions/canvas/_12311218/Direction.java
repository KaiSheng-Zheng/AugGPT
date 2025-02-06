import java.util.Comparator;
public enum Direction {
    LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN
}
class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return (s1.area-s2.area==0)? s1.pattern-s2.pattern:s1.area-s2.area;
    }
}
class LocationComparator implements Comparator<Shape>{

    @Override
    public int compare(Shape s1, Shape s2) {
        Integer x1 = s1.location.getX();
        Integer x2 = s2.location.getX();
        if (x1.compareTo(x2)!=0){return x1.compareTo(x2);}
        Integer y1 = s1.location.getY();
        Integer y2 = s2.location.getY();
        if (y1.compareTo(y2)!=0){return Integer.compare(y1,y2);}
        return s1.pattern-s2.pattern;
    }
}