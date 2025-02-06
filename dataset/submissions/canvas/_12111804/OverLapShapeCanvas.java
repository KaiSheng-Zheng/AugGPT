import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
            Shape circle = new Circle(new Location(x, y), pattern, radius);
            if(!check(circle, 2*radius, 2*radius, x, y)) {
                return false;
            }
            for(int i=0;i<2*radius && x+i< canvas.length;i++) {
                for(int j=0;j<2*radius && y+j<canvas[0].length;j++) {
                    if(circle.grids[i][j] != ' '){
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
            RightTriangle triangle = new RightTriangle(new Location(x, y), pattern, width, height, d);
            if (!check(triangle, width, height, x, y)) {
                return false;
            }
            for (int i = 0; i < height && x + i < canvas.length; i++) {
                for (int j = 0; j < width && y + j < canvas[0].length; j++) {
                    if (triangle.grids[i][j] != ' ') {
                        canvas[x + i][y + j] = triangle.grids[i][j];
                    }
                }
            }
            shapes.add(triangle);
            return true;
        }
    }

    public boolean check(Shape shape, int width, int height, int x, int y) {
        for(int i=0;i<height && x+i< canvas.length;i++) {
            for(int j=0;j<width && y+j<canvas[0].length;j++) {
                if(shape.grids[i][j] != ' '){
                    return true;
                }
            }
        }
        return false;
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
