import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int columns;


    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }

    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        //Circle
        if (params.length == 1) {
            Shape circle = new Circle(location, pattern, params[0]);
            char[][] circleGrids = circle.getGrids();
            for (int i = 0; i < circleGrids.length; i++) {
                for (int j = 0; j < circleGrids[i].length; j++) {
                    if (circleGrids[i][j] == pattern) {
                        //checkBoundConflict
                        if (i + x < 0 || j + y < 0) {
                            return false;
                        }
                        if (i + x >= rows || j + y >= columns) {
                            return false;
                        }

                        //checkOverlap
                        if (canvas[i + x][j + y] != ' ') {
                            return false;
                        }
                    }
                }
            }

            for (int i = 0; i < circleGrids.length; i++) {
                for (int j = 0; j < circleGrids[i].length; j++) {
                    if (circleGrids[i][j] == pattern) {
                        canvas[i+x][j+y] = pattern;
                    }
                }
            }
            shapes.add(circle);
        }

        //Triangle
        if (params.length == 3) {
            Direction d = null;
            d = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                case 3 -> Direction.RIGHT_DOWN;
                default -> d;
            };

            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            char[][] triangleGrids = rightTriangle.getGrids();
//            System.out.println(Arrays.deepToString(canvas));
            for (int i = 0; i < triangleGrids.length; i++) {
                for (int j = 0; j < triangleGrids[i].length; j++) {
                    if (triangleGrids[i][j] == pattern) {
                        //checkBoundConflict
                        if (i + x < 0 || j + y < 0) {
                            return false;
                        }
                        if (i + x >= rows || j + y >= columns) {
                            return false;
                        }


                        //checkOverlap
                        if (canvas[i + x][j + y] != ' ') {
                            return false;
                        }

                    }
                }
            }
            for (int i = 0; i < triangleGrids.length; i++) {
                for (int j = 0; j < triangleGrids[i].length; j++) {
                    if (triangleGrids[i][j] == pattern) {
                        canvas[i+x][j+y] = pattern;
                    }
                }
            }

            shapes.add(rightTriangle);

        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
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
        Collections.sort(shapes);
        Collections.sort(shapes, new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes);
        Collections.sort(shapes, new LocationY());
        Collections.sort(shapes, new LocationX());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

class AreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        return Integer.compare(s1.area(), s2.area());
    }
}

class LocationX implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Integer.compare(s1.location.getX(), s2.location.getX());
    }
}

class LocationY implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Integer.compare(s1.location.getY(), s2.location.getY());
    }
}

