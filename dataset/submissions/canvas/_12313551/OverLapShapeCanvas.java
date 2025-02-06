import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{

    private int rows;
    private int cols;
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;


    public OverLapShapeCanvas(int rows, int cols) {
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
    Location location= new Location(x, y);
        if (params.length == 3) {
            RightTriangle triangle = new RightTriangle(location, pattern, params[0], params[1], params[2]);
            if (x + params[0] <= rows & y + params[0] <= cols){
                shapes.add(triangle);
                return true;
            }
            if (x + params[0] > rows | y + params[0] > cols) {
                for (int i = 0; i < triangle.getGrids().length; i++) {
                    for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                        if (triangle.location.getX() + i <= canvas.length-1
                                & triangle.location.getY() + j <= canvas[0].length-1) {
                            if (triangle.getGrids()[i][j] != ' ') {
                                shapes.add(triangle);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        else if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            if (x + 2*params[0] <= rows & y + 2*params[0] <= cols) {
                shapes.add(circle);
                return true;
            }
            if (x + 2*params[0] > rows | y + 2*params[0] > cols){
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids()[0].length; j++) {
                        if (circle.location.getX() + i <= canvas.length-1
                                & circle.location.getY() + j <= canvas[0].length-1) {
                            if (circle.getGrids()[i][j] != ' ') {
                                shapes.add(circle);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]==' '){
                    count++;
                }
            }
        }
        return count;
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

    @Override
    public char[][] getCanvas() {
        for (Shape s : shapes) {
            for (int i = 0; i < s.getGrids().length; i++) {
                for (int j = 0; j < s.getGrids()[0].length; j++) {
                    if (s.location.getX() + i <= canvas.length-1
                            & s.location.getY() + j <= canvas[0].length-1&s.getGrids()[i][j] != ' ') {
                        canvas[s.location.getX() + i][s.location.getY() + j] = s.getGrids()[i][j];
                    }
                }
            }
        }
        return canvas;
    }
    class Area implements Comparator<Shape> {
        public int compare(Shape s1,Shape s2){
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