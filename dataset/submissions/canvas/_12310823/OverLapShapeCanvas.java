

import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
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

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location loc = new Location(x, y);

        if (params.length == 1) {
            if ((loc.getY() >= canvas[0].length && loc.getX() >= canvas.length) || (loc.getY() + 2 * params[0] < 0 && loc.getX() + 2 * params[0] < 0)){
                return false;
            }
            Shape shape = new Circle(loc, pattern, params[0]);
            if (!isOverLap(shape)) return false;
            fillGrids(shape);
            shapes.add(shape);
            return true;
        } else if (params.length == 3) {
            if ((loc.getY() >= canvas[0].length && loc.getX() >= canvas.length) || (loc.getY() + params[1] < 0 && loc.getX() + params[0] < 0)){
                return false;
            }
            Direction[] dirs = {Direction.LEFT_UP, Direction.LEFT_DOWN, Direction.RIGHT_UP, Direction.RIGHT_DOWN};
            Shape shape = new RightTriangle(loc, pattern, params[0], params[1], dirs[params[2]]);

            if (!isOverLap(shape)) return false;
            fillGrids(shape);
            shapes.add(shape);
            return true;
        } else {
            return false;
        }
    }

    private boolean isOverLap(Shape shape) {
        for (int i = 0; shape.location.getX() + i < canvas.length && shape.location.getX() + i >= 0 && i < shape.getGrids().length; i++) {
            for (int j = 0; shape.location.getY() + j < canvas[0].length && shape.location.getY() + j >= 0 && j < shape.getGrids()[0].length; j++) {
                if (shape.getGrids()[i][j] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private void fillGrids(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = 0; shape.location.getX() + i < canvas.length && shape.location.getX() + i >= 0 && i < shape.getGrids().length; i++) {
            for (int j = 0; shape.location.getY() + j < canvas[0].length && shape.location.getY() + j >= 0 && j < shape.getGrids()[0].length; j++) {
                if (grids[i][j] != ' '){
                    canvas[shape.location.getX() + i][shape.location.getY() + j] = grids[i][j];
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
