
import java.util.List;
public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int params);
    public boolean addShape(int x, int y, char pattern, int param1,int param2,int param3);
    public int getSpaceGridCount();
    public int getShapeCount();
    public List<Shape> getShapesByArea();
    public List<Shape> getShapesByLocation();
    public char[][] getCanvas();
}
