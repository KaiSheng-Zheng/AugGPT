import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);

    public int getSpaceGridCount();

    public int getShapeCount();

    public List<Shape> getShapesByArea();
//This method is to return a List, which contains all shapes in canvas, and sort the shape as :
//Ascending order of the area of shapes.
//If shapes with a same area, sorted by the ascending order of its character value of pattern
    public List<Shape> getShapesByLocation();
//Implement the method in its implement classes.
//This method is to return a List, which contains all shapes in canvas, and sort the shape as :
//Ascending order of the x value in location.
//If shapes with a same value of x, sorted by the ascending order of its y value in location.
//If shapes with a same location, sorted by the ascending order of its character value of
//p
    public char[][] getCanvas();


}
