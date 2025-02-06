import java.util.ArrayList;
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
                this.canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            return false;
        }

        if (!canPlaceShape(shape)) {
            return false;
        }

        placeShape(shape);
        shapes.add(shape);
        return true;
    }

    private boolean canPlaceShape(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location location = shape.getLocation();
        int startX = location.getX();
        int startY = location.getY();

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' ') {
                    int canvasX = startX + i;
                    int canvasY = startY + j;
                    if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void placeShape(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location location = shape.getLocation();
        int startX = location.getX();
        int startY = location.getY();

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' ') {
                    int canvasX = startX + i;
                    int canvasY = startY + j;
                    if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length) {
                        canvas[canvasX][canvasY] = shapeGrids[i][j];
                    }
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
        sortedShapes.sort(Comparator.comparing((Shape shape) -> shape.getLocation().getX())
                .thenComparing(shape -> shape.getLocation().getY())
                .thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
