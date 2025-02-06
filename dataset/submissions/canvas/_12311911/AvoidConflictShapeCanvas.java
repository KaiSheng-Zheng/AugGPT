import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (char[] row : this.canvas) {
            for (int i = 0; i < row.length; i++) {
                row[i] = ' ';
            }
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

        if (x < 0 || y < 0 || x + newShape.getGrids().length > canvas.length || y + newShape.getGrids()[0].length > canvas[0].length) {
            return false;
        }

        for (int i = 0; i < newShape.getGrids().length; i++) {
            for (int j = 0; j < newShape.getGrids()[0].length; j++) {
                if (canvas[x + i][y + j] != ' ') {
                    return false;
                }
            }
        }

        for (int i = 0; i < newShape.getGrids().length; i++) {
            for (int j = 0; j < newShape.getGrids()[0].length; j++) {
                canvas[x + i][y + j] = newShape.getGrids()[i][j];
            }
        }

        shapes.add(newShape);
        return true;
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
        Collections.sort(sortedShapes, (s1, s2) -> {
            if (s1.area() != s2.area()) {
                return s1.area() - s2.area();
            } else {
                return s1.pattern - s2.pattern;
            }
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, (s1, s2) -> {
            if (s1.location.getX() != s2.location.getX()) {
                return s1.location.getX() - s2.location.getX();
            } else if (s1.location.getY() != s2.location.getY()) {
                return s1.location.getY() - s2.location.getY();
            } else {
                return s1.pattern - s2.pattern;
            }
        });
        return sortedShapes;
    }

    public char[][] getCanvas() {
        return canvas;
    }
}