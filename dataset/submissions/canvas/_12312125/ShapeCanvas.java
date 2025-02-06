import java.util.Comparator;
import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);
    public int getSpaceGridCount();
    public int getShapeCount();
    public List<Shape> getShapesByArea();
    public List<Shape> getShapesByLocation();
    public char[][] getCanvas();

}
class SortByArea implements Comparator<Shape> {
    public int compare(Shape s1, Shape s2){
        if (s1.area() != s2.area())
            return s1.area() - s2.area();
        else return s1.pattern - s2.pattern;
    }
}
