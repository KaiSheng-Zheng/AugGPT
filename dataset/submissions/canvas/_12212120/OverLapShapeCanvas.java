import java.util.*;
class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = null;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], params[2]);
        }
        if (shape != null) {
            shapes.add(shape);
            paintShape(shape);
            return true;
        }
        return false;
    }

    private void paintShape(Shape shape) {
        char[][] shapeGrids = shape.getGrids();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (shapeGrids[i][j] != ' '&&i + shape.location.y<canvas.length&&j + shape.location.x<canvas[i].length) {
                    canvas[i + shape.location.y][j + shape.location.x] = shapeGrids[i][j];
                }
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char cell : row) {
                if (cell == ' ') {
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
        Collections.sort(sortedShapes);
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparing(shape -> shape.location.x));
        sortedShapes.sort(Comparator.comparing(shape -> shape.location.y));
        sortedShapes.sort(Comparator.comparing(shape -> shape.pattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}