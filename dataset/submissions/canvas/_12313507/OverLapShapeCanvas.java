import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private int rows, cols;

    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
        Location location = new Location(x, y);
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            boolean inCanvas = false;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (circle.isInCircle(i, j, location)) {
                        canvas[i][j] = pattern;
                        inCanvas = true;
                    }
                }
            }
            if (!inCanvas) return false;
            return shapes.add(circle);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], direction);
            boolean inCanvas = false;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rightTriangle.isInRT(i, j, location)) {
                        canvas[i][j] = pattern;
                        inCanvas = true;
                    }
                }
            }
            if (!inCanvas) return false;
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
