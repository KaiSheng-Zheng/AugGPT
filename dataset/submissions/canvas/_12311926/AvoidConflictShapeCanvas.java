import java.util.ArrayList;
import java.util.Comparator;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private ArrayList<Shape> shapes;
    private char[][] canvas;
    private int count;
    private ArrayList<Shape> list = new ArrayList<>();

    public AvoidConflictShapeCanvas(int rows, int cols) {
        count = 0;
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = '\u0020';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            if (x + 2 * params[0] - 1 > canvas.length -1|| y + 2 * params[0] - 1 > canvas[x].length-1) {
                return false;
            }

            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[i].length; j++) {
                    if (circle.grids[i][j] != ' ' && canvas[x + i][y + j] != '\u0020') {
                        return false;
                    }
                }
            }

            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[i].length; j++) {
                    if (circle.grids[i][j] != ' ') {
                        canvas[x + i][y + j] = circle.grids[i][j];
                    }
                }
            }
            count++;
            list.add(circle);
            return true;
        }
        if (params.length == 3) {
            Location location = new Location(x, y);
            ArrayList<Direction> arrayList = new ArrayList<>();
            arrayList.add(Direction.LEFT_UP);
            arrayList.add(Direction.LEFT_DOWN);
            arrayList.add(Direction.RIGHT_UP);
            arrayList.add(Direction.RIGHT_DOWN);
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], arrayList.get(params[2]));
            if (x + params[1] - 1 > canvas.length -1|| y + params[0] - 1 > canvas[x].length-1) {
                return false;
            }
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                    if (rightTriangle.grids[i][j] != ' ' && canvas[x + i][y + j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                    if (rightTriangle.grids[i][j] != ' ') {
                        canvas[x + i][y + j] = rightTriangle.grids[i][j];
                    }
                }
            }
            count++;
            list.add(rightTriangle);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int i1 = 0; i1 < canvas[i].length; i1++) {
                if (canvas[i][i1] == '\u0020') {
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        return count;
    }

    @Override
    public ArrayList<Shape> getShapesByArea() {
        ArrayList<Shape> sortedShapes = list;
        sortedShapes.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public ArrayList<Shape> getShapesByLocation() {
        ArrayList<Shape> sortedShapes = list;
        sortedShapes.sort(Comparator.comparing(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern));
        return sortedShapes;
    }


    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}
