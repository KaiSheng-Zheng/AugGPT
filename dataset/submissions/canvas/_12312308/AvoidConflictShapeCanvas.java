import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int radius) {
        Shape c = new Circle(new Location(x, y), pattern, radius);
        if ((x < 0) || (x + 2 * radius > canvas.length) || (y < 0) || (y + 2 * radius) > (canvas[0].length)) {
            return false;
        }
        c.fillGrids();
        char[][] grids = c.getGrids();
        for (int i = x; i < x + 2 * radius; i++) {
            for (int j = y; j < y + 2 * radius; j++) {
                if (canvas[i][j] != ' ' && grids[i - x][j - y] != ' ') {
                    return false;
                }
            }
        }
        for (int i = x; i < x + 2 * radius; i++) {
            for (int j = y; j < y + 2 * radius; j++) {
                if (canvas[i][j] == ' ') {
                    canvas[i][j] = grids[i - x][j - y];
                }
            }
        }
        c.setArea(c.area());
        shapes.add(c);
        return true;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int d) {
        Direction direction;
        if (d == 0) {
            direction = Direction.LEFT_UP;
        } else if (d == 1) {
            direction = Direction.LEFT_DOWN;
        } else if (d == 2) {
            direction = Direction.RIGHT_UP;
        } else if (d == 3) {
            direction = Direction.RIGHT_DOWN;
        } else {
            return false;
        }
        if ((x < 0) || (y < 0) || (x + height > canvas.length) || (y + width) > (canvas[0].length)) {
            return false;
        }
        Shape r = new RightTriangle(new Location(x, y), pattern, width, height, direction);
        r.fillGrids();
        char[][] grids = r.getGrids();
        for (int i = x; i < x + height; i++) {
            for (int j = y; j < y + width; j++) {
                if (canvas[i][j] != ' ' && grids[i - x][j - y] != ' ') {
                    return false;
                }
            }
        }
        for (int i = x; i < x + height; i++) {
            for (int j = y; j < y + width; j++) {
                if (canvas[i][j] == ' ') {
                    this.canvas[i][j] = grids[i - x][j - y];
                }
            }
        }
        r.setArea(r.area());
        shapes.add(r);
        return true;
    }

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

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() == s2.area()) {
                    return Character.compare(s1.getPattern(), s2.getPattern());
                }
                return Double.compare(s1.area(), s2.area());
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.getX() == s2.getX()) {
                    if (s1.getY() == s2.getY()) {
                        return Character.compare(s1.getPattern(), s2.getPattern());
                    }
                    return Integer.compare(s1.getY(), s2.getY());
                }
                return Integer.compare(s1.getX(), s2.getX());
            }
        });
        return shapes;
    }
}
