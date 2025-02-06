import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private Direction direction;
    private Circle circle;
    private RightTriangle rightTriangle;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        this.rows = rows;
        this.cols = cols;
        this.canvas = new char[rows][cols];
        for (char[] canva : canvas) {
            Arrays.fill(canva, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1) {
            circle = new Circle(location, pattern, params[0]);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[i].length; j++) {
                    int realX = location.getX() + i ;
                    int realY = location.getY() + j ;
                    if (realX < 0 || realX >= canvas.length || realY < 0 || realY >= canvas[i].length) {
                        return false;
                    }
                    if (canvas[realX][realY] !=' ' && circle.grids[i][j] !=' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[i].length; j++) {
                    int realX = location.getX() + i;
                    int realY = location.getY() + j;
                    if (realX >= 0 && realX < rows && realY >= 0 && realY < cols&&circle.grids[i][j]!=' ') {
                        canvas[realX][realY] = circle.grids[i][j];
                    }

                }
            }
            this.shapes.add(circle);
            return true;

        } else {
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

            rightTriangle = new RightTriangle(location, pattern, params[0], params[1], direction);
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                    int realX = location.getX() + i ;
                    int realY = location.getY() + j ;
                    if (realX < 0 || realX >= canvas.length || realY < 0 || realY >= canvas[i].length) {
                        return false;
                    }
                    if (canvas[realX][realY] !=' ' && rightTriangle.grids[i][j] !=' ') {
                        return false;
                    }
                }


            }
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                    int realX = location.getX() + i;
                    int realY = location.getY() + j;
                    if (realX >= 0 && realX < rows && realY >= 0 && realY < cols&&rightTriangle.grids[i][j]!=' ') {
                        canvas[realX][realY] = rightTriangle.grids[i][j];
                    }

                }
            }
            this.shapes.add(rightTriangle);
            return true;


        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    public static Comparator<Shape> compareByArea = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            double area1 = o1.area();
            double area2 = o2.area();
            int result = Double.compare(area1, area2);
            if (result == 0) {
                char pattern1 = o1.getPattern();
                char pattern2 = o2.getPattern();
                return Character.compare(pattern1, pattern2);
            }
            return result;
        }
    };

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, compareByArea);
        return shapes;

    }

    public static Comparator<Shape> compareByLocation = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            Location loc1 = o1.getLocation();
            Location loc2 = o2.getLocation();
            int x1 = loc1.getX();
            int y1 = loc1.getY();
            int x2 = loc2.getX();
            int y2 = loc2.getY();
            int result = Integer.compare(x1, x2);
            if (result == 0) {
                result = Integer.compare(y1, y2);
                if (result == 0) {
                    char pattern1 = o1.getPattern();
                    char pattern2 = o2.getPattern();
                    return Character.compare(pattern1, pattern2);
                }
            }
            return result;
        }
    };

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, compareByLocation);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}



