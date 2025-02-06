import java.lang.invoke.SwitchPoint;
import java.util.List;

interface ShapeCanvas {

    public boolean addShape(int x, int y, char pattern, int r);
    public boolean addShape(int x, int y, char pattern, int width,int height,int direction);
    public  int getSpaceGridCount();
    public  int getShapeCount();
    public List<Shape> getShapesByArea();
    public  List<Shape> getShapesByLocation();

    public  char[][] getCanvas();
}
