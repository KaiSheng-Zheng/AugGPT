import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
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
        Shape shape = null;
        if (params.length == 1) {
                shape = new Circle(new Location(x, y), pattern, params[0]);
            }else if(params.length == 3){
                    Direction direction = Direction.fromIndex(params[2]);
                    shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
                }else {
                return false;
        }

        if (shape == null || !fitsInCanvas(shape) || conflicts(shape)) {
            return false;
        }
        shapes.add(shape);
        drawShapeOnCanvas(shape);
        return true;
    }

    private boolean fitsInCanvas(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    int newX = shape.getLocation().getY() + j;
                    int newY = shape.getLocation().getX() + i;
                    if (newX < 0 || newX >= canvas[0].length || newY < 0 || newY >= canvas.length) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean conflicts(Shape shape) {
        char[][] grids = shape.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    int newX = shape.getLocation().getY() + j;
                    int newY = shape.getLocation().getX() + i;
                    if (canvas[newY][newX] != ' ') {
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
                    int newX = shape.getLocation().getY() + j;
                    int newY = shape.getLocation().getX() + i;
                    canvas[newY][newX] = grids[i][j];
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
        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20) ;
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
}