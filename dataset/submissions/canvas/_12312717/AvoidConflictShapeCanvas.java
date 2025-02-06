import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            var location = new Location(x, y);
            var circle = new Circle(location, pattern, params[0]);
            for (int i = x; i <= x + 2 * params[0] - 1; i++) {
                for (int j = y; j <= y + 2 * params[0] - 1; j++) {
                    if (circle.JudgeCircle(i, j) && (i >= rows || j >= cols))
                        return false;
                    if (circle.JudgeCircle(i, j) && canvas[i][j] != ' ')
                        return false;
                }
            }
            for (int i = x; i < x + 2 * params[0]; i++) {
                for (int j = y; j < y + 2 * params[0]; j++) {
                    if (circle.JudgeCircle(i, j))
                        canvas[i][j] = pattern;
                }
            }
            shapes.add(circle);
            return true;
        } else if (params.length == 3) {
            Direction d;
            if (params[2] == 0)
                d = Direction.LEFT_UP;
            else if (params[2] == 1)
                d = Direction.LEFT_DOWN;
            else if (params[2] == 2)
                d = Direction.RIGHT_UP;
            else d = Direction.RIGHT_DOWN;
            var location = new Location(x, y);
            var righttriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            for (int i = x; i <= x + params[1] - 1; i++) {
                for (int j = y; j <= y + params[0] - 1; j++) {
                    if (righttriangle.JudgeTriangle(i, j, d) && (i >= rows || j >= cols))
                        return false;
                    if (righttriangle.JudgeTriangle(i, j, d) && canvas[i][j] != ' ')
                        return false;
                }
            }
            for (int i = x; i <= x + params[1] - 1; i++) {
                for (int j = y; j <= y + params[0] - 1; j++) {
                    if (righttriangle.JudgeTriangle(i, j, d)) {
                        canvas[i][j] = pattern;
                    }
                }
            }
            shapes.add(righttriangle);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] != ' ')
                    num++;
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortShape = new ArrayList<>();
        sortShape = shapes;
        Shape copy;
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1; j++) {
                if (sortShape.get(j).area() > sortShape.get(j + 1).area()) {
                    copy = sortShape.get(j);
                    sortShape.set(j, sortShape.get(j + 1));
                    sortShape.set(j + 1, copy);
                } else if ((sortShape.get(j).area() == sortShape.get(j + 1).area()) && (sortShape.get(j).pattern > sortShape.get(j + 1).pattern)) {
                    copy = sortShape.get(j);
                    sortShape.set(j, sortShape.get(j + 1));
                    sortShape.set(j + 1, copy);
                }
            }
        }
        return sortShape;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortShape = new ArrayList<>();
        sortShape = shapes;
        Shape copy;
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1; j++) {
                if (sortShape.get(j).location.getX() > sortShape.get(j + 1).location.getX()) {
                    copy = sortShape.get(j);
                    sortShape.set(j, sortShape.get(j + 1));
                    sortShape.set(j + 1, copy);
                } else if (sortShape.get(j).location.getX() == sortShape.get(j + 1).location.getX() && (sortShape.get(j).location.getY() > sortShape.get(j + 1).location.getY())) {
                    copy = sortShape.get(j);
                    sortShape.set(j, sortShape.get(j + 1));
                    sortShape.set(j + 1, copy);
                } else if (sortShape.get(j).location.getX() == sortShape.get(j + 1).location.getX() && (sortShape.get(j).location.getY() == sortShape.get(j + 1).location.getY()) && (sortShape.get(j).pattern > sortShape.get(j + 1).pattern)) {
                    copy = sortShape.get(j);
                    sortShape.set(j, sortShape.get(j + 1));
                    sortShape.set(j + 1, copy);
                }
            }
        }
        return sortShape;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public char test(int x, int y) {
        return canvas[x][y];
    }


}
