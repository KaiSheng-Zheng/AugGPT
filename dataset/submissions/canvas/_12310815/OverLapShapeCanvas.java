

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private int gridCount;
    private int area;
    private int shapeCount;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        area = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean b = false;
        if (params.length == 1) {
            int radius = params[0];
            Circle circle = new Circle(new Location(x, y), pattern, radius);
            char[][] grids = circle.getGrids();
            if (x > canvas.length - 1 || y > canvas[0].length - 1) {
                return false;
            } else {
                loop1:
                for (int i = x; i < canvas.length; i++) {
                    for (int j = y; j < canvas[0].length; j++) {
                        if (grids[i - x][j - y] != ' ') {
                            b = true;
                            break loop1;
                        }
                    }
                }
                if (b) {
                    loop11:
                    for (int i = x; i < canvas.length; i++) {
                        loop12:
                        for (int j = y; j < canvas[0].length; j++) {
                            if (canvas[i][j] != ' ') {
                                if (grids[i - x][j - y] != ' ') {
                                    canvas[i][j] = grids[i - x][j - y];
                                    gridCount++;
                                }
                            } else {
                                if (grids[i - x][j - y] != ' ') {
                                    canvas[i][j] = grids[i - x][j - y];
                                    gridCount++;
                                }
                            }
                            if (j - y == grids[0].length - 1) {
                                break loop12;
                            }
                        }
                        if (i - x == grids.length - 1) {
                            break loop11;
                        }
                    }
                    shapeCount++;
                    shapes.add(circle);
                    return true;
                }
            }
        } else {
            int width = params[0];
            int height = params[1];
            int index = params[2];
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, Direction.valueOf(index));
            char[][] grids = rightTriangle.getGrids();
            if (x > canvas.length || y > canvas[0].length) {
                return false;
            } else {
                loop2:
                for (int i = x; i < canvas.length; i++) {
                    for (int j = y; j < canvas[0].length; j++) {
                        if (grids[i - x][j - y] != ' ') {
                            b = true;
                            break loop2;
                        }
                    }
                }
                if (b) {
                    loop21:
                    for (int i = x; i < canvas.length; i++) {
                        loop22:
                        for (int j = y; j < canvas[0].length; j++) {
                            if (canvas[i][j] != ' ') {
                                if (grids[i - x][j - y] != ' ') {
                                    canvas[i][j] = grids[i - x][j - y];
                                    gridCount++;
                                }
                            } else {
                                if (grids[i - x][j - y] != ' ') {
                                    canvas[i][j] = grids[i - x][j - y];
                                    gridCount++;
                                }
                            }
                            if (j - y == grids[0].length - 1) {
                                break loop22;
                            }
                        }
                        if (i - x == grids.length - 1) {
                            break loop21;
                        }
                    }
                    shapeCount++;
                    shapes.add(rightTriangle);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        return area - gridCount;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int result = Double.compare(s1.area(), s2.area());
                if (result == 0) {
                    result = Character.compare(s1.pattern, s2.pattern);
                }
                return result;
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int result = Integer.compare(s1.location.getX(), s2.location.getX());
                if (result == 0) {
                    result = Integer.compare(s1.location.getY(), s2.location.getY());
                    if (result == 0) {
                        result = Character.compare(s1.pattern, s2.pattern);
                    }
                }
                return result;
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}