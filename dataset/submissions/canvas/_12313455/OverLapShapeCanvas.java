import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;
    private char[][] canvas;
    private int space;
    private int shapeCount;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        space = rows * cols;
        shapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
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

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        boolean added = false;
        char[][] grids = null;
        Shape shape = null;
        if (params.length == 1) {
            shape= new Circle(location, pattern, params[0]);
            grids = shape.getGrids();
        } else if (params.length == 3) {
            Direction d = null;
            switch (params[2]) {
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;
                    break;
            }
            shape = new RightTriangle(location, pattern, params[0], params[1], d);
            grids = shape.getGrids();
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ' && checkBounds(i + x, j + y)) {
                    if (canvas[i + x][j + y] == ' ') {
                        space--;
                    }
                    canvas[i + x][j + y] = grids[i][j];
                    added = true;
                }
            }
        }
        if (added){
            shapeCount++;
            shapes.add(shape);
        }
        return added;
    }

    @Override
    public int getSpaceGridCount() {
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {

            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.area() - o2.area();
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {

            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.location.getX() - o2.location.getX() == 0 ? o1.location.getY() - o2.location.getY() : o1.location.getX() - o2.location.getX();
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private boolean checkBounds(int x, int y) {
        if (x > canvas.length - 1 || y > canvas[0].length - 1 ) {
            return false;
        }
        return true;
    }
}
