import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        char[][] primeCanvas = new char[this.canvas.length][];
        for (int i = 0; i < this.canvas.length; i++) {
            primeCanvas[i] = Arrays.copyOf(this.canvas[i], this.canvas[i].length);
        }

        Location location = new Location(x, y);
        char[][] grids;
        Shape shape;

        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);
            grids = shape.getGrids();
        } else {
            shape = getShape(pattern, params, location);
            grids = shape.getGrids();
        }

        for (int i = x; i < grids.length + x; i++) {
            for (int j = y; j < grids[0].length + y; j++) {

                try {
                    if (grids[i - x][j - y] != ' ') {
                        if (this.canvas[i][j] != ' ') {
                            this.canvas = primeCanvas;
                            return false;
                        }else {
                            this.canvas[i][j] = grids[i - x][j - y];
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.canvas = primeCanvas;
                    return false;
                }
            }
        }
        this.shapes.add(shape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {

        int result = 0;

        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if (this.canvas[i][j] == 0) { // ' ' == 32, not 0
                    result++;
                }
            }
        }

        return result;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> arrangedShapes = new ArrayList<>(this.shapes);
        arrangedShapes.sort(new ShapeAreaComparator());

        return arrangedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> arrangedShapes = new ArrayList<>(this.shapes);
        arrangedShapes.sort(new ShapeLocationComparator());

        return arrangedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }

    private static Shape getShape(char pattern, int[] params, Location location) {
        Direction d = switch (params[2]) {
            case 0 -> Direction.LEFT_UP;
            case 1 -> Direction.LEFT_DOWN;
            case 2 -> Direction.RIGHT_UP;
            case 3 -> Direction.RIGHT_DOWN;
            default -> null;
        };
        return new RightTriangle(location, pattern, params[0], params[1], d);
    }
}