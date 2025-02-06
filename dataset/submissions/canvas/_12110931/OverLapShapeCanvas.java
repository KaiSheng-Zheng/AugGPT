import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;

    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
        Shape shape;
        char[][] chs;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);

        } else {
            Direction d;
            if (params[2] == 0) d = Direction.LEFT_UP;
            else if (params[2] == 1) d = Direction.LEFT_DOWN;
            else if (params[2] == 2) d = Direction.RIGHT_UP;
            else d = Direction.RIGHT_DOWN;
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
        }
        chs = shape.grids;
        int cnt = 0;
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                try {
                    if (chs[i][j] != ' ' && canvas[x + i][y + j] != 0) cnt++;
                } catch (Exception e) {
                    continue;
                }
            }
        }
        if (cnt == 0) return false;
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                try {
                    if (chs[i][j] != ' ' && canvas[x + i][y + j] != 0) {
                        canvas[x + i][y + j] = pattern;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        shapes.add(shape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int cnt = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') cnt++;
            }
        }
        return cnt;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape> comparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() != o2.area()) {
                    return o1.area() - o2.area();
                } else {
                    return o1.pattern - o2.pattern;
                }
            }
        };
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX() != o2.location.getX()) {
                    return o1.location.getX() - o2.location.getX();
                } else if (o1.location.getY() != o2.location.getY()) {
                    return o1.location.getY() - o2.location.getY();
                } else {
                    return o1.pattern - o2.pattern;
                }
            }
        };
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}