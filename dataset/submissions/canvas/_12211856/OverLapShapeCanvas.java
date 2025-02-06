import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = createShape(x, y, pattern, params);
        if (shape == null || isOutOfBounds(shape)) {
            return false;
        }
        shapes.add(shape);
        drawShape(shape);
        return true;
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
        Collections.sort(sortedShapes, Comparator.comparingInt(Shape::getArea).thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, Comparator.comparing(Shape::getLocation).thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private Shape createShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            return new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            return new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
        }
        return null;
    }

    private boolean isOutOfBounds(Shape shape) {
        char[][] shapeCanvas = shape.draw();
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeCanvas.length; i++) {
            for (int j = 0; j < shapeCanvas[i].length; j++) {
                if (shapeCanvas[i][j] != ' ') {
                    int canvasX = loc.getX() + i;
                    int canvasY = loc.getY() + j;
                    if (canvasX < 0 || canvasX >= canvas.length || canvasY < 0 || canvasY >= canvas[0].length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void drawShape(Shape shape) {
        char[][] shapeCanvas = shape.draw();
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeCanvas.length; i++) {
            for (int j = 0; j < shapeCanvas[i].length; j++) {
                if (shapeCanvas[i][j] != ' ') {
                    canvas[loc.getX() + i][loc.getY() + j] = shapeCanvas[i][j];
                }
            }
        }
    }
}
