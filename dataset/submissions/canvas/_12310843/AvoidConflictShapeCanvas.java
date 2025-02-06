import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape = null;
        if (params.length == 1) {
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            newShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
        }

        if (newShape != null && !isOutOfBounds(newShape) && !isOverlap(newShape)) {
            shapes.add(newShape);
            updateCanvas(newShape);
            return true;
        }
        return false;
    }

    private boolean isOutOfBounds(Shape shape) {
        char[][] grids = shape.getGrids();
        Location location = shape.getLocation();
        int x = location.getX();
        int y = location.getY();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int canvasRow = x + i;
                int canvasCol = y + j;
                if (canvasRow < 0 || canvasRow >= canvas.length || canvasCol < 0 || canvasCol >= canvas[0].length) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOverlap(Shape newShape) {
        char[][] grids = newShape.getGrids();
        Location location = newShape.getLocation();
        int x = location.getX();
        int y = location.getY();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int canvasRow = x + i;
                int canvasCol = y + j;
                if (grids[i][j] != ' ' && canvas[canvasRow][canvasCol] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private void updateCanvas(Shape newShape) {
        char[][] grids = newShape.getGrids();
        Location location = newShape.getLocation();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                int row = location.getX() + i;
                int col = location.getY() + j;

                if (row >= 0 && row < canvas.length && col >= 0 && col < canvas[0].length) {
                    if (grids[i][j] != ' ') {
                        canvas[row][col] = grids[i][j];
                    }
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
        sortedShapes.sort((shape1, shape2) -> shape1.compareToByArea(shape2));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Shape::compareToByLocation);
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}