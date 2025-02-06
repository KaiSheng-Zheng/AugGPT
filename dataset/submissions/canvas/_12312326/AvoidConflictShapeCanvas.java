import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length == 3) {
            Location location = new Location(x, y);
            Shape rt = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
            rt.fillGrids();
            for (int i = 0; i < rt.getGrids().length; i++) {
                for (int j = 0; j < rt.getGrids()[0].length ; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length ||i+x<0||j+y<0) {

                            return false;


                    }
                    else{
                        if ((canvas[i + x][j + y] != ' ') && (rt.getGrids()[i][j] == pattern)) {
                            return false;
                        }
                    }


                }
            }
            for (int i = 0; i < rt.getGrids().length; i++) {
                for (int j = 0; j < rt.getGrids()[0].length ; j++) {
                    if( rt.getGrids()[i][j] != ' '){
                        canvas[i + x][j + y]= rt.getGrids()[i][j];
                    }
                }
            }
            shapes.add(rt);
            return true;
        }
        if(params.length == 1){
            Location location = new Location(x, y);
            Shape c = new Circle(location, pattern, params[0]);
            c.fillGrids();
            for (int i = 0; i < c.getGrids().length; i++) {
                for (int j = 0; j < c.getGrids()[0].length ; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length ||i+x<0||j+y<0) {
                        if (c.getGrids()[i][j] == pattern) {
                            return false;
                        }

                    }
                    else{
                        if ((canvas[i + x][j + y] != ' ') && (c.getGrids()[i][j] == pattern)) {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < c.getGrids().length; i++) {
                for (int j = 0; j < c.getGrids()[0].length ; j++) {
                    if( c.getGrids()[i][j] != ' '){
                        canvas[i + x][j + y]= c.getGrids()[i][j];
                    }
                }
            }
            shapes.add(c);
            return true;
        }
        else return false;
    }

//Implement the method in its implement classes.
//
//This method is to return an int value, which represents how many space value in canvas.
    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    //Implement the method in its implement classes.
    //
    //This method is to return an int value, which represents how many shapes being added into canvas successfully.
    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    /*
    This method is to return a List, which contains all shapes in canvas, and sort the shape as :

Ascending order of the area of shapes.
If shapes with a same area, sorted by the ascending order of its character value of pattern.
Shapes with a same area and same pattern cannot appear in any test case in this assignment.
     */
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator(){
            public int compare(Object o1, Object o2){
                Shape s1 = (Shape) o1;
                Shape s2 = (Shape) o2;
                if(s1.area() == s2.area()){
                    return s1.pattern - s2.pattern;
                }
                return s1.area() - s2.area();
            }
        });
        return shapes;


    }

/*
Implement the method in its implement classes.

This method is to return a List, which contains all shapes in canvas, and sort the shape as :

Ascending order of the x value in location.
If shapes with a same value of x, sorted by the ascending order of its y value in location.
If shapes with a same location, sorted by the ascending order of its character value of pattern.
Shapes with a same location and same pattern cannot appear in any test case in this assignment.
 */
    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator(){
            public int compare(Object o1, Object o2){
                Shape s1 = (Shape) o1;
                Shape s2 = (Shape) o2;
                if(s1.location.getX() == s2.location.getX()){
                    if(s1.location.getY() == s2.location.getY()){
                        return s1.pattern - s2.pattern;
                    }
                    return s1.location.getY() - s2.location.getY();
                }
                return s1.location.getX() - s2.location.getX();
            }
        });
        return shapes;
    }
//Implement the method in its implement classes.
//
//This method is to return a char[][] array, which represents a painted canvas. If a cell should be painted, it will be the pattern. If a cell haven' t been paint, it will be a space like
//
//' '
    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}
