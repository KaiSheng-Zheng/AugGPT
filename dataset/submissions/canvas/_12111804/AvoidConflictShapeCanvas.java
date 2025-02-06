import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++){
                canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length == 1) {
            int radius = params[0];
            if(x + 2*radius >= canvas.length + 1) {
                return false;
            }
            if(y + 2*radius >= canvas[0].length + 1) {
                return false;
            }
            Shape circle = new Circle(new Location(x, y), pattern, radius);
            for(int i=0;i<2*radius;i++){
                for (int j=0;j<2*radius;j++){
                    if(circle.grids[i][j] != ' ' && canvas[x+i][y+j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i=0;i<2*radius;i++){
                for(int j=0;j<2*radius;j++){
                    if(circle.grids[i][j] != ' ') {
                        canvas[x+i][y+j] = circle.grids[i][j];
                    }
                }
            }
            shapes.add(circle);
            return true;
        }
        else {
            int width = params[0];
            int height = params[1];
            Direction d = Direction.values()[params[2]];
            if(x + height >= canvas.length + 1) {
                return false;
            }
            if(y + width >= canvas[0].length + 1) {
                return false;
            }
            RightTriangle triangle = new RightTriangle(new Location(x, y), pattern, width, height, d);
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if(triangle.grids[i][j] != ' ' && canvas[x+i][y+j] != ' ') {
                        return false;
                    }
                }
            }
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if(triangle.grids[i][j] != ' ') {
                        canvas[x+i][y+j] = triangle.grids[i][j];
                    }
                }
            }
            shapes.add(triangle);
            return true;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for(char[] line: canvas){
            for(char c: line){
                if(c == ' ') {
                    count ++;
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
    public char[][] getCanvas() {
        return canvas;
    }

    @Override
    public List<Shape> getShapesByArea() {
        OrderByArea order = new OrderByArea();
        shapes.sort(order);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        OrderByLocation order = new OrderByLocation();
        shapes.sort(order);
        return shapes;
    }
}

class OrderByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.area() > o2.area()) {
            return 1;
        }
        if(o1.area() < o2.area()) {
            return -1;
        }
        else {
            if(o1.pattern > o2.pattern) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}

class OrderByLocation implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.location.getX() > o2.location.getX()) {
            return 1;
        }
        if(o1.location.getX() < o2.location.getX()) {
            return -1;
        }
        else {
            if(o1.location.getY() > o2.location.getY()) {
                return 1;
            }
            if(o1.location.getY() < o2.location.getY()) {
                return -1;
            }
            else {
                if(o1.pattern > o2.pattern) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        }
    }
}
