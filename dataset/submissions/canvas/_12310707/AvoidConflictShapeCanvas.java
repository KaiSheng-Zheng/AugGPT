import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private final List<Shape> shapes;
    private final char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    private Shape createShape(int x, int y, char pattern, int[] params) {
        if (params.length == 1) {
            return new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            return new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        }
        return null;
    }
    private boolean isOutOfBound(Shape shape) {
        int height = canvas.length;
        int width = canvas[0].length;
        Location location = shape.getLocation();
        int shapeHeight = shape.getGrids().length;
        int shapeWidth = shape.getGrids()[0].length;
        return location.getX() + shapeHeight > height || location.getY() + shapeWidth > width;
    }

    private boolean hasOverlapConflict(Shape shape) {
        Location location = shape.getLocation();
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ' && canvas[location.getX() + i][location.getY() + j] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = createShape(x, y, pattern, params);
        if (shape != null && !isOutOfBound(shape)&&!hasOverlapConflict(shape)) {
            drawShape(shape);
            shapes.add(shape);
            return true;
        }
        return false;
    }
    private void drawShape(Shape shape) {
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[i].length; j++) {
                if (shape.getGrids()[i][j] != ' ') {
                    canvas[shape.getLocation().getX() + i][shape.getLocation().getY() + j] = shape.getGrids()[i][j];
                }
            }
        }
    }


    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char c : row) {
                if (c == ' ')
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
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        for (int i = 0; i < sortedShapes.size(); i++) {
            for (int j = i + 1; j < sortedShapes.size(); j++) {
                if (sortedShapes.get(i).area() > sortedShapes.get(j).area()) {
                    Shape temp = sortedShapes.get(i);
                    sortedShapes.set(i, sortedShapes.get(j));
                    sortedShapes.set(j, temp);
                } else if (sortedShapes.get(i).area() == sortedShapes.get(j).area()
                        && sortedShapes.get(i).getPattern() > sortedShapes.get(j).getPattern()) {
                    Shape temp = sortedShapes.get(i);
                    sortedShapes.set(i, sortedShapes.get(j));
                    sortedShapes.set(j, temp);
                }
            }
        }
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        for (int i = 0; i < sortedShapes.size(); i++) {
            for (int j = i + 1; j < sortedShapes.size(); j++) {
                int compareX = sortedShapes.get(i).getLocation().getX() - sortedShapes.get(j).getLocation().getX();
                if (compareX > 0 || (compareX == 0 &&
                        sortedShapes.get(i).getLocation().getY() - sortedShapes.get(j).getLocation().getY() > 0)) {
                    Shape temp = sortedShapes.get(i);
                    sortedShapes.set(i, sortedShapes.get(j));
                    sortedShapes.set(j, temp);
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
