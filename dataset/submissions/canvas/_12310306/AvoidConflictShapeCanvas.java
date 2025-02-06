import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    int rows;
    int cols;
    private Location location;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        this.location = new Location(x, y);
        if (params.length == 1) {
            Circle c = new Circle(location, pattern, params[0]);
            if (checkShape(c)) {
                shapes.add(c);
                updatecanvas(c);
                return true;
            }
        } else {
            RightTriangle r = null;
            switch (params[2]) {
                case 0:
                    r = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_UP);
                    break;
                case 1:
                    r = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_DOWN);
                    break;
                case 2:
                    r = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_UP);
                    break;
                case 3:
                    r = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_DOWN);
                    break;
            }
            if (checkShape(r)) {
                shapes.add(r);
                updatecanvas(r);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ')
                    count++;
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
        Comparator<Shape> comparator = new AreaComparator();
        shapes.sort(comparator);
        return shapes;
    }

    private class AreaComparator implements Comparator<Shape> {

        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1.area() < o2.area()) {
                return -1;
            }
            if (o1.area() > o2.area()) {
                return 1;
            }
            if (o1.pattern > o2.pattern) {
                return 1;
            }
            return -1;
        }
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = new LocationComparator();
        shapes.sort(comparator);
        return shapes;
    }

    private class LocationComparator implements Comparator<Shape> {

        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1.location.getX() < o2.location.getX())
                return -1;
            if (o1.location.getX() > o2.location.getX())
                return 1;
            if (o1.location.getY() < o2.location.getY())
                return -1;
            if (o1.location.getY() > o2.location.getY())
                return 1;
            if (o1.pattern < o2.pattern)
                return -1;
            return 1;
        }
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    @Override
    public boolean checkShape(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = location.getX(); i < location.getX() + grids.length; i++) {
            for (int j = location.getY(); j < location.getY() + grids[0].length; j++) {
                if (grids[i - location.getX()][j - location.getY()] != ' ' && (i >= rows || j >= cols))
                    return false;
                if (i < rows && j < cols && canvas[i][j] != ' ' && grids[i - location.getX()][j - location.getY()] != ' ')
                    return false;
            }
        }

        return true;
    }

    public void updatecanvas(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = location.getX(); i < location.getX() + grids.length; i++) {
            for (int j = location.getY(); j < location.getY() + grids[0].length; j++) {
                if (i < rows && j < cols && grids[i - location.getX()][j - location.getY()] != ' ') {
                    canvas[i][j] = grids[i - location.getX()][j - location.getY()];
                }
            }
        }
    }
}
