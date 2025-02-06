import java.util.Comparator;

public class LocationComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.location.getX() != o2.location.getX())
            return o1.location.getX() - o2.location.getX();
        else if(o1.location.getY() != o2.location.getY())
            return o1.location.getY() - o2.location.getY();
        else return o1.pattern - o2.pattern;
    }
}
