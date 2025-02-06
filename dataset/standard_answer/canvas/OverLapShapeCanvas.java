import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        Shape newShape = null;
        if (params.length == 1){
            newShape = new Circle(new Location(x, y), pattern, params[0]);
            if(params[0]>canvas[0].length&&params[0]>canvas.length){return false;}
        }else if (params.length == 3){
            Direction direction = Direction.values()[params[2]];
            newShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
            if(params[0]>canvas[0].length&&params[1]>canvas.length){
                return false;
            }
        }
        if (newShape != null && canPlaceIn(newShape, x, y)) {
            shapes.add(newShape);
            placeOnCanvas(newShape, x, y);
            boolean a = false;
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if(canvas[i][j] == pattern){
                         a = true;
                    }
                }
            }if (!a){shapes.remove(newShape);}
            return a;
        }
        return false;
    }
    private void placeOnCanvas(Shape shape, int x, int y) {
        char[][] shapeGrids = shape.getGrids();
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                int canvasX = x + i;
                int canvasY = y + j;
                if (canvasX >= 0 &&  canvasY >= 0 && canvasX < canvas.length && canvasY < canvas[canvasX].length) {
                    if (shapeGrids[i][j] != ' ') {
                        canvas[canvasX][canvasY] = shapeGrids[i][j];
                    }
                }
            }
        }
    }
    private boolean canPlaceIn(Shape shape, int x, int y) {
        char[][] shapeGrids = shape.getGrids();
        boolean a = false;
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                int canvasX = x + i;
                int canvasY = y + j;
                if (shapeGrids[i][i] != ' '){a = true;}
                if (canvasX >= 0 && canvasY >= 0 && canvasX < canvas.length && canvasY < canvas[canvasX].length){
                    return true;
                }
            }
        }
        return a;
    }
    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char a : row) {
                if (a == ' ') {
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
        return shapes.stream().sorted(Comparator.comparingInt(Shape::area)
                        .thenComparing(Shape::getPattern))
                .collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShapesByLocation() {
        return shapes.stream()
                .sorted(Comparator.comparingInt((Shape s) -> s.getLocation().getX())
                        .thenComparingInt((Shape s) -> s.getLocation().getY())
                        .thenComparing(Shape::getPattern))
                .collect(Collectors.toList());
    }

    @Override
    public char[][] getCanvas() {
        int rows = canvas.length;
        int cols = canvas[0].length;
        char[][] canvasCopy = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(canvas[i], 0, canvasCopy[i], 0, cols);
        }
        return canvasCopy;
    }
}