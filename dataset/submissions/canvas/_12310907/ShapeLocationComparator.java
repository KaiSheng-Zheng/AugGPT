import java.util.Comparator;

public class ShapeLocationComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        int xComparison = Integer.compare(shape1.getLocation().getX(), shape2.getLocation().getX());
        if (xComparison != 0) {
            return xComparison;
        }
        if (shape1.getLocation().getX() == shape2.getLocation().getX()) {
            int yComparison = Integer.compare(shape1.getLocation().getY(), shape2.getLocation().getY());
            if (yComparison != 0) {
                return yComparison;
            }
        }
        return Character.compare(shape1.pattern, shape2.pattern);
    }
}
