import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            if (x + 2 * params[0] > canvas.length || y + 2 * params[0] > canvas[0].length || x < 0 || y < 0) {
                return false;
            }
            Location l1 = new Location(x,y);
            Circle c = new Circle(l1,pattern,params[0]);
            c.fillGrids();
            for (int i = 0; i < 2 * params[0]; i++) {
                for (int j = 0; j < 2 * params[0]; j++) {
                    if (canvas[i + x][j + y] != ' ' && c.grids[i][j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < 2 * params[0]; i++) {
                for (int j = 0; j < 2 * params[0]; j++) {
                    if (c.grids[i][j] != ' ') {
                        canvas[i + x][j + y] = c.pattern;
                    }
                }
            }
            shapes.add(c);
            return true;
        }
        if (params.length == 3) {
            if (x + params[1] > canvas.length || y + params[0] > canvas[0].length || x < 0 || y < 0) {
                return false;
            }
            Location l2 = new Location(x,y);
            Direction d = Direction.LEFT_UP;
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            }
            if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            }
            if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            }
            if (params[2] == 3) {
                d = Direction.RIGHT_DOWN;
            }
            RightTriangle r = new RightTriangle(l2,pattern,params[0],params[1],d);
            r.fillGrids();
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (canvas[i + x][j + y] != ' ' && r.grids[i][j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (r.grids[i][j] != ' ') {
                        canvas[i + x][j + y] = r.pattern;
                    }
                }
            }
            shapes.add(r);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    sum = sum + 1;
                }
            }
        }
        return sum;
    }
    public int getShapeCount() {
        return shapes.size();
    }
    public List<Shape> getShapesByArea() {
        List<Shape> list;
        list = shapes;
        if (!list.isEmpty()) {
            list.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::ASC));
        }
        return list;
    }
    public List<Shape> getShapesByLocation() {
        List<Shape> list;
        list = shapes;
        if (!list.isEmpty()) {
            list.sort(Comparator.comparing(Shape::getLocationX).thenComparing(Shape::getLocationY).thenComparing(Shape::ASC));
        }
        return list;
    }
    public char[][] getCanvas() {
        return canvas;
    }
}
