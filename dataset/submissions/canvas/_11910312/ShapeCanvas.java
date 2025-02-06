
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public abstract class ShapeCanvas {
    protected final int width;
    protected final int height;
    protected final List<Shape> shapes = new ArrayList<>();

    protected ShapeCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract boolean addShape(int x, int y, char pattern, int... params);

    public int getShapeCount() {
        return shapes.size();
    }

    public List<Shape> getShapesByArea() {
        shapes.sort(Comparator.comparingInt(Shape::area)
                .thenComparing(Shape::getPattern));
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        shapes.sort(Comparator.comparingInt((Shape s) -> s.getLocation().getX())
                .thenComparingInt(s -> s.getLocation().getY())
                .thenComparing(Shape::getPattern));
        return shapes;
    }

    public abstract char[][] getCanvas();
}