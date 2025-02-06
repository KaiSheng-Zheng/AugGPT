import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.Math;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Location l = new Location(x,y);
            Circle c = new Circle(l,pattern,params[0]);
            c.fillGrids();
            boolean b = false;
            if (x >= 0 && y >= 0) {
                char[][] chars1 =new char[x + 2 * params[0]][y + 2 * params[0]];
                for (int i = 0; i < chars1.length; i++) {
                    for (int j = 0; j < chars1[0].length; j++) {
                        chars1[i][j] = ' ';
                    }
                }
                for (int i = 0; i < c.grids.length; i++) {
                    for (int j = 0; j < c.grids[0].length; j++) {
                        if (c.grids[i][j] != ' ') {
                            chars1[i + x][j + y] = c.pattern;
                        }
                    }
                }
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (i < chars1.length && j < chars1[0].length && chars1[i][j] != ' ') {
                            b = true;
                            break;
                        }
                    }
                }
                if (b) {
                    for (int k = 0; k < Math.min(canvas.length,chars1.length); k++) {
                        for (int m = 0; m < Math.min(canvas[0].length,chars1[0].length); m++) {
                            if (chars1[k][m] != ' ') {
                                canvas[k][m] = c.pattern;
                            }
                        }
                    }
                    shapes.add(c);
                }
                return b;
            }
            return false;
        }
        if (params.length == 3) {
            Location l = new Location(x,y);
            Direction d = Direction.RIGHT_DOWN;
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
            RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],d);
            r.fillGrids();
            boolean b1 = false;
            if (x >= 0 && y >= 0) {
                char[][] chars = new char[x + params[1]][y + params[0]];
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < chars[0].length; j++) {
                        chars[i][j] = ' ';
                    }
                }
                for (int i = 0; i < r.grids.length; i++) {
                    for (int j = 0; j < r.grids[0].length; j++) {
                        if (r.grids[i][j] != ' ') {
                            chars[i + x][j + y] = r.pattern;
                        }
                    }
                }
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (i < chars.length && j < chars[0].length && chars[i][j] != ' ') {
                            b1 = true;
                            break;
                        }
                    }
                }
                if (b1) {
                    for (int k = 0; k < Math.min(canvas.length,chars.length); k++) {
                        for (int m = 0; m < Math.min(canvas[0].length,chars[0].length); m++) {
                            if (chars[k][m] != ' ') {
                                canvas[k][m] = r.pattern;
                            }
                        }
                    }
                    shapes.add(r);
                }
                return b1;
            }
            return false;
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
