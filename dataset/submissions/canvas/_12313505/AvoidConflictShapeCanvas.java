import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private int rows, cols;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        char[][] test = new char[rows + 10][cols + 10];
        Location location = new Location(x, y);
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                test[i][j] = canvas[i - 1][j - 1];
            }
        }
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            for (int i = 0; i < rows + 2; i++) {
                for (int j = 0; j < cols + 2; j++) {
                    if ( test[i][j] != ' '&& circle.CircleTest(i, j,new Location(x + 1, y + 1))) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (circle.CircleTest(i, j, location)) canvas[i][j] = pattern;
                }
            }
            return shapes.add(circle);
        }
        if (params.length == 3) {
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
            for (int i = 0; i < rows + 2; i++) {
                for (int j = 0; j < cols + 2; j++) {
                    if (test[i][j] != ' '&& rightTriangle.RTTest(i, j, new Location(x + 1, y + 1))) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rightTriangle.RTTest(i, j, location)) canvas[i][j] = pattern;
                }
            }
            return shapes.add(rightTriangle);
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ') count++;
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((a, b) -> {
            int areaCompare = Integer.compare(a.getArea(), b.getArea());
            return areaCompare != 0 ? areaCompare : Character.compare(a.getPattern(), b.getPattern());
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((a, b) -> {
            int xCompare = Integer.compare(a.getLocation().getX(), b.getLocation().getX());
            if (xCompare != 0) return xCompare;
            int yCompare = Integer.compare(a.getLocation().getY(), b.getLocation().getY());
            return yCompare != 0 ? yCompare : Character.compare(a.getPattern(), b.getPattern());
        });
        return sortedShapes;
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
