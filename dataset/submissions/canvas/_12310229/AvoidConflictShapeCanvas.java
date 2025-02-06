import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private char[][] grids;
    private int rows;
    private int cols;
    private int sum1 = 0;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes=new ArrayList<>();
    }


    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        boolean is = false;

        if (params.length == 1) {
            Circle Circle = new Circle(location, pattern, params[0]);
            grids = Circle.getGrids();
            if (x >= 0 && x + params[0] * 2 <= rows && y >= 0 && y + params[0] * 2 <= cols) {
                is = true;
                for (int i = 0; i <  params[0] * 2; i++) {
                    for (int j = 0; j < params[0] * 2; j++) {
                        if (grids[i][j] != ' ' && canvas[x + i][y + j] != ' ') {
                            is = false;
                        }
                    }
                }
            }
            if (is) {
                for (int i = 0; i < params[0] * 2; i++) {
                    for (int j = 0; j < params[0] * 2; j++) {
                        if (grids[i][j] != ' ') {
                            canvas[x + i][y + j] = grids[i][j];
                        }
                    }
                }
                sum1++;
                shapes.add(Circle);
            }
        }
        if (params.length == 3) {
            Direction[] d = {Direction.LEFT_UP, Direction.LEFT_DOWN, Direction.RIGHT_UP, Direction.RIGHT_DOWN};
            RightTriangle RightTriangle = new RightTriangle(location, pattern, params[0], params[1], d[params[2]]);
            grids = RightTriangle.getGrids();
            if (x >= 0 && x + params[1] <= rows && y >= 0 && y + params[0] <= cols) {
                is = true;
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (grids[i][j] != ' ' && canvas[x + i][y + j] != ' ') {
                            is = false;
                        }
                    }
                }
            }
            if (is) {
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (grids[i][j] != ' ') {
                            canvas[x + i][y + j] = grids[i][j];
                        }
                    }
                }
                sum1++;
                shapes.add(RightTriangle);
            }
        }
        return is;
    }

    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ') {
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        return sum1;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Shape temp;
        for (int i = 0; i < sum1; i++) {
            for (int j = 0; j < sum1 - 1 - i; j++) {
                if (shapes.get(j).area > shapes.get(j + 1).area) {
                    temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
                if (shapes.get(j).area == shapes.get(j + 1).area && shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                    temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Shape tem;
        for (int i = 0; i < sum1; i++) {
            for (int j = 0; j < sum1 - 1 - i; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j + 1).location.getX()) {
                    tem = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, tem);
                }
                if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX() && shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                    tem = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, tem);
                }
                if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX() && shapes.get(j).location.getY() == shapes.get(j + 1).location.getY() && shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                    tem = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, tem);
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
