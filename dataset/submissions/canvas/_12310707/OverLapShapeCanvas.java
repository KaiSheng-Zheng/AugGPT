import java.util.ArrayList;
import java.util.List;


public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = createShape(x, y, pattern, params);
        if (shape != null && hasNonSpaceGridInBound(shape)) {
            drawShape(shape);
            shapes.add(shape);
            return true;
        }
        return false;
    }

    private Shape createShape(int x, int y, char pattern, int[] params) {
        if (params.length == 1) {
            return new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            return new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        }
        return null;
    }

    private boolean hasNonSpaceGridInBound(Shape shape) {
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[i].length; j++) {
                if (shape.getGrids()[i][j] != ' ' &&
                        isWithinBound(shape.getLocation().getX() + i, shape.getLocation().getY() + j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWithinBound(int canvasX, int canvasY) {
        return canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length;
    }

    private void drawShape(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int canvasX = shape.getLocation().getX() + i;
                int canvasY = shape.getLocation().getY() + j;
                if (isWithinBound(canvasX, canvasY)) {
                    if (grids[i][j] != ' ') {
                        canvas[canvasX][canvasY] = grids[i][j];
                    }
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char c : row) {
                if (c == ' ') count++;
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
        for (int i = 0; i < sortedShapes.size(); i++) {
            for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
                if (sortedShapes.get(j).area() > sortedShapes.get(j + 1).area()) {
                    Shape temp = sortedShapes.get(j);
                    sortedShapes.set(j, sortedShapes.get(j + 1));
                    sortedShapes.set(j + 1, temp);
                }
            }
        }
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        for (int i = 0; i < sortedShapes.size(); i++) {
            for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
                Location loc1 = sortedShapes.get(j).getLocation();
                Location loc2 = sortedShapes.get(j + 1).getLocation();
                if (loc1.getX() > loc2.getX() || (loc1.getX() == loc2.getX() && loc1.getY() > loc2.getY())) {
                    Shape temp = sortedShapes.get(j);
                    sortedShapes.set(j, sortedShapes.get(j + 1));
                    sortedShapes.set(j + 1, temp);
                }
            }
        }
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    }