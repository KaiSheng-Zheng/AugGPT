import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        if (params.length == 1) {
            newShape = new Circle(x, y, pattern, params[0]);
        } else {
            newShape = new RightTriangle(x, y, pattern, params[0], params[1], Direction.fromInteger(params[2]));
        }
        if(outOfCanvas(newShape)){
            return false;
        }
        if(overlap(newShape)){
            return false;
        }
        shapes.add(newShape);
        fillCanvas(newShape);
        return true;
    }
    public void fillCanvas(Shape shape) {
            if (shape instanceof Circle) {
                    Circle circle = (Circle) shape;
                    circle.fillGrids();
                    char[][] grids = circle.getGrids();
                    for (int i = 0; i < grids.length; i++) {
                        for (int j = 0; j < grids[i].length; j++) {
                            if (grids[i][j] != ' ') {
                                canvas[circle.getX() + i][circle.getY() + j] = grids[i][j];
                            }
                        }
                    }
                } else if (shape instanceof RightTriangle) {
                    RightTriangle triangle = (RightTriangle) shape;
                    triangle.fillGrids();
                    char[][] grids = triangle.getGrids();
                    for (int i = 0; i < grids.length; i++) {
                        for (int j = 0; j < grids[i].length; j++) {
                            if (grids[i][j] != ' ') {
                                canvas[triangle.getX() + i][triangle.getY() + j] = grids[i][j];
                            }
                        }
                    }
                }
        }

    public boolean overlap(Shape shape){
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            circle.fillGrids();
            char[][] grids = circle.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (grids[i][j]!=' '&&canvas[circle.getX() + j][circle.getY() + i] != ' ') {
                        return true;
                    }
                }
            }
        } else if (shape instanceof RightTriangle) {
            RightTriangle triangle = (RightTriangle) shape;
            triangle.fillGrids();
            char[][] grids = triangle.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (grids[i][j]!=' '&&canvas[triangle.getX() + i][triangle.getY() + j] != ' ') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean outOfCanvas(Shape shape){
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            circle.fillGrids();
            char[][] grids = circle.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (!isWithinBounds(circle.getX() + i, circle.getY() + j)) {
                        return true;
                    }
                }
            }
        } else if (shape instanceof RightTriangle) {
            RightTriangle triangle = (RightTriangle) shape;
            triangle.fillGrids();
            char[][] grids = triangle.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (!isWithinBounds(triangle.getX() + i, triangle.getY() + j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < canvas.length && y >= 0 && y < canvas[0].length;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                if (shape1.getArea() != shape2.getArea()) {
                    return shape1.getArea() - shape2.getArea();
                } else {
                    return shape1.getPattern() - shape2.getPattern();
                }
            }
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                int x1 = shape1.getLocation().getX();
                int y1 = shape1.getLocation().getY();
                int x2 = shape2.getLocation().getX();
                int y2 = shape2.getLocation().getY();

                if (x1 != x2) {
                    return x1 - x2;
                } else if (y1 != y2) {
                    return y1 - y2;
                } else {
                    return shape1.getPattern() - shape2.getPattern();
                }
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    @Override
    public boolean containsPoint(int x, int y, Shape shape) {
        return false;
    }

    @Override
    public int getArea(Shape shape) {
        return shape.area;
    }

    @Override
    public int getX(Shape shape) {
        return shape.getLocation().getX();
    }

    @Override
    public int getY(Shape shape) {
        return shape.getLocation().getY();
    }


}