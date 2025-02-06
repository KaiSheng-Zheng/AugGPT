import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        if (params.length == 1) {
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        } else {
            newShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        }
        if (isWithinBounds(newShape)) {
            shapes.add(newShape);
            fillCanvas(newShape);
            return true;
        }
        return false;
    }

    private boolean isWithinBounds(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                int canvasX = loc.getX() + i;
                int canvasY = loc.getY() + j;
                if (canvasX < 0 || canvasX >= canvas.length || canvasY < 0 || canvasY >= canvas[0].length) {
                    return false;  // Out of canvas bounds
                }
            }
        }
        return true;
    }

    private void fillCanvas(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location loc = shape.getLocation();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' ') {
                    canvas[loc.getX() + i][loc.getY() + j] = shapeGrids[i][j];
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char cell : row) {
                if (cell == ' ') count++;
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
        return shapes.stream()
                .sorted(Comparator.comparingInt(Shape::area)
                        .thenComparing(Shape::getPattern))
                .collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShapesByLocation() {
        return shapes.stream()
                .sorted(Comparator.comparing((Shape s) -> s.getLocation().getX())
                        .thenComparing(s -> s.getLocation().getY())
                        .thenComparing(Shape::getPattern))
                .collect(Collectors.toList());
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}