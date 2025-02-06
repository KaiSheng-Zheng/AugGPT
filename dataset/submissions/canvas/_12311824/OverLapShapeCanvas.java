import java.util.*;
public class OverLapShapeCanvas implements ShapeCanvas {
    private final List<Shape> shapes;
    private final char[][] canvas;

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
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            return addShapeToCanvas(circle);
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            Direction direction = Direction.values()[params[2]];
            RightTriangle triangle = new RightTriangle(new Location(x, y), pattern, width, height, direction);
            return addShapeToCanvas(triangle);
        }
        return false;
    }

    private boolean addShapeToCanvas(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        boolean isWithinBounds = false;
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                int canvasX = loc.getX() + i;
                int canvasY = loc.getY() + j;
                if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[canvasX].length) {
                    if (shapeGrids[i][j] != ' ') {
                        canvas[canvasX][canvasY] = shapeGrids[i][j];
                        isWithinBounds = true;
                    }
                }
            }
        }
        if (isWithinBounds) {
            shapes.add(shape);
        }
        return isWithinBounds;
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
        Collections.sort(sortedShapes, new AvoidConflictShapeCanvas.ShapeAreaComparator());
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new AvoidConflictShapeCanvas.ShapeLocationComparator());
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
