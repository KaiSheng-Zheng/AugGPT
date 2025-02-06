import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private int shapeCounter = 0;

    public OverLapShapeCanvas(int rows, int cols) {
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
        boolean b = false;
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
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                if (shape.getGrids()[i][j] != ' ' && ifAGridPointIsInCanvas(i, j, shape)) {
                    successfullyAddShape(shape);
                    shapeCounter++;
                    shapes.add(shape);
                    return true;
                }
            }
        }
        return false;
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
    public void successfullyAddShape(Shape shape) {
        int x = shape.getLocation().getX();
        int y = shape.getLocation().getY();
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                if (shape.getGrids()[i][j] != ' ' && ifAGridPointIsInCanvas(i, j, shape)) {
                    canvas[x + i][y + j] = shape.getPattern();
                }
            }
        }
    }

    public boolean ifAGridPointIsInCanvas(int i, int j, Shape shape) {
        int x = shape.getLocation().getX();
        int y = shape.getLocation().getY();
        return x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length;
    }

    public int areaInOverLap(Shape shape) {
        int s = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == shape.getPattern()) {
                    s++;
                }
            }
        }
        return s;
    }

    //remain to be modified
//    class ShapeAreaComparator implements Comparator<Shape> {
//        @Override
//        public int compare(Shape s1, Shape s2) {
//            int a1 = areaInOverLap(s1);
//            int a2 = areaInOverLap(s2);
//            int result = Integer.compare(a1, a2);
//            if (result != 0) {
//                return result;
//            } else {
//                if (s1.getPattern() < s2.getPattern()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        }
//    }
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
