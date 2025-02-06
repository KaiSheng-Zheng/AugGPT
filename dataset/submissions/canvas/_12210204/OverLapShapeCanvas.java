import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            return false;
        }
        if (canPlaceShape(shape, x, y)) {
            placeShape(shape, x, y);
            shapes.add(shape);
            return true;
        }
        return false;
    }

    private boolean canPlaceShape(Shape shape, int x, int y) {
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ' && (x + i >= canvas.length || y + j >= canvas[0].length)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeShape(Shape shape, int x, int y) {
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ' && canvas[x + i][y + j] == ' ') {
                    canvas[x + i][y + j] = grids[i][j];
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
        Collections.sort(sortedShapes);
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparing((Shape s) -> s.getLocation().getX())
                .thenComparing(s -> s.getLocation().getY())
                .thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
