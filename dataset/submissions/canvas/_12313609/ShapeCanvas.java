import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ShapeCanvas {
    boolean addShape(int x, int y, char pattern, int... params);
    int getSpaceGridCount();
    int getShapeCount();
    List<Shape> getShapesByArea();
    List<Shape> getShapesByLocation();
    public char[][] getCanvas();

}

