import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes = new ArrayList<Shape>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        int canvasWidth = canvas[0].length;
        int canvasHeight = canvas.length;

        if (params.length == 1) {
            int radius = params[0];
            Location l = new Location(x, y);
            newShape = new Circle(l, pattern, radius);

            if (x < 0 || x + radius * 2 > canvasHeight || y < 0 || y + radius * 2  > canvasWidth) {
                return false;
            }

            for (int i = y; i < y + radius * 2; i++) {
                for (int j = x; j < x + radius * 2; j++) {
                    if (canvas[j][i] != ' ' & newShape.grids[j - x][i - y] != ' ') {
                        return false;
                    }
                }
            }
        }
        else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction direction = Direction.values()[directionIndex];
            Location l = new Location(x, y);
            newShape = new RightTriangle(l, pattern, width, height, direction);

            if (x < 0 || x + height > canvasHeight || y < 0 || y + width > canvasWidth) {
                return false;
            }
            for (int i = y; i < y + width; i++) {
                for (int j = x; j < x + height; j++) {
                    if (canvas[j][i] != ' ' & newShape.grids[j-x][i-y] != ' ' ){
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        shapes.add(newShape);
        fillCanvas(newShape);
        return true;
    }

    private void fillCanvas(Shape shape) {
        for (int i = shape.location.getY(); i < shape.location.getY() + shape.grids[0].length; i++) {
            for (int j = shape.location.getX(); j < shape.location.getX() + shape.grids.length; j++) {
                if (shape.grids[j-shape.location.getX()][i-shape.location.getY()] != ' ') {
                    canvas[j][i] = shape.grids[j-shape.location.getX()][i-shape.location.getY()];
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas){
            for (char c : row){
                if (c == ' '){
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
        sortedShapes.sort(Comparator.comparingInt(Shape::getArea)
                .thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparing(Shape::getLocation, Comparator.comparing(Location::getX))
                .thenComparing(Shape::getLocation, Comparator.comparing(Location::getY))
                .thenComparingDouble(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        char [][] canvasCopy = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvasCopy[i][j] = canvas[i][j];
            }
        }
        return canvasCopy;
    }
}


