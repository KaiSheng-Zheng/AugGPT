import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    OverLapShapeCanvas overLapShapeCanvas;
    AvoidConflictShapeCanvas avoidConflictShapeCanvas;
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
        this.avoidConflictShapeCanvas = new AvoidConflictShapeCanvas(rows, cols); 
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        Location location = new Location(x, y);  
        if (params.length == 1) {
            newShape = new Circle(location, pattern, params[0]);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            newShape = new RightTriangle(location, pattern, params[0], params[1], direction);
        } else {
            return false;  
        }

        boolean hasOverlap = checkOverlap(newShape);
        boolean added = drawShape(newShape);  

        if (added || hasOverlap) {
            shapes.add(newShape);  
            return true;
        }

        return false;
    }

    private boolean isWithinBounds(Shape shape) {
        char[][] grids = shape.getGrids();
        Location loc = shape.location;
        int xStart = loc.getX();
        int yStart = loc.getY();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int x = xStart + i;
                int y = yStart + j;
                if (x < 0 || x >= canvas.length || y < 0 || y >= canvas[0].length) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkOverlap(Shape shape) {
        char[][] grids = shape.getGrids();
        Location loc = shape.location;
        int xStart = loc.getX();
        int yStart = loc.getY();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    int x = xStart + i;
                    int y = yStart + j;
                    if (x >= 0 && x < canvas.length && y >= 0 && y < canvas[0].length) {
                        if (canvas[x][y] != ' ') {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean drawShape(Shape shape) {
        char[][] grids = shape.getGrids();
        Location loc = shape.location;
        int xStart = loc.getX();
        int yStart = loc.getY();
        boolean hasAdded = false;  

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') { 
                    int x = xStart + i;
                    int y = yStart + j;
                    if (x >= 0 && x < canvas.length && y >= 0 && y < canvas[0].length) {
                        canvas[x][y] = grids[i][j]; 
                        hasAdded = true;  
                    }
                }
            }
        }

        return hasAdded;  
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char c : row) {
                if (c == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((shape1, shape2) -> {
            int areaComparison = Integer.compare(shape1.area(), shape2.area());
            if (areaComparison != 0) {
                return areaComparison;
            }
            
            return Integer.compare(shape1.pattern, shape2.pattern);
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((shape1, shape2) -> {
            
            if (shape1.getLocation().getX() != shape2.getLocation().getX()) {
                return Integer.compare(shape1.getLocation().getX(), shape2.getLocation().getX());
            } else {
                int xComparison = Integer.compare(shape1.getLocation().getY(), shape2.getLocation().getY());
                if (xComparison != 0) {
                    return xComparison;
                }
                
                return Integer.compare(shape1.pattern, shape2.pattern);
            }
        });
        return sortedShapes;
    }




    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
}
