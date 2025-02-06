import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);/*
    int... params is an array of integers*/
    public int getSpaceGridCount();
    public int getShapeCount();
    public List<Shape> getShapesByArea();
    public List<Shape> getShapesByLocation();/*these two require comparable sorting, and the principle of sorting
    needs to be defined*/
    public char[][] getCanvas();

}
