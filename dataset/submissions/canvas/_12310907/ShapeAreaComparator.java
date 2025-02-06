import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double area1 = calculateArea(shape1);
        double area2 = calculateArea(shape2);
        int areaComparison = Double.compare(area1, area2);
        if (areaComparison != 0) {
            return areaComparison;
        } else {
            return Character.compare(shape1.pattern, shape2.pattern);
        }
    }

    private double calculateArea(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * Math.pow(circle.getRadius(), 2);
        } else if (shape instanceof RightTriangle) {
            RightTriangle rt = (RightTriangle) shape;
            return 0.5 * rt.getWidth() * rt.getHeight();
        }
        return 0;
    }
}
