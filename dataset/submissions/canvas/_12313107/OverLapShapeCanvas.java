import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {

    private char[][] canvas;

    List<Shape> shapes;

    OverLapShapeCanvas(int rows, int cols) {
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
        // should paint the canvas at the end of the method!
        // otherwise the user will get incorrect result when calling getSpaceGridCount().
        Shape thisShape = null;
        Direction d = null;
        boolean flag = true;
        if (params.length == 1) {
            thisShape = new Circle(new Location(x, y), pattern, params[0]);
            //test for out of bounds
            if (x < 0 || y < 0) {
                flag = false;
            }
            if (x + params[0] > canvas.length) {
                flag = false;
            }
            if (y + params[0] > canvas[0].length) {
                flag = false;
            }
            if (flag) {
                shapes.add(thisShape);
                return true;
            }
        } else {
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            } else {
                d = Direction.RIGHT_DOWN;
            }
            thisShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            //test for out of bounds
            if (x < 0 || y < 0) {
                flag = false;
            }
            if (y + params[0] > canvas[0].length) {
                flag = false;
            }
            if (x + params[1] > canvas.length) {
                flag = false;
            }

            if (flag) {
                shapes.add(thisShape);
                return true;
            }
        }

        if (!flag) {
            thisShape.fillGrids();
            char[][] grid_0 = thisShape.getGrids();


            int x_max = 500;
            int y_max = 500;
            char[][] newCanvas = new char[x_max][y_max];

            for (int i = 0; i < x_max; i++) {
                for (int j = 0; j < y_max; j++) {
//                    newCanvas[i][j] = '*';
                    newCanvas[i][j] = ' ';
                }
            }

            int location_x = 0;
            int location_y = 0;
            if (x > 0) {
                location_x = x;
            }
            if (y > 0) {
                location_y = y;
            }
            for (int i = 0; i < grid_0.length; i++) {
                for (int j = 0; j < grid_0[0].length; j++) {
                    newCanvas[location_x + i][location_y + j] = grid_0[i][j];
                }
            }

            boolean flag_2 = false;
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (newCanvas[i][j] != ' ') {
                        flag_2 = true;
                        break;
                    }
                }
            }

            if (flag_2) {
                shapes.add(thisShape);
                return true;
            } else {
                return false;
            }

        }

        return false;

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

            int x = shapes.get(i).location.getX();
            int y = shapes.get(i).location.getY();

            int o_x = x < 0 ? -x : 0;
            int o_y = y < 0 ? -x : 0;


            int x_max = 500;
            int y_max = 500;
            char[][] newCanvas = new char[x_max][y_max];

            for (int k = 0; k < x_max; k++) {
                for (int j = 0; j < y_max; j++) {
                    newCanvas[k][j] = ' ';
                }
            }

            int location_x = 0;
            int location_y = 0;
            if (x > 0) {
                location_x = x;
            }
            if (y > 0) {
                location_y = y;
            }
            for (int k = 0; k < grid_0.length; k++) {
                for (int j = 0; j < grid_0[0].length; j++) {
                    newCanvas[location_x + k][location_y + j] = grid_0[k][j];
                }
            }


            for (int j = 0; j < canvas.length; j++) {
                for (int k = 0; k < canvas[0].length; k++) {
                    if (newCanvas[o_x + j][o_y + k] != ' ') {
                        canvas[j][ k] = newCanvas[o_x + j][o_y + k];
                    }
                }
            }
        }

        return canvas;

    }

}
