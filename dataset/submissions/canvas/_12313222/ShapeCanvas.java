import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);

    public int getSpaceGridCount();

    public int getShapeCount();

    public List<Shape> getShapesByArea();

    public List<Shape> getShapesByLocation();

    public char[][] getCanvas();

    boolean containsPoint(int x, int y, Shape shape);

    int getArea(Shape shape);

    int getX(Shape shape);

    int getY(Shape shape);
}