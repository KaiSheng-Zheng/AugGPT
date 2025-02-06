import java.util.List;

public interface ShapeCanvas {
    boolean addShape(int x, int y, char pattern, int radius);
    boolean addShape(int x, int y, char pattern, int width, int height, int direction);
    int getSpaceGridCount();
    int getShapeCount();
    List<Shape> getShapesByArea();
    List<Shape> getShapesByLocation();
    char[][] getCanvas();
}
