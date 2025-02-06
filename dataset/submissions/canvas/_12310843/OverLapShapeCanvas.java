import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape = null;
        if (params.length == 1) {
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction direction;
            switch (directionIndex) {
                case 0:
                    direction = Direction.LEFT_UP;
                    break;
                case 1:
                    direction = Direction.LEFT_DOWN;
                    break;
                case 2:
                    direction = Direction.RIGHT_UP;
                    break;
                case 3:
                    direction = Direction.RIGHT_DOWN;
                    break;
                default:
                    direction = Direction.LEFT_UP;
            }
            newShape = new RightTriangle(new Location(x, y), pattern, width, height, direction);
        }
        if (newShape != null && !checkOverlap(newShape)) {
            shapes.add(newShape);
            updateCanvas(newShape);
            return true;
        }
        return false;
    }

    private boolean checkOverlap(Shape newShape) {
        char[][] grids = newShape.getGrids();
        Location location = newShape.getLocation();
        int rows = grids.length;
        int cols = grids[0].length;

        int counter=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int canvasRow = location.getX() + i;
                int canvasCol = location.getY() + j;
                if (grids[i][j] != ' ' && (canvasRow < 0 || canvasRow >= canvas.length || canvasCol < 0 || canvasCol >= canvas[0].length)) {
                    counter++;     
                }
            }
        }
        if (counter<newShape.getArea()){
            return false;
        }else {
            return true;
        }
    }


    private void updateCanvas(Shape newShape) {
        char[][] grids = newShape.getGrids();
        Location location = newShape.getLocation();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                int row = location.getX() + i;
                int col = location.getY() + j;

                if (row >= 0 && row < canvas.length && col >= 0 && col < canvas[0].length) {
                    if (grids[i][j] != ' ') {
                        canvas[row][col] = grids[i][j];
                    }
                }
            }
        }
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
        sortedShapes.sort((shape1, shape2) -> shape1.compareToByArea(shape2));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Shape::compareToByLocation);
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}