import java.util.List;

public interface ShapeCanvas {

    public boolean addShape(int x, int y, char pattern, int... params);
    //Implement the method in its implement classes.

    public int getSpaceGridCount();
    //Implement the method in its implement classes.

    //This method is to return an int value, which represents how many space value in canvas.

    public int getShapeCount();
    //Implement the method in its implement classes.

    //This method is to return an int value, which represents how many shapes being added into canvas successfully.

    public List<Shape> getShapesByArea();
    //Implement the method in its implement classes.

    //This method is to return a List, which contains all shapes in canvas, and sort the shape as :

    //Ascending order of the area of shapes.
    //If shapes with a same area, sorted by the ascending order of its character value of pattern.
    //Shapes with a same area and same pattern cannot appear in any test case in this assignment.

    public List<Shape> getShapesByLocation();
    //Implement the method in its implement classes.

    //This method is to return a List, which contains all shapes in canvas, and sort the shape as :

    //Ascending order of the x value in location.
    //If shapes with a same value of x, sorted by the ascending order of its y value in location.
    //If shapes with a same location, sorted by the ascending order of its character value of pattern.
    //Shapes with a same location and same pattern cannot appear in any test case in this assignment.

    public char[][] getCanvas();
    //Implement the method in its implement classes.

    //This method is to return a char[][] array, which represents a painted canvas. If a cell should be painted, it will be the pattern. If a cell haven' t been paint, it will be a space like
    //        ' '
}
