import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
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

        if (x + s.getGrids().length > canvas.length) {
            return false;
        }
        if (y + s.getGrids()[0].length > canvas[0].length) {
            return false;
        }

        for (int i = 0; i < s.grids.length; i++) {
            for (int j = 0; j < s.getGrids()[0].length; j++) {
                int canvas_i = i + x;
                int canvas_j = j + y;
                if (s.getGrids()[i][j] != ' ' && canvas[canvas_i][canvas_j] != ' ') {
                    return false;
                }
            }
        }
        shapes.add(s);
        fillInCanvas(s);
        return true;
    }

    private void fillInCanvas(Shape s) {
        for (int i = 0; i < s.grids.length; i++) {
            for (int j = 0; j < s.getGrids()[0].length; j++) {
                int canvas_i = i + s.location.getX();
                int canvas_j = j + s.location.getY();
                if (s.getGrids()[i][j] != ' ') {
                    canvas[canvas_i][canvas_j] = s.getGrids()[i][j];
                }
            }
        }
    }

    private Direction judgeDirection(int value) {
        switch (value){
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
        int totalGrid = canvas.length * canvas[0].length;
        for (Shape s : shapes) {
            totalGrid = totalGrid - s.area();
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
