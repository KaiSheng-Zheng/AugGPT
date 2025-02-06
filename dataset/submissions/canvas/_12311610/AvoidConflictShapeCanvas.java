import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        initializeCanvas();
    }
    private void initializeCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if(params.length==1){
            if (x< 0 || y < 0 || x +2*params[0]> canvas.length || y +2*params[0]> canvas[0].length) {
                return false;
            }
        }
        if(params.length==3){
            if (x< 0 || y < 0 || x +params[1]> canvas.length || y+params[0] > canvas[0].length) {
                return false;
            }
        }

        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
            for (int i = x; i < x + params[0]*2 ; i++) {
                for (int j = y; j < y + params[0]*2; j++) {
                 if (canvas[i][j] != ' ' & shape.grids[i-x][j-y] != ' '){
                     return false;
                    }
                }
            }
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
            for (int i = x; i < x + params[1]; i++) {
                for (int j = y; j < y + params[0]; j++) {
                    if (canvas[i][j] != ' ' & shape.grids[i-x ][j-y] != ' '){
                        return false;
                    }
                }
            }

        } else {
            return false;
        }

        shapes.add(shape);
        drawShapeOnCanvas(shape);
        return true;
    }



    private void drawShapeOnCanvas(Shape shape) {
        char[][] grids = shape.getGrids();
        int startX = shape.getLocation().getX();
        int startY = shape.getLocation().getY();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ') {
                    int x = startX + i;
                    int y = startY + j;
                    if (x >= 0 && y >= 0 && x < canvas.length && y < canvas[0].length) {
                        canvas[x][y] = grids[i][j];
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
        char[][] canvasCopy = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < canvas.length; i++) {
           for(int j=0;j<canvas[0].length;j++){
               canvasCopy[i][j]=canvas[i][j];
           }
        }
        return canvasCopy;
    }
}
