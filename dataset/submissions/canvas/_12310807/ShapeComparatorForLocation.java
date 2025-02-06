import java.util.Comparator;

public class ShapeComparatorForLocation implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        if(s1.getX()>s2.getX()){
            return 1;
        } else if (s1.getX()<s2.getX()) {
            return -1;
        }
        else if (s1.getY()>s2.getY()){
            return 1;
        } else if (s1.getY()<s2.getY()) {
            return -1;
        }
        else return s1.pattern()-s2.pattern();
    }
}
