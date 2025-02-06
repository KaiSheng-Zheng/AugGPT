import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes = new ArrayList<>();//Design a attribute shapes, which is to store the successfully added shapes.
    private char[][] canvas;//Using a char[][] array to represent the canvas. The initial value of each grid in canvas is a space' ' , which mean an empty grid.
    private int shapeCounter = 0;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);
        } else {
            Direction[] directions = new Direction[4];
            directions[0] = Direction.LEFT_UP;
            directions[1] = Direction.LEFT_DOWN;
            directions[2] = Direction.RIGHT_UP;
            directions[3] = Direction.RIGHT_DOWN;
            shape = new RightTriangle(location, pattern, params[0], params[1], directions[params[2]]);
        }
        boolean isOutOfBound = checkIfOutOfBound(shape);
        if (isOutOfBound) {
            return false;
        } else {
            boolean isOverlaped = checkIfOverlaped(shape);
            if (isOverlaped) {
                return false;
            } else {
                successfullyAddShape(shape);
                shapeCounter++;
                shapes.add(shape);
                return true;
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int spaceCounter = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    spaceCounter++;
                }
            }
        }
        return spaceCounter;
    }

    @Override
    public int getShapeCount() {
        return shapeCounter;
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> tmpShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            tmpShapes.add(shape);
        }
        Collections.sort(tmpShapes, new ShapeAreaComparator());
        return tmpShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> tmpShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            tmpShapes.add(shape);
        }
        Collections.sort(tmpShapes, new ShapeLocationComparator());
        return tmpShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    //Methods below are created by myself.
    public boolean checkIfOutOfBound(Shape shape) {
        int x = shape.getLocation().getX();
        int y = shape.getLocation().getY();
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return (y + 2 * circle.getRadius() > canvas.length - 1) || (x + 2 * circle.getRadius() > canvas[0].length);
        } else {
            RightTriangle rightTriangle = (RightTriangle) shape;
            boolean ifOutH = (x + rightTriangle.getHeight() - 1) > getCanvas().length - 1;
            boolean ifOutV = (y + rightTriangle.getWidth() - 1) > getCanvas()[0].length - 1;
            return ifOutH || ifOutV;
        }
    }

    public boolean checkIfOverlaped(Shape shape) {
        int x = shape.getLocation().getX();
        int y = shape.getLocation().getY();
        boolean b = false;
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if ((canvas[x + i][y + j] != ' ') && (circle.getGrids()[i][j] != ' ')) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            RightTriangle rightTriangle = (RightTriangle) shape;
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if ((canvas[x + i][y + j] != ' ') && (rightTriangle.getGrids()[i][j] != ' ')) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void successfullyAddShape(Shape shape) {
        int x = shape.getLocation().getX();
        int y = shape.getLocation().getY();
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = circle.getPattern();
                    }
                }
            }
        } else {
            RightTriangle rightTriangle = (RightTriangle) shape;
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (rightTriangle.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = rightTriangle.getPattern();
                    }
                }
            }
        }
    }

    static class ShapeAreaComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            int result = Integer.compare(s1.area(), s2.area());
            if (result != 0) {
                return result;
            } else {
                if (s1.getPattern() < s2.getPattern()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    static class ShapeLocationComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            int result = Location.compare(s1.getLocation(), s2.getLocation());
            if (result != 0) {
                return result;
            } else {
                if (s1.getPattern() < s2.getPattern()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
}
