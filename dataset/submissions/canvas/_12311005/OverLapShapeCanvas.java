import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    int rows, cols;

    public OverLapShapeCanvas(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            int radius = params[0];
            if (x + 2 * radius <= 0 || x >= rows || y + 2 * radius <= 0 || y >= cols) {
                return false;
            }
            for (int i = x; i < x + radius; i++) {
                for (int j = y; j < y + radius; j++) {
                    int x0 = x + radius;
                    int y0 = y + radius;
                    int x1 = i + 1;
                    int y1 = j + 1;
                    int length = (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);
                    if (length < (radius * radius)) {
                        canvas[i][j] = pattern;
                        canvas[i][2 * y + radius * 2 - 1 - j] = pattern;
                        canvas[2 * x + radius * 2 - 1 - i][j] = pattern;
                        canvas[2 * x + radius * 2 - 1 - i][2 * y + radius * 2 - 1 - j] = pattern;
                    }
                }
            }
            shapes.add(circle);
            return true;
        }
        if (params.length == 3) {
            Direction d = null;
            switch (params[2]) {
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
                    break;
            }
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            rightTriangle.fillGrids();
            char[][] grids = rightTriangle.getGrids();
            boolean add = false;
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    if (grids[i][j] != ' ') {
                        if (i + x >= rows || j + y >= cols) {
                            continue;
                        } else {
                            this.canvas[i + x][j + y] = grids[i][j];
                            add = true;
                        }
                    }
                }
            }
            if (add == true) {
                shapes.add(rightTriangle);
            }
            return add;
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int x = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ') {
                    x++;
                }
            }
        }
        return x;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size() -1; i++) {
            for (int j = 0; j < shapes.size()-i-1; j++) {
                Shape shape1 = shapes.get(j);
                Shape shape2 = shapes.get(j + 1);
                comparator(shape1, shape2);
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        ArrayList<Shape> list = new ArrayList<>(this.shapes);
        list.sort(new getlocation());
        return list;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }

    public void comparator(Shape x1, Shape x2) {
        if (x1.area() > x2.area()) {
            int x11 = shapes.indexOf(x1);
            int x22 = shapes.indexOf(x2);
            shapes.remove(x1);
            shapes.add(x11, x2);
            shapes.remove(x2);
            shapes.add(x22, x1);

        }
        if (x2.area() == x1.area()) {
            int x = Character.compare(x1.pattern, x2.pattern);
            if (x > 0) {
                int x11 = shapes.indexOf(x1);
                int x22 = shapes.indexOf(x2);
                shapes.remove(x1);
                shapes.add(x11, x2);
                shapes.remove(x2);
                shapes.add(x22, x1);
            }
        }
    }
}