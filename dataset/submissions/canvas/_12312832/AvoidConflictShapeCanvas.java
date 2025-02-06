

import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if (params.length == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        }
        for (int i = 0; i < shape.grids.length; i ++) {
            for (int j = 0; j < shape.grids[i].length; j ++) {
                if (shape.grids[i][j] == ' ') {
                    continue;
                }
                int u = x + i, v = y + j;
                if (u >= canvas.length || v >= canvas[0].length || canvas[u][v] != ' ') {
                    return false;
                }
            }
        }
        for (int i = 0; i < shape.grids.length; i ++) {
            for (int j = 0; j < shape.grids[i].length; j ++) {
                int u = x + i, v = y + j;
                if (shape.grids[i][j] != ' ') {
                    canvas[u][v] = shape.pattern;
                }
            }
        }
        shapes.add(shape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for (char []row: canvas) {
            for (char ch: row) {
                if (ch == ' ') {
                    space ++;
                }
            }
        }
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> list = new ArrayList<>(shapes);
        list.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() == o2.area()) {
                    return Character.compare(o1.pattern, o2.pattern);
                }
                return Integer.compare(o1.area(), o2.area());
            }
        });
        return list;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> list = new ArrayList<>(shapes);
        list.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX() != o2.location.getX()) {
                    return Integer.compare(o1.location.getX(), o2.location.getX());
                }
                if (o1.location.getY() != o2.location.getY()) {
                    return Integer.compare(o1.location.getY(), o2.location.getY());
                }
                return Character.compare(o1.pattern, o2.pattern);
            }
        });
        return list;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

