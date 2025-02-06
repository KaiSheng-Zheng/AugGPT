import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        if (x < 0 || x >= canvas.length || y < 0 || y >= canvas[0].length) {
            return false;
        }
        if (params.length == 1) {
            Shape shape;
            shape = new Circle(new Location(x, y), pattern, params[0]);
            boolean flag = false;
            for (int i = 0; i < shape.grids.length; i++) {
                for (int j = 0; j < shape.grids[i].length; j++) {
                    if (shape.grids[i][j] != ' ') {
                        if (x + i < canvas.length && y + j < canvas[0].length) {
                            canvas[x + i][y + j] = shape.grids[i][j];
                            flag = true;
                        }
                    }
                }
            }
            if (flag == true) {
                shapes.add(shape);
            }
            return flag;
        }else {
            Shape shape;
            Direction d = null;
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            if (params[2] == 0) {
                d = Direction.LEFT_UP;

            }
            if (params[2] == 1) {
                d = Direction.LEFT_DOWN;

            }
            if (params[2] == 2) {
                d = Direction.RIGHT_UP;

            }
            if (params[2] == 3) {
                d = Direction.RIGHT_DOWN;

            }
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            boolean flag = false;
            for (int i = 0; i < shape.grids.length; i++) {
                for (int j = 0; j < shape.grids[i].length; j++) {
                    if (shape.grids[i][j] != ' ') {
                        if (x + i < canvas.length && y + j < canvas[0].length) {
                            canvas[x + i][y + j] = shape.grids[i][j];
                            flag = true;
                        }
                    }
                }
            }
            if (flag == true) {
                shapes.add(shape);
            }
            return flag;
        }
    }
    public int getSpaceGridCount () {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] != ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public int getShapeCount () {
        return shapes.size();
    }
    public char[][] getCanvas () {
        return canvas;
    }
    public List<Shape> getShapesByArea () {
        List<Shape> sortedShapes = this.shapes;
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                // Compare area
                int areaComparison = shape1.area() - shape2.area();
                if (areaComparison != 0) {
                    return areaComparison;
                }

                // If areas are the same, compare pattern characters
                return shape1.pattern - shape2.pattern;
            }
        });
        return sortedShapes;
    }

    public List<Shape> getShapesByLocation () {
        List<Shape> sortedShapes = this.shapes;
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                // Compare x values
                int xComparison = shape1.location.getX() - shape2.location.getX();
                if (xComparison != 0) {
                    return xComparison;
                }

                // If x values are the same, compare y values
                int yComparison = shape1.location.getY() - shape2.location.getY();
                if (yComparison != 0) {
                    return yComparison;
                }

                // If positions are the same, compare pattern characters
                return shape1.pattern - shape2.pattern;
            }
        });
        return sortedShapes;
    }
}
