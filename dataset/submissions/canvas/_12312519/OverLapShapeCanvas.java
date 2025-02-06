import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = null;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        }else if (params.length == 3) {
            Direction direction = Direction.fromIndex(params[2]);
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
        }else {
            return false;
        }
        if (shape == null || !fitsInCanvas(shape) ) {
            return false;
        }
        shapes.add(shape);
        drawShapeOnCanvas(shape);
        return true;
    }
    private boolean fitsInCanvas(Shape shape) {
        char[][] grids = shape.getGrids();
        Location loc = shape.getLocation();
        int startX = loc.getX();
        int startY = loc.getY();

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    int newX = startX + i;
                    int newY = startY + j;
                    if (newX >= 0 && newX < canvas.length && newY >= 0 && newY < canvas[0].length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void drawShapeOnCanvas(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    int newX = shape.getLocation().getX() + i;
                    int newY = shape.getLocation().getY() + j;
                    if (newX >= 0 && newX < canvas.length && newY >= 0 && newY < canvas[0].length)
                        canvas[newX][newY] = grids[i][j];
                }
            }
        }
    }
    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char cell : row) {
                if (cell == ' ') count++;
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
        Collections.sort(shapes, (s1, s2) -> {
            int areaCompare = Integer.compare(s1.getArea(), s2.getArea());
            if (areaCompare != 0) {
                return areaCompare;
            }else {
                return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;

    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, (s1, s2) -> {
            int xCompare = Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
            if (xCompare != 0) {
                return xCompare;
            }
            int yCompare = Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
            if (yCompare != 0) {
                return yCompare;
            }
            return Character.compare(s1.getPattern(), s2.getPattern());
        });
        return shapes;
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    public static void main(String[] args) {
        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
        canvas1.addShape(0, 0, 'A', 6);
        canvas1.addShape(1, 1, 'B', 5);
        canvas1.addShape(2, 2, 'C', 4);
        canvas1.addShape(3, 3, 'D', 3);
        canvas1.addShape(10, 5, 'E', 4, 6, 2);
        canvas1.addShape(14, 14, 'F', 4, 6, 3);
        canvas1.addShape(10, 5, '0', 3, 2, 1);
        canvas1.addShape(10, 5, '1', 1, 1, 2);
        for (char[] line : canvas1.getCanvas()) {
            System.out.println(line);
        }
        System.out.println(canvas1.getShapeCount());
        System.out.println(canvas1.getSpaceGridCount());
        canvas1.getShapesByArea().forEach(System.out::println);
        canvas1.getShapesByLocation().forEach(System.out::println);
    }
}