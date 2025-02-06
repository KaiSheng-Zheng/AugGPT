import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);

    public int getSpaceGridCount();//return an int value, which indicates how many space value in canvas

    public int getShapeCount();//return an int value, which indicates how many shapes have been added to canvas successfully

    public List<Shape> getShapesByArea();

    public List<Shape> getShapesByLocation();

    public char[][] getCanvas();


}
