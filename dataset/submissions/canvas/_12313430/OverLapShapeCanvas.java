import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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

        if (Allow(shape,canvas,x,y)) {

            shapes.add(shape);
            return true;
        }
        return false;
    }

    private boolean Allow(Shape shape, char[][] canvas, int x, int y) {
        boolean add =false;
        boolean conflict = false;
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int canvasX =x+i;
                int canvasY =y+j;
                if (canvasX < 0 || canvasX > canvas.length-1 || canvasY < 0 || canvasY > canvas[0].length-1) {


                }else {
                    if (grids[i][j] != ' ' ) {
                        add = true;
                    }

                }

            }
        }
        if (add){
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    int canvasX =x+i;
                    int canvasY =y+j;
                    if (canvasX < 0 || canvasX > canvas.length-1 || canvasY < 0 || canvasY > canvas[0].length-1||grids[i][j] == ' ') {


                    }else {
                        canvas[canvasX][canvasY] = grids[i][j];

                    }

                }
            }
            return true;
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
