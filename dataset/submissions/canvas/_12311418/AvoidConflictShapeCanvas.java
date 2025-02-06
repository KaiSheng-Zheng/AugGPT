import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private int shapeCount;
    private char[][] canvas;
    private List<Shape> shapes = new ArrayList<>();
    private final int r;
    private final int c;
    private int space = 0;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        r = rows;
        c = cols;
        canvas = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            if (!isCircleInBound(x, y, params)) {
                return false;
            }
            for (int i = x; i < x + circle.getGrids().length; i++) {
                for (int j = y; j < y + circle.getGrids()[0].length; j++) {
                    if (circle.grids[i - x][j - y] != ' ' && canvas[i][j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = x; i < x + circle.getGrids().length; i++) {
                for (int j = y; j < y + circle.getGrids()[0].length; j++) {
                    if (circle.grids[i - x][j - y] != ' ') {
                        canvas[i][j] = circle.grids[i - x][j - y];
                    }
                }
            }
            this.shapes.add(circle);
            shapeCount += 1;
        } else if (params.length == 3) {
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            if (!isTriangleInBound(x, y, params)) {
                return false;
            }
            for (int i = x; i < x + rightTriangle.getGrids().length; i++) {
                for (int j = y; j < y + rightTriangle.getGrids()[0].length; j++) {
                    if (rightTriangle.grids[i - x][j - y] != ' ' && canvas[i][j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = x; i < x + rightTriangle.grids.length; i++) {
                for (int j = y; j < y + rightTriangle.grids[0].length; j++) {
                    if (rightTriangle.grids[i - x][j - y] != ' ') {
                        canvas[i][j] = rightTriangle.grids[i - x][j - y];
                    }
                }
            }
            this.shapes.add(rightTriangle);
            shapeCount += 1;
        } else return false;
        return true;
    }


    public boolean isCircleInBound(int x, int y, int... params) {
        return (params[0] * 2 + x) <= r && (params[0] * 2 + y <= c);
    }

    public boolean isTriangleInBound(int x, int y, int... params) {
        return (params[1] + x) <= r && (params[0] + y <= c);
    }


    @Override
    public int getSpaceGridCount() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (canvas[i][j] == ' ') {
                    space++;
                }
            }
        }
        return space;
    }

    public int getShapeCount() {
        return shapeCount;
    }

    public char[][] getCanvas() {
        return canvas;
    }


    public List<Shape> getShapesByArea() {
        Shape temp;
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).area() > shapes.get(j + 1).area()) {
                    temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).area() == shapes.get(j + 1).area()) {
                    if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                        temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        Shape temp;
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j + 1).location.getX()) {
                    temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX()) {
                    if (shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                        temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if ((shapes.get(j).location.getX() == shapes.get(j + 1).location.getX()) && (shapes.get(j).location.getY() == shapes.get(j + 1).location.getY())) {
                    if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                        temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        return shapes;
    }

}

