import java.util.Comparator;

public class ShapeComparatorForArea implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        int area1 = s1.area();
        int area2 = s2.area();
        if (area1 < area2) {
            return -1;
        } else if (area1 > area2) {
            return 1;
        } else {
            char pattern1 = s1.pattern();
            char pattern2 = s2.pattern();
            return Character.compare(pattern1, pattern2);
        }
    }
}
