
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int a, int b) {
        shapes = new ArrayList<>();
        canvas = new char[a][b];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        int counter = 0;
        if (x > canvas.length - 1 | y > canvas[0].length)
            return false;
        if (params.length == 1) {
            Circle c = new Circle(location, pattern, params[0]);
            char[][] cGrids = c.getGrids();
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (i - x >= 0 && i - x <= cGrids.length - 1 && j - y >= 0 && j - y <= cGrids[0].length-1 && cGrids[i - x][j - y] != ' ') {
                        canvas[i][j] = cGrids[i - x][j - y];
                        counter++;
                    }
                }
            }
            if (counter == 0)
                return false;

            shapes.add(c);
            return true;
        }
        if (params.length == 3) {
            RightTriangle r = new RightTriangle(location, pattern, params[0], params[1], getDirection(params[2]));
            char[][] cGrids = r.getGrids();
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (i - x >= 0 && i - x <= cGrids.length - 1 && j - y >= 0 && j - y <= cGrids[0].length-1 && cGrids[i - x][j - y] != ' ') {
                        canvas[i][j] = cGrids[i - x][j - y];
                        counter++;
                    }
                }
            }
            if (counter == 0)
                return false;
            shapes.add(r);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int counter = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ')
                    counter++;
            }
        }
        return counter;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> resortedShapes = new ArrayList<>(shapes);
        Collections.sort(resortedShapes);
        return resortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> resortedShapes = new ArrayList<>(shapes);
        resortedShapes.sort(new Circle(null, ' ', 0));
        return resortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public Direction getDirection(int param) {
        if (param == 0)
            return Direction.LEFT_UP;
        if (param == 1)
            return Direction.LEFT_DOWN;
        if (param == 2)
            return Direction.RIGHT_UP;
        else
            return Direction.RIGHT_DOWN;
    }

}
