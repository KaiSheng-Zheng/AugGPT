//package src;

import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    //private List<Shape> shapes;
    private final char[][] canvas;
    private List<Shape> shapeList = new ArrayList<>();
    private int shapeCount = 0;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        var location = new Location(x, y);
        boolean result = false;
        if (params.length == 1) {//a circle
            var shape = new Circle(location, pattern, params[0]);
            shape.getGrids();
            for (int i = 0; i < 2 * params[0]; i++) {
                for (int j = 0; j < 2 * params[0]; j++) {
                    if (shape.grids[i][j] != ' ') {
                        if (j + y + 1 <= canvas[0].length && i + x + 1 <= canvas.length && j + y >= 0 && i + x >= 0) {
                            result = true;
                        }
                    }
                }
            }
            for (int i = 0; i < 2 * params[0]; i++) {
                for (int j = 0; j < 2 * params[0]; j++) {
                    if (shape.grids[i][j] != ' ') {
                        if (j + y + 1 <= canvas[0].length && i + x + 1 <= canvas.length && j + y >= 0 && i + x >= 0) {
                            canvas[i + x][j + y] = pattern;
                        }
                    }
                }
            }
            if (result) {
                shapeList.add(shape);
            }
        } else if (params.length == 3) {// a triangle
            Direction d = Direction.LEFT_UP;
            switch (params[2]) {
                case 1 -> d = Direction.LEFT_DOWN;
                case 2 -> d = Direction.RIGHT_UP;
                case 3 -> d = Direction.RIGHT_DOWN;
            }
            var shape = new RightTriangle(location, pattern, params[0], params[1], d);
            shape.getGrids();
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (shape.grids[i][j] != ' ') {
                        if (j + y + 1 <= canvas[0].length && i + x + 1 <= canvas.length && j + y >= 0 && i + x >= 0) {
                            result = true;
                        }
                    }
                }
            }
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (shape.grids[i][j] != ' ') {
                        if (j + y + 1 <= canvas[0].length && i + x + 1 <= canvas.length && j + y >= 0 && i + x >= 0) {
                            canvas[i + x][j + y] = pattern;//6 6 7 12 12 16
                        }
                    }
                }
            }
            if (result) {
                shapeList.add(shape);
            }
        }
        if (result) {
            shapeCount++;
        }
        return result;


    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] i : canvas) {
            for (char j : i) {
                if (j == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> list;
        list = shapeList;
        list.sort((s1, s2) -> {
            if (s1.area() == s2.area()) {
                return s1.getPattern() - s2.getPattern();
            } else return s1.area() - s2.area();
        });
        return list;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> list;
        list = shapeList;
        list.sort((s1, s2) -> {
            if (s1.location.getX() == s2.location.getX()) {
                if (s1.location.getY() == s2.location.getY()) {
                    return s1.getPattern() - s2.getPattern();
                } else {
                    return s1.location.getY() - s2.location.getY();
                }
            } else {
                return s1.location.getX() - s2.location.getX();
            }
        });
        return list;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
