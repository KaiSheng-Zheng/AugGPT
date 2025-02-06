import java.util.*;
public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
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
        Shape newShape;
        if (params.length == 1) {
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        } else {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction direction = Direction.values()[directionIndex];
            newShape = new RightTriangle(new Location(x, y), pattern, width, height, direction);
        }

        if (isShapeConflict(newShape)) {
            return false;
        }

        shapes.add(newShape);
        updateCanvas(newShape);
        return true;
    }

    private boolean isShapeConflict(Shape newShape) {
        int canvasRows = canvas.length;
        int canvasCols = canvas[0].length;
        for (int i = 0; i < newShape.getGrids().length; i++) {
            for (int j = 0; j < newShape.getGrids()[0].length; j++) {
                int canvasX = newShape.getLocation().getX() + i;
                int canvasY = newShape.getLocation().getY() + j;
                if (canvasX < 0 || canvasX >= canvasRows || canvasY < 0 || canvasY >= canvasCols ||
                        (canvas[canvasX][canvasY] != ' ' && newShape.getGrids()[i][j] != ' ')) {
                    return true;
                }
            }
        }
        return false;
    }

    private void updateCanvas(Shape newShape) {
        for (int i = 0; i < newShape.getGrids().length; i++) {
            for (int j = 0; j < newShape.getGrids()[0].length; j++) {
                int canvasX = newShape.getLocation().getX() + i;
                int canvasY = newShape.getLocation().getY() + j;
                if (canvas[canvasX][canvasY] == ' ' && newShape.getGrids()[i][j] != ' ') {
                    canvas[canvasX][canvasY] = newShape.getGrids()[i][j];
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
        Collections.sort(sortedShapes, new ShapeAreaComparator());
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new ShapeLocationComparator());
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


    public static class ShapeAreaComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            if (s1.area() == s2.area()) {
                return Character.compare(s1.getPattern(), s2.getPattern());
            }
            return Integer.compare(s1.area(), s2.area());
        }
    }

    public static class ShapeLocationComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            if (s1.getLocation().getX() == s2.getLocation().getX()) {
                if (s1.getLocation().getY() == s2.getLocation().getY()) {
                    return Character.compare(s1.getPattern(), s2.getPattern());
                }
                return Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
            }
            return Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
        }
    }
}
