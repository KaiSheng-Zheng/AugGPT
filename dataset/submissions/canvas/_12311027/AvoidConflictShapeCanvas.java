import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();

    private char[][] canvas;
    public  int [][] count;
    int rows;
    int cols;
    public AvoidConflictShapeCanvas( int rows, int cols){
        this.rows=rows;
        this.cols=cols;
        canvas=new char[rows][cols];
        count= new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count[i][j] = 0;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location p1 = new Location(x, y);
        if (params.length == 1) {
            int radius = params[0];
            Circle circle = new Circle(p1, pattern, radius);
            char[][] tem = circle.getGrids();
            boolean ifConflict = false;
            if (x + 2 * radius > canvas.length || y + 2 * radius > canvas[0].length) {
                return false;
            } else {
                for (int i = x; i < x + 2 * radius; i++) {
                    for (int j = y; j < y + 2 * radius; j++) {
                        if (tem[i - x][j - y] == pattern && canvas[i][j] != ' ') {
                            ifConflict = true;
                        }
                    }
                }
                if (ifConflict) {
                    return false;
                } else {
                    shapes.add(circle);
                    for (int i = x; i < x + 2 * radius; i++) {
                        for (int j = y; j < y + 2 * radius; j++) {
                            if (tem[i - x][j - y] != ' ') {
                                canvas[i][j] = tem[i - x][j - y];
                            }
                        }
                    }
                    return true;
                }
            }
        } else {
            if (x + params[1] > canvas.length || y + params[0] > canvas[0].length) {
                return false;
            } else {
                Direction d = null;
                boolean ifConflict = false;
                switch (params[2]) {
                    case 0 -> {
                        d = Direction.LEFT_UP;
                    }
                    case 1 -> {
                        d = Direction.LEFT_DOWN;
                    }
                    case 2 -> {
                        d = Direction.RIGHT_UP;
                    }
                    case 3 -> {
                        d = Direction.RIGHT_DOWN;
                    }
                }
                RightTriangle rightTriangle = new RightTriangle(p1, pattern, params[0], params[1], d);
                char[][] tem = rightTriangle.getGrids();

                for (int i = x; i < x + params[1]; i++) {
                    for (int j = y; j < y + params[0]; j++) {
                        if (tem[i - x][j - y] == pattern && canvas[i][j] != ' ') {
                            ifConflict = true;
                        }
                    }
                }
                if (ifConflict) {
                    return false;
                } else {
                    for (int i = x; i < x + params[1]; i++) {
                        for (int j = y; j < y + params[0]; j++) {
                            if (tem[i-x][j-y]!=' ') {
                                canvas[i][j] = tem[i - x][j - y];
                            }
                            }
                    }
                    shapes.add(rightTriangle);
                    return true;
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(canvas[i][j] != ' '){
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
        Comparator<Shape> comparator = Comparator.comparingInt(Shape::getArea).thenComparingInt(Shape::getPattern);
        shapes.sort(comparator);
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = Comparator.comparingInt((Shape shape) -> shape.getLocation().getX()).thenComparingInt((Shape shape) -> shape.getLocation().getY()).thenComparingInt(Shape::getPattern);
        shapes.sort(comparator);
        return shapes;
    }
    @Override
    public char[][] getCanvas() {
        return  canvas;
    }
}