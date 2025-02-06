import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        boolean conflict = hasBoundaryConflict(newShape);

        if (conflict) {
            shapes.add(newShape);
            drawShape(newShape);
        }
        return conflict;
    }

    private boolean hasBoundaryConflict(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location loc = shape.location;
        boolean allOutside = true;

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' ') {
                    if (loc.x + i < rows && loc.y + j < cols) {
                        return true;
                    }
                    allOutside = allOutside && (loc.x + i >= rows || loc.y + j >= cols);
                }
            }
        }
        return !allOutside;
    }

    private void drawShape(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        Location loc = shape.location;

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (loc.x + i < rows && loc.y + j < cols) {
                    if (shapeGrids[i][j] != ' ') {
                        canvas[loc.x + i][loc.y + j] = shapeGrids[i][j];
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