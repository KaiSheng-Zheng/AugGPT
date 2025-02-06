import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        init();
    }

    private void init() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape s = null;
        if (params.length == 1) {

            s = new Circle(new Location(x, y), pattern, params[0]);
        } else {

            s = new RightTriangle(new Location(x, y), pattern, params[0], params[1], judgeDirection(params[2]));
        }

        if (x > canvas.length) {
            return false;
        }
        if (y > canvas[0].length) {
            return false;
        }

        for (int i = 0; i < s.grids.length; i++) {
            for (int j = 0; j < s.getGrids()[0].length; j++) {
                int canvas_i = i + x;
                int canvas_j = j + y;
                if (s.grids[i][j] == ' ') {
                    continue;
                }

                if (canvas_i >= 0 && canvas_i < canvas.length) {

                    if (canvas_j >= 0 && canvas_j < canvas[0].length) {

                        shapes.add(s);
                        fillInCanvas(s);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void fillInCanvas(Shape s) {
        for (int i = 0; i < s.grids.length; i++) {
            for (int j = 0; j < s.getGrids()[0].length; j++) {
                if (s.grids[i][j] == ' ') {
                    continue;
                }
                int canvas_i = i + s.location.getX();
                int canvas_j = j + s.location.getY();
                if (canvas_i >= 0 && canvas_i < canvas.length) {
                    if (canvas_j >= 0 && canvas_j < canvas[0].length) {
                        canvas[canvas_i][canvas_j] = s.grids[i][j];
                    }
                }
            }
        }
    }

    private Direction judgeDirection(int value) {
        switch (value) {
            case 0:
                return Direction.LEFT_UP;
            case 1:
                return Direction.LEFT_DOWN;
            case 2:
                return Direction.RIGHT_UP;
            case 3:
                return Direction.RIGHT_DOWN;
            default:
                return null;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int totalGrid = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    totalGrid++;
                }
            }
        }
        return totalGrid;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() < o2.area()) {
                    return -1;
                } else if (o1.area() > o2.area()) {
                    return 1;
                } else {
                    return o1.pattern - o2.pattern;
                }
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX() != o2.location.getX()) {
                    return o1.location.getX() - o2.location.getX();
                }
                if (o1.location.getY() != o2.location.getY()) {
                    return o1.location.getY() - o2.location.getY();
                }
                return o1.pattern - o2.pattern;
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {

        return canvas;
    }
}
