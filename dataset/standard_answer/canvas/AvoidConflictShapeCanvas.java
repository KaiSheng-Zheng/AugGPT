import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape = null;
        if (params.length == 1){
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        }else if (params.length == 3){
            Direction direction = Direction.values()[params[2]];
            newShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
        }
        if (newShape != null && canPlaceIn(newShape, x, y)) {
            shapes.add(newShape);
            placeOnCanvas(newShape, x, y);
            return true;
        }
        return false;
    }
    private boolean canPlaceIn(Shape shape, int x, int y) {
        char[][] shapeGrids = shape.getGrids();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                int canvasX = x + i;
                int canvasY = y + j;
                if (canvasX < 0 || canvasY < 0 || canvasX >= canvas.length || canvasY >= canvas[canvasX].length ||
                        (shapeGrids[i][j] != ' ' && canvas[canvasX][canvasY] != ' ')) {
                    return false;
                }
            }
        }
        return true;
    }
    private void placeOnCanvas(Shape shape, int x, int y) {
        char[][] shapeGrids = shape.getGrids();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                int canvasX = x + i;
                int canvasY = y + j;
                if (canvasX >= 0 && canvasY >= 0 && canvasX < canvas.length && canvasY < canvas[canvasX].length) {
                    if (shapeGrids[i][j] != ' ' && canvas[canvasX][canvasY] == ' ') {
                        canvas[x + i][y + j] = shapeGrids[i][j];
                    }
                }
            }
        }
    }
    @Override
    public int getSpaceGridCount() {
            int count = 0;
            for (char[] row : canvas) {
                for (char a : row) {
                    if (a == ' ') {
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
        return shapes.stream().sorted(Comparator.comparingInt(Shape::area)
                                .thenComparing(Shape::getPattern))
                                .collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShapesByLocation() {
        return shapes.stream()
                .sorted(Comparator.comparingInt((Shape s) -> s.getLocation().getX())
                        .thenComparingInt((Shape s) -> s.getLocation().getY())
                        .thenComparing(Shape::getPattern))
                        .collect(Collectors.toList());
    }

    @Override
    public char[][] getCanvas() {
        int rows = canvas.length;
        int cols = canvas[0].length;
        char[][] canvasCopy = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvasCopy[i][j] = canvas[i][j];
            }
        }
        return canvasCopy;
    }
}

