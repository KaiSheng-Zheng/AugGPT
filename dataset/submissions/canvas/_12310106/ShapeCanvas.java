/*
Although I cannot write Chinese comment in the file,
I can still express my love for Podenco and Warma in English!

Location.java

Direction.java

Shape.java

Circle.java

RightTriangle.java

ShapeCanvas.java

AvoidConflictShapeCanvas.java

OverLapShapeCanvas.java
 */
import java.util.List;

public interface ShapeCanvas {
    boolean addShape(int x, int y, char pattern, int... params);

    int getSpaceGridCount();

    
    

    int getShapeCount();

    
    

    List<Shape> getShapesByArea();

    /*
     * This method is to return a List, which contains all shapes in canvas, and sort the shape as:
     *      Ascending order of the area of shapes.
     *      If shapes with a same area, sorted by the ascending order of its character value of pattern.
     */

    List<Shape> getShapesByLocation();

    /*
     * This method is to return a List, which contains all shapes in canvas, and sort the shape as:
     *      Ascending order of the x value in location.
     *      If shapes with a same value of x, sorted by the ascending order of its y value in location.
     *      If shapes with a same location, sorted by the ascending order of its character value of pattern.
     */

    char[][] getCanvas();

    
    
}

enum ShapeType {
    RIGHTTRIANGLE, CIRCLE
}

