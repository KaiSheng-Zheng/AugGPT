import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private final int rows;
    private final int cols;
    private final List<Shape> shapes;
    private final char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        initializeCanvas();
    }

    private void initializeCanvas() {
        for (char[] row : canvas) {
            for (int j = 0; j < row.length; j++) {
                row[j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        int size = params.length;
        if (size == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (size == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            return false;
        }

        if (isOutOfBounds(shape)) {
            return false;
        }

        if (hasOverlap(shape)) {

            return false;
        }

        shapes.add(shape);
        drawShapeOnCanvas(shape);
        return true;

    }


    private boolean isOutOfBounds(Shape shape) {
        Location location = shape.location;
        return location.getX() < 0 || location.getY() < 0 || location.getX() + shape.getGrids().length > rows || location.getY() + shape.getGrids()[0].length > cols;
    }

    private boolean hasOverlap(Shape shape) {
        char[][] grids = shape.getGrids();
        int x = shape.location.getX();
        int y = shape.location.getY();
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                if (canvas[i + x][j + y] != ' ' && grids[i][j] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private void drawShapeOnCanvas(Shape shape) {
        Location location = shape.location;
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    canvas[location.getX() + i][location.getY() + j] = grids[i][j];
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char grid : row) {
                if (grid == ' ') {
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
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((s1, s2) -> {
            if (s1.area() != s2.area()) {
                return s1.area() - s2.area();
            } else {
                return s1.pattern - s2.pattern;
            }
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((s1, s2) -> {
            if (s1.location.getX() != s2.location.getX()) {
                return s1.location.getX() - s2.location.getX();
            } else if (s1.location.getY() != s2.location.getY()) {
                return s1.location.getY() - s2.location.getY();
            } else {
                return s1.pattern - s2.pattern;
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}
