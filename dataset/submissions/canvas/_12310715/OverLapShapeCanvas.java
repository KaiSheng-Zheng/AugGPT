import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
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

        if (ifLocationValid(shape) && ifNoneSpaceInBound(shape)) {
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
        return (shape.location.getX() < canvas.length && shape.location.getY() < canvas[0].length && (shape.location.getX() + shape.grids.length - 1) >= 0 && (shape.location.getY() + shape.grids[0].length - 1) >= 0);
    }

    private boolean ifNoneSpaceInBound(Shape shape) {
        int count = 0;

        for (int i = Math.max(shape.location.getX(), 0); i < Math.min(shape.location.getX()+shape.grids.length, canvas.length); i++) {
            for (int j = Math.max(shape.location.getY(), 0); j < Math.min(shape.location.getY() + shape.grids[0].length, canvas[0].length); j++) {
                if (shape.grids[i-shape.location.getX()][j-shape.location.getY()] == ' ') {
                    continue;
                }
                count++;
            }
        }

        return count !=0;
    }

    private void fillCanvas(Shape shape) {
        for (int i = Math.max(shape.location.getX(), 0); i < Math.min(shape.location.getX()+shape.grids.length, canvas.length); i++) {
            for (int j = Math.max(shape.location.getY(), 0); j < Math.min(shape.location.getY() + shape.grids[0].length, canvas[0].length); j++) {
                if (shape.grids[i-shape.location.getX()][j-shape.location.getY()] == ' ') {
                    continue;
                }
                canvas[i][j] = shape.grids[i-shape.location.getX()][j-shape.location.getY()];
            }
        }
    }
}
