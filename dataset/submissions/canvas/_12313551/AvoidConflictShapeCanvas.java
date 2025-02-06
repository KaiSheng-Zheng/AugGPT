import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AvoidConflictShapeCanvas implements ShapeCanvas {


    private int rows;
    private int cols;
    private List<Shape> shapes = new ArrayList<>();
    public char[][] canvas;


    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 3) {
            RightTriangle triangle = new RightTriangle(location, pattern, params[0], params[1], params[2]);
            if (x + params[1] > rows | y + params[0] > cols ) {
                return false;
            }
            if (x + params[1] <= rows & y + params[0] <= cols ) {
                for (int i = 0; i < triangle.getGrids().length; i++) {
                    for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                        if (triangle.getGrids()[i][j] != ' '
                                &canvas[triangle.location.getX() + i][triangle.location.getY() + j]!= ' ') {
                            return false;
                        }
                    }
                }
            }
            shapes.add(triangle);
            for (int i = 0; i < triangle.getGrids().length; i++) {
                for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                    if (triangle.getGrids()[i][j] != ' ') {
                        canvas[triangle.getLocation().getX() + i][triangle.getLocation().getY() + j] = triangle.getGrids()[i][j];
                    }
                }
            }
        } else if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            if (x + 2*params[0] > rows | y + 2*params[0] > cols) {
                return false;
            }
            if (x + 2*params[0] <= rows & y + 2*params[0] <= cols){
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids()[0].length; j++) {
                        if (circle.getGrids()[i][j]!=' '
                                &canvas[circle.getLocation().getX() + i][circle.getLocation().getY() + j]!=' ') {
                           return false;
                        }
                    }
                }
            }
            shapes.add(circle);
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j] != ' ') {
                        canvas[circle.getLocation().getX() + i][circle.getLocation().getY() + j] = circle.getGrids()[i][j];
                    }
                }
            }
        }
        return true;
    }


    @Override
    public char[][] getCanvas() {
        return canvas;
    }


    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (Shape s:shapes){
            count=count+s.area();
        }
        return rows*cols-count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes,new Area());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes);
        return shapes;
    }

     class Area implements Comparator<Shape> {
         public int compare(Shape s1, Shape s2) {
             if (s2.area()>s1.area()){
                 return -1;
             }else if (s2.area()<s1.area()){
                 return 1;
             }else {
                 if (s1.getPattern() < s2.getPattern()) {
                     return -1;
                 } else if (s1.getPattern() > s2.getPattern()) {
                     return 1;
                 } else {
                     return 0;
                 }
             }
         }
     }
}