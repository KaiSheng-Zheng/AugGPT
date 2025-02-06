import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = null;
        
        if (params.length == 1) {
            Location location = new Location(x, y);
            shape = new Circle(location, pattern, params[0]);
        } else if (params.length == 3) {
            Location location = new Location(x, y);
            if (params[2] == 0) {
                shape = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_UP);
            } else if (params[2] == 1) {
                shape = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_DOWN);
            } else if (params[2] == 2) {
                shape = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_UP);
            } else if (params[2] == 3) {
                shape = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_DOWN);
            }
        }
        if (!Conflict(shape,canvas,x,y)) {
            shapes.add(shape);
            return true;
        }
        return false;
    }

    private boolean Conflict(Shape shape, char[][] canvas, int x, int y) {
        char[][] grids = shape.getGrids();
        if (x + grids.length > canvas.length || y + grids[0].length > canvas[0].length||x<0||y<0) {
            return true;
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ' && canvas[x + i][y + j] != ' ') {
                    return true;
                }
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ') {
                    canvas[x + i][y + j] = grids[i][j];
                }
            }
        }
        return false;
    }






    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
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
        shapes.sort((a, b) -> {
            int aCompare = Integer.compare(a.area(), b.area());
            if (aCompare == 0) {
                return Character.compare(a.pattern, b.pattern);
            }
            return aCompare;
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((a, b) -> {
            int xCompare = Integer.compare(a.location.getX(), b.location.getX());
            if (xCompare == 0) {
                int yC= Integer.compare(a.location.getY(), b.location.getY());
                if (yC == 0) {
                    return Character.compare(a.pattern, b.pattern);
                }
                return yC;
            }
            return xCompare;
        });
        return shapes;
 
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
