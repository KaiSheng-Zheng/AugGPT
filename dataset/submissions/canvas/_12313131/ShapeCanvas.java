import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);

    public int getSpaceGridCount();  //how many shapes being added into canvas successfully

    public int getShapeCount();// how many shapes being added successfully

    public List<Shape> getShapesByArea();// ascending order of the area of shapes, if  a same area , sorted by the ascending order of its character value of pattern

    public List<Shape> getShapesByLocation();//ascending order of the x value in location,then y, then character pattern

    public char[][] getCanvas();//painted canvas,' '

}
//