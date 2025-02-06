import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        char[][] primeCanvas = new char[this.canvas.length][];
        for (int i = 0; i < this.canvas.length; i++) {
            primeCanvas[i] = Arrays.copyOf(this.canvas[i], this.canvas[i].length);
        }

        boolean ifOutOfBound = true;
        Location location = new Location(x, y);
        char[][] grids;
        Shape shape;

        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);
            grids = shape.getGrids();
        } else {
            shape = getShape(pattern, params, location);
            grids = shape.getGrids();

        }
        for (int i = x; i < grids.length + x; i++) {
            for (int j = y; j < grids[0].length + y; j++) {
                try {
                    if (grids[i - x][j - y] != ' ') {
                        this.canvas[i][j] = grids[i - x][j - y];
                        ifOutOfBound = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    //this.canvas = primeCanvas;
                    //return false;
                }
            }
        }
        if(ifOutOfBound){
            this.canvas=primeCanvas;
            return false;
        }
        this.shapes.add(shape);
        return true;
    }


    @Override
    public int getSpaceGridCount() {

        int result = 0;

        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if (this.canvas[i][j] == ' ') {
                    result++;
                }
            }
        }

        return result;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> arrangedShapes = new ArrayList<>(this.shapes);
        arrangedShapes.sort(new ShapeAreaComparator());

        return arrangedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> arrangedShapes = new ArrayList<>(this.shapes);
        arrangedShapes.sort(new ShapeLocationComparator());

        return arrangedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }

    private static Shape getShape(char pattern, int[] params, Location location) {
        Direction d = switch (params[2]) {
            case 0 -> Direction.LEFT_UP;
            case 1 -> Direction.LEFT_DOWN;
            case 2 -> Direction.RIGHT_UP;
            case 3 -> Direction.RIGHT_DOWN;
            default -> null;
        };
        return new RightTriangle(location, pattern, params[0], params[1], d);
    }

}

class ShapeAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.area() > o2.area()) {
            return 1;
        } else if (o1.area() < o2.area()) {
            return -1;
        } else {
            return Character.compare(o1.pattern, o2.pattern);
        }
    }
}

class ShapeLocationComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.location.getX() > o2.location.getX()) {
            return 1;
        } else if (o1.location.getX() < o2.location.getX()) {
            return -1;
        } else {
            if (o1.location.getY()>o2.location.getY()){
                return 1;
            } else if (o1.location.getY() < o2.location.getY()) {
                return -1;
            }else {
                return Character.compare(o1.pattern, o2.pattern);
            }
        }
    }
}
