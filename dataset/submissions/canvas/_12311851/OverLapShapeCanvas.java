import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public OverLapShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {

        Location location = new Location(x, y);
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            int num = 0;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j] == pattern && i + x < rows && j + y < cols) {

                        canvas[i + x][j + y] = circle.getGrids()[i][j];
                        num++;
                    }
                }
            }
            if (num > 0) {
                this.shapes.add(circle);
                return true;
            } else {
                return false;
            }

        }
        if (params.length == 3) {
            int num = 0;
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (rightTriangle.getGrids()[i][j] != ' ' && i + x < rows && j + y < cols) {

                        canvas[i + x][j + y] = rightTriangle.getGrids()[i][j];
                        num++;

                    }
                }
            }
            if (num > 0) {
                this.shapes.add(rightTriangle);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    num++;
                }

            }
        }
        return num;
    }

    @Override


    public int getShapeCount() {
        return shapes.size();
    }

    public char[][] getCanvas() {
        return canvas;
    }

    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, Comparator.comparingInt(Shape::area)
                .thenComparing(Shape::getPattern));
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, Comparator.comparingInt(Shape::getX)
                .thenComparingInt(Shape::getY)
                .thenComparing(Shape::getPattern));
        return shapes;
    }
}
