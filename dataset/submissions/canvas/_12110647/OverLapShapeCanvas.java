import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas extends Shape implements ShapeCanvas{
    private List<Shape> shapes;
    //Design a attribute shapes, which is to store the successfully added shapes.

    private char[][] canvas;
    //Using a char[][] array to represent the canvas. The initial value of each grid in canvas is a space ' ' , which mean an empty grid.

    //You need implement all abstract methods in the interface ShapeCanvas

//Constructor()
    public OverLapShapeCanvas(int rows, int cols){
        super(new Location(rows, cols),' ');
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    //Design a constructor with two parameters, rows represents the height of canvas and cols represents the width of canvas. Those are also the rows and columns of the private field canvas.

    public boolean addShape(int x, int y, char pattern, int... params){//
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            return false;
        }

        boolean overlapsCanvas = overlapsCanvas(shape);
        if (overlapsCanvas) {
            shapes.add(shape);
            fillCanvasWithShape(shape);
        }
        return overlapsCanvas;
    }
    //
    private void fillCanvasWithShape(Shape shape) {
        char[][] shapeGrid = shape.getGrids();
        Location location = shape.getLocation();
        int canvasHeight = canvas.length;
        int canvasWidth = canvas[0].length;
        int shapeHeight = shapeGrid.length;
        int shapeWidth = shapeGrid[0].length;

        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[0].length; j++) {
                if (shapeGrid[i][j] != ' ') {
                    int canvasX = location.getX() + i;
                    int canvasY = location.getY() + j;
                    if (canvasX < canvas.length && canvasY < canvas[0].length) {
                        if(canvas[canvasX][canvasY] != ' ' && shapeGrid[i][j] == ' '){
                            canvas[canvasX][canvasY] = canvas[canvasX][canvasY];
                        }else{
                            canvas[canvasX][canvasY] = shapeGrid[i][j];
                        }
                    }
                }
            }
        }
    }
    private boolean overlapsCanvas(Shape shape) {
        char[][] shapeGrid = shape.getGrids();
        Location location = shape.getLocation();
        int canvasHeight = canvas.length;
        int canvasWidth = canvas[0].length;
        int shapeHeight = shapeGrid.length;
        int shapeWidth = shapeGrid[0].length;

        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                int canvasX = location.getX() + i;
                int canvasY = location.getY() + j;
                if (canvasX >= 0 && canvasX < canvasHeight && canvasY >= 0 && canvasY < canvasWidth) {
                    if (shapeGrid[i][j] != ' ') {
                        return true; 
                    }
                }
            }
        }
        return false; 
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
        sortedShapes.sort(Comparator.comparingInt(Shape::area).thenComparing(s -> s.pattern));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparingInt((Shape s) -> s.getLocation().getX())
                .thenComparingInt(s -> s.getLocation().getY())
                .thenComparing(s -> s.pattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    @Override
    public void fillGrids() {

    }

    @Override
    public void enlarge() {

    }

    @Override
    public void shrink() {

    }

    @Override
    public int area() {
        return 0;
    }
    //This method is to add a shape into canvas, and the parameter means:
}
