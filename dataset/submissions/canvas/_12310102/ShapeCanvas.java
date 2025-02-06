import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int radius);
    public boolean addShape(int x, int y, char pattern, int width, int height, int direction);
    public int getSpaceGridCount();
    public int getShapeCount();
    public List<Shape> getShapesByArea();
    public List<Shape> getShapesByLocation();
    public char[][] getCanvas();
}
