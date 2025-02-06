import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    private int rows, cols;
    private int sum = 0;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (shapes.size() == 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    canvas[i][j] = ' ';
                }
            }
        }
        if (params.length == 1) {
            Location loc = new Location(x, y);
            int r = params[0];
            Shape a = new Circle(loc, pattern, r);
            if (x + 2 * r > rows || y + 2 * r > cols) {
                return false;
            }
            for (int i = x; i < x + 2 * r; i++) {
                for (int j = y; j < y + 2 * r; j++) {
                    if (canvas[i][j] != ' ' && a.getGrids()[i - x][j - y] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = x; i < x + 2 * r; i++) {
                for (int j = y; j < y + 2 * r; j++) {
                    if (a.getGrids()[i - x][j - y] != ' ')
                        canvas[i][j] = a.getGrids()[i - x][j - y];
                }
            }
            shapes.add(a);
            sum += a.area();
            return true;

        }
        if (params.length == 3) {
            Location loc = new Location(x, y);
            int w = params[0];
            int h = params[1];
            int d0 = params[2];
            Direction d = null;
            switch (d0) {
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;

            }
            Shape a = new RightTriangle(loc, pattern, w, h, d);
            if (x + h > rows || y + w > cols) {
                return false;
            }
            for (int i = x; i < x + h; i++) {
                for (int j = y; j < y + w; j++) {
                    if (canvas[i][j] != ' ' && a.getGrids()[i - x][j - y] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = x; i < x + h; i++) {
                for (int j = y; j < y + w; j++) {
                    if (a.getGrids()[i - x][j - y] != ' ')
                        canvas[i][j] = a.getGrids()[i - x][j - y];
                }
            }
            shapes.add(a);
            sum += a.area();
            return true;

        }
        return true;

    }

    @Override
    public int getSpaceGridCount() {
        return sum;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> shapes1 = new ArrayList<Shape>();
        List<Shape> shapes2 = shapes;
        while (shapes2.size() > 0) {
            int a = 999999999, x = 0;
            for (int i = 0; i < shapes2.size(); i++) {
                if (shapes2.get(i).area() < a) {
                    a = shapes2.get(i).area();
                    x = i;
                }else if (shapes2.get(i).area() == a) {
                    if (shapes2.get(i).pattern<shapes2.get(x).pattern) {
                        a = shapes2.get(i).area();
                        x = i;
                    }
                }
            }
            shapes1.add(shapes2.get(x));
            shapes2.remove(x);
        }
        shapes = shapes1;
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> shapes1 = new ArrayList<Shape>();
        List<Shape> shapes2 = shapes;
        while (shapes2.size() > 0) {
            int m = rows + 1, x = 0;
            for (int i = 0; i < shapes2.size(); i++) {
                if (shapes2.get(i).location.getX() < m) {
                    m = shapes2.get(i).location.getX();
                    x = i;
                } else if (shapes2.get(i).location.getX() == m) {
                    if (shapes2.get(i).location.getY() < shapes2.get(x).location.getY()) {
                        x = i;
                    }else if (shapes2.get(i).location.getY() == m) {
                        if (shapes2.get(i).pattern<shapes2.get(x).pattern) {
                            m = shapes2.get(i).location.getX();
                            x = i;
                        }
                    }
                }
            }
            shapes1.add(shapes2.get(x));
            shapes2.remove(x);
        }
        shapes = shapes1;
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
