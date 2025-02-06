import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public OverLapShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = createShape(x, y, pattern, params);
        if (shape != null && canPlaceShape(shape)) {
            placeShape(shape);
            shapes.add(shape);
            return true;
        }
        return false;
    }

    private Shape createShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1) {
            return new Circle(location, pattern, params[0]);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            return new RightTriangle(location, pattern, params[0], params[1], direction);
        }
        return null;
    }

    private boolean canPlaceShape(Shape shape) {
        char[][] shapeGrid = shape.getGrids();
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[i].length; j++) {
                int canvasX = loc.getX() + i;
                int canvasY = loc.getY() + j;
                if (canvasX < 0 || canvasX >= rows || canvasY < 0 || canvasY >= cols) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeShape(Shape shape) {
        char[][] shapeGrid = shape.getGrids();
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[i].length; j++) {
                if (shapeGrid[i][j] != ' ') {
                    canvas[loc.getX() + i][loc.getY() + j] = shapeGrid[i][j];
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char cell : row) {
                if (cell == ' ') {
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
        sortedShapes.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparingInt((Shape s) -> s.getLocation().getX())
                .thenComparingInt(s -> s.getLocation().getY())
                .thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
