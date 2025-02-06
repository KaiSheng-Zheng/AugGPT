import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        Shape shape;

        if (params.length == 1) {
            shape = new Circle(location,pattern,params[0]);
        }
        else if (params.length == 3) {
            Direction direction = Direction.LEFT_UP;
            switch (params[2]) {
                case 0:
                    direction = Direction.LEFT_UP;
                    break;
                case 1:
                    direction = Direction.LEFT_DOWN;
                    break;
                case 2:
                    direction = Direction.RIGHT_UP;
                    break;
                case 3:
                    direction = Direction.RIGHT_DOWN;
                    break;
            }

            shape = new RightTriangle(location, pattern, params[0], params[1], direction);
        }
        else {
            return false;
        }

        if (ifLocationValid(shape) && !ifOverLap(shape)) {
            shapes.add(shape);
            fillCanvas(shape);
            return true;
        }

        return false;
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
    List<Shape> tempShapes = shapes;

        tempShapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() == o2.area()) {
                    return o1.pattern-o2.pattern;
                }

                return o1.area() - o2.area();
            }
        });

        return tempShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> tempShapes = shapes;

        tempShapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX() == o2.location.getX()) {
                    if (o1.location.getY() == o2.location.getY()) {
                        return o1.pattern-o2.pattern;
                    }

                    return o1.location.getY() - o2.location.getY();
                }

                return o1.location.getX() - o2.location.getX();
            }
        });

        return tempShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private boolean ifLocationValid(Shape shape) {
        return (shape.location.getX()>=0 && shape.location.getY()>=0 && (shape.location.getX() + shape.grids.length-1) < canvas.length && (shape.location.getY() + shape.grids[0].length-1)<canvas[0].length);
    }

    private boolean ifOverLap(Shape shape) {
        int x = shape.location.getX();
        int y = shape.location.getY();

        for (int i=0; i<shape.grids.length; i++) {
            for (int j=0; j<shape.grids[0].length; j++) {
                if (canvas[i + x][j + y] != ' ' && shape.grids[i][j] != ' ') {
                    return true;
                }
            }
        }

        return false;
    }

    private void fillCanvas(Shape shape) {
        int x = shape.location.getX();
        int y = shape.location.getY();

        for (int i = 0; i<shape.grids.length; i++) {
            for (int j = 0; j<shape.grids[0].length; j++) {
                if (shape.grids[i][j] == ' ') {
                    continue;
                }
                canvas[i + x][j + y] = shape.grids[i][j];
            }
        }
    }
}
