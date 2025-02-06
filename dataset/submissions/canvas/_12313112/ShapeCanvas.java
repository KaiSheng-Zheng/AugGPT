import java.util.List;

public interface ShapeCanvas {
    public abstract boolean addShape(int x, int y, char pattern, int... params);

    public abstract int getSpaceGridCount();

    public abstract int getShapeCount();

    public abstract List<Shape> getShapesByArea();

    public abstract List<Shape> getShapesByLocation();

    public abstract char[][] getCanvas();


}