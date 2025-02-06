import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
            int count = 0;

            if (y + radius*2  < 0 || y >= canvasWidth  || x + radius*2  < 0 || x >= canvasHeight) {
                return false;
            }
            for (int i = y; i < Math.min(y + radius * 2,canvasWidth); i++) {
                for (int j = x; j < Math.min(x + radius * 2,canvasHeight); j++) {
                    if ( canvas[j][i] != ' ' & newShape.grids[j - x][i - y] != ' ') {
                        canvas[j][i] = newShape.grids[j - x][i - y];
                        count++;
                    }
                }
            }
            for (int i = y; i < Math.min(y + radius * 2,canvasWidth); i++) {
                for (int j = x; j < Math.min(x + radius * 2,canvasHeight); j++) {
                    if ( canvas[j][i] == ' ' & newShape.grids[j - x][i - y] != ' ') {
                        canvas[j][i] = newShape.grids[j - x][i - y];
                        count++;
                    }
                }
            }
            if (count > 0) {
                shapes.add(newShape);
            } else return false;
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction direction = Direction.values()[directionIndex];
            Location l = new Location(x, y);
            newShape = new RightTriangle(l, pattern, width, height, direction);
            int count = 0;

            if (x + height < 0 || x >= canvasWidth || y + width  < 0 || y >= canvasHeight) {
                return false;
            }
            for (int i = y; i < Math.min(y + width,canvasWidth); i++) {
                for (int j = x; j < Math.min(x + height,canvasHeight); j++) {
                    if ( canvas[j][i] != ' ' & newShape.grids[j-x][i-y] != ' ' ){
                        canvas[j][i] = newShape.grids[j - x][i - y];
                        count++;
                    }
                }
            }
            for (int i = y; i < Math.min(y + width,canvasWidth); i++) {
                for (int j = x; j < Math.min(x + height,canvasHeight); j++) {
                    if ( canvas[j][i] == ' ' & newShape.grids[j-x][i-y] != ' ' ){
                        canvas[j][i] = newShape.grids[j - x][i - y];
                        count++;
                    }
                }
            }
            if (count>0){
                shapes.add(newShape);
            } else return false;
        }else{
        return false;
    }
        return true;
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
