import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        if (params.length == 1) {
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            newShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            throw new IllegalArgumentException("Invalid parameters for shape.");
        }

        if (canAddShape(newShape)) {
            shapes.add(newShape);
            drawShape(newShape);
            return true;
        }
        return false;
    }

    private boolean canAddShape(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location loc = shape.location;

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' ') {
                    int canvasX = loc.x + i;
                    int canvasY = loc.y + j;
                    if (canvasX >= rows || canvasY >= cols || canvasX < 0 || canvasY < 0 || canvas[canvasX][canvasY] != ' ') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void drawShape(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location loc = shape.location;

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' ') {
                    canvas[loc.x + i][loc.y + j] = shapeGrids[i][j];
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
        sortedShapes.sort(Comparator.comparingInt(Shape::area).thenComparing(s -> s.pattern));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparingInt((Shape s) -> s.location.x)
                .thenComparingInt(s -> s.location.y)
                .thenComparing(s -> s.pattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
