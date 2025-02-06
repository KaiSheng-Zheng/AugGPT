import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.rows = rows;
        this.cols = cols;
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if (params.length == 1) {//Circle
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else {//Triangle
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1],
                    Direction.fromInteger(params[2]));
        }
        if (isConflict(x, y, shape.getGrids(), canvas) == false) {
            shapes.add(shape);
            for (int a = 0; a < shape.getGrids().length; a++) {
                for (int b = 0; b < shape.getGrids()[0].length; b++) {
                    if( shape.getGrids()[a][b]!=' '){
                        canvas[a+x][b+y]=shape.getGrids()[a][b];
                    };
                }
            }
            return true;
        }
        return false;
    }

    private boolean isConflict(int x, int y, char[][] grid, char[][] canv) {
        if (isWithinBoundary(x, y, grid)) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != ' ' && canv[i + x][j + y] != ' ') return true;
                }
            }
        }else{
            return true;
        }
        return false;
    }

    private boolean isWithinBoundary(int x, int y, char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != ' ') {
                    if (i + x < 0 || i + x >= rows || j + y < 0 || j + y >= cols) return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparingInt(Shape::area)
                .thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparing((Shape shape) -> shape.getLocation().getX())
                .thenComparing(shape -> shape.getLocation().getY())
                .thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    public char[][] getCanvas() {
        return this.canvas;
    }
}
