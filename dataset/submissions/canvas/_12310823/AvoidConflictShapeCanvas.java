
import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;

    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location loc = new Location(x, y);

        if (params.length == 1) {

            Shape shape = new Circle(loc, pattern, params[0]);
            if (isOverlap(shape)) {
                return false;
            }
            fillGrids(shape);
            shapes.add(shape);
            return true;
        } else if (params.length == 3) {

            Direction[] dirs = {Direction.LEFT_UP, Direction.LEFT_DOWN, Direction.RIGHT_UP, Direction.RIGHT_DOWN};
            Shape shape = new RightTriangle(loc, pattern, params[0], params[1], dirs[params[2]]);
            if (isOverlap(shape)) {
                return false;
            }
            fillGrids(shape);
            shapes.add(shape);
            return true;
        } else {
            return false;
        }
    }

    private boolean isOverlap(Shape shape) {
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                if (shape.getGrids()[i][j] != ' ' && (shape.location.getX() + i >= canvas.length || shape.location.getY() + j >= canvas[0].length || shape.location.getX() + i < 0 || shape.location.getY() + j < 0)){
                    return true;
                }
                if (shape.getGrids()[i][j] != ' ' && canvas[shape.location.getX() + i][shape.location.getY() + j] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private void fillGrids(Shape shape) {
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                if (shape.getGrids()[i][j] != ' ') {
                    canvas[shape.location.getX() + i][shape.location.getY() + j] = shape.getGrids()[i][j];
                }
            }
        }
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
        shapes.sort((o1, o2) -> {
            if (o1.area() == o2.area()) {
                return (int)o1.pattern - (int)o2.pattern;
            }
            return o1.area() - o2.area();
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((a, b) -> {
            if (b.location.getX() == a.location.getX()) {
                if (b.location.getY() == a.location.getY()) {
                    return (int)a.pattern - (int)b.pattern;
                }
                return a.location.getY() - b.location.getY();
            }
            return a.location.getX() - b.location.getX();
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}
