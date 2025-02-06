import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    private int rows, cols;
    private int sum = 0;

    public OverLapShapeCanvas(int rows, int cols) {
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
            if (x > rows || y > cols) {
                return false;
            }
            int x1 = Math.min(rows, x + 2 * r);
            int y1 = Math.min(cols, y + 2 * r);
            boolean s = true;
            outer:
            for (int i = x; i < x1; i++) {
                for (int j = y; j < y1; j++) {
                    s = a.getGrids()[i - x][j - y] == ' ';
                    if (!s) {
                        break outer;
                    }
                }
                if (i == x1 - 1) {
                    return false;
                }
            }
            for (int i = x; i < x1; i++) {
                for (int j = y; j < y1; j++) {
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
            int x1 = Math.min(rows, x + h);
            int y1 = Math.min(cols, y + w);
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
            if (x > rows || y > cols) {
                return false;
            }
            boolean s = true;
            outer:
            for (int i = x; i < x1; i++) {
                for (int j = y; j < y1; j++) {
                    s = a.getGrids()[i - x][j - y] == ' ';
                    if (!s) {
                        break outer;
                    }
                }
                if (i == x1 - 1) {
                    return false;
                }
            }
            for (int i = x; i < x1; i++) {
                for (int j = y; j < y1; j++) {
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
