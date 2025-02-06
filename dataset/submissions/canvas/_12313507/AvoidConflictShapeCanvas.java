import java.util.ArrayList;
import java.util.Collections;
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
        char[][] test = new char[rows + 2][cols + 2];
        Location location = new Location(x, y);
        Location testLocation = new Location(x + 1, y + 1);
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                test[i][j] = canvas[i - 1][j - 1];
            }
        }
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            for (int i = 0; i < rows + 2; i++) {
                for (int j = 0; j < cols + 2; j++) {
                    if (test[i][j] != ' '&& circle.isInCircle(i, j, testLocation)) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (circle.isInCircle(i, j, location)) canvas[i][j] = pattern;
                }
            }
            return shapes.add(circle);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], direction);
            for (int i = 0; i < rows + 2; i++) {
                for (int j = 0; j < cols + 2; j++) {
                    if (test[i][j] != ' '&& rightTriangle.isInRT(i, j, testLocation)) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rightTriangle.isInRT(i, j, location)) canvas[i][j] = pattern;
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

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new LocationComparator());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
