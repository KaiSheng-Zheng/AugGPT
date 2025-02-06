import java.util.ArrayList;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern,int radius);
    boolean addShape(int x, int y, char pattern, int width, int height, int d);
    public int getSpaceGridCount();
    public int getShapeCount();
    public ArrayList<Shape> getShapesByArea();
    public ArrayList<Shape> getShapesByLocation();
    public char[][]getCanvas();
}