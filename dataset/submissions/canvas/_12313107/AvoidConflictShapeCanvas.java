import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;

    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<Shape>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            //test for out of bounds
            if (x < 0 || y < 0) {
                return false;
            }
            if (x + params[0] > canvas.length) {
                return false;
            }
            if (y + params[0] > canvas[0].length) {
                return false;
            }
            //test for overlap
            char[][] recentCanvas = getCanvas();
            Shape thisShape = new Circle(new Location(x, y), pattern, params[0]);
            thisShape.fillGrids();
            for (int i = 0; i < thisShape.getGrids().length; i++) {
                for (int j = 0; j < thisShape.getGrids()[0].length; j++) {
                    if (recentCanvas[x + i][y + j] != ' ' && thisShape.getGrids()[i][j] != ' ') {
                        return false;
                    }
                }
            }
            shapes.add(thisShape);
            return true;

        } else {
            //test for out of bounds
            if (x < 0 || y < 0) {
                return false;
            }
            if (y + params[0] > canvas[0].length) {
                return false;
            }
            if (x + params[1] > canvas.length) {
                return false;
            }
            Direction d;
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            } else {
                d = Direction.RIGHT_DOWN;
            }
            //test for overlap
            char[][] recentCanvas = getCanvas();
            Shape thisShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            thisShape.fillGrids();
            for (int i = 0; i < thisShape.getGrids().length; i++) {
                for (int j = 0; j < thisShape.getGrids()[0].length; j++) {
                    if (recentCanvas[x + i][y + j] != ' ' && thisShape.getGrids()[i][j] != ' ') {
                        return false;
                    }
                }
            }
            shapes.add(thisShape);
            return true;
        }

    }

    @Override
    public int getSpaceGridCount() {
        int cnt = 0;
        for (char[] canva : canvas) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canva[j] == ' ') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {

        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() > o2.area()) {
                    return 1;
                } else if (o1.area() < o2.area()) {
                    return -1;
                } else {
                    if (o1.pattern > o2.pattern) {
                        return 1;
                    } else if (o1.pattern < o2.pattern) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).fillGrids();
            char[][] grid_0 = shapes.get(i).getGrids();
            for (int j = 0; j < grid_0.length; j++) {
                for (int k = 0; k < grid_0[0].length; k++) {
                    if (grid_0[j][k] == ' ') {
                        continue;
                    }
                    canvas[shapes.get(i).location.getX() + j][shapes.get(i).location.getY() + k] = grid_0[j][k];
                }
            }
        }

        return canvas;




    }

}
