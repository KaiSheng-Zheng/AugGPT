import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;
    private int space;
    private int shapeCount;

    public static void main(String[] args) {
        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(15, 20);
        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3, 1));
        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
        System.out.println(shapeCanvas.addShape(6,6,'D',5,7,1));
        System.out.println(shapeCanvas.addShape(0,8,'E',3));
        shapeCanvas.getShapesByArea().forEach(System.out::println);
        shapeCanvas.getShapesByLocation().forEach(System.out::println);
        for (char[] line:shapeCanvas.getCanvas()) {
            System.out.println(line);
        }
    }

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        space = rows * cols;
        shapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
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
                if ((grids[i][j] != ' ') && (x + i > canvas.length - 1 || y + j > canvas[0].length - 1) ){
                    return added;
                }
                else if (grids[i][j] != ' ' && canvas[i + x][j + y] != ' ') {
                    return added;
                }
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    canvas[i + x][j + y] = grids[i][j];
                    added = true;
                    space--;
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
}
