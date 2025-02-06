import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();

    private char[][] canvas;
    public int[][] count;

    int rows;
    int cols;

    public OverLapShapeCanvas(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        canvas = new char[rows][cols];
        count = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count[i][j] = 0;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location p1 = new Location(x, y);
        if (params.length == 1) {
            int radius = params[0];
            Circle circle = new Circle(p1, pattern, radius);
            char[][] tem = circle.getGrids();
            boolean checkIn = false;
            for (int i = x; i < x + 2 * radius; i++) {
                for (int j = y; j < y + 2 * radius; j++) {
                    if (i  < canvas.length && j  < canvas[0].length) {
                        if (tem[i - x][j - y] == pattern) {
                            canvas[i][j] = tem[i - x][j - y];
                            checkIn = true;
                        }
                    }
                }
            }
            if (checkIn) {
                shapes.add(circle);
            }

            return checkIn;

        } else {
            Direction d = null;
            boolean checkIn = false;
            switch (params[2]) {
                case 0 -> {
                    d = Direction.LEFT_UP;
                }
                case 1 -> {
                    d = Direction.LEFT_DOWN;
                }
                case 2 -> {
                    d = Direction.RIGHT_UP;
                }
                case 3 -> {
                    d = Direction.RIGHT_DOWN;
                }
            }
            RightTriangle rightTriangle = new RightTriangle(p1, pattern, params[0], params[1], d);
            char[][] tem = rightTriangle.getGrids();
            for (int i = x; i < x + params[1]; i++) {
                for (int j = y; j < y + params[0]; j++) {
                    if (i  < canvas.length && j  < canvas[0].length) {
                        if (tem[i - x][j - y] == pattern) {
                            canvas[i][j] = tem[i - x][j - y];
                            checkIn = true;
                        }
                    }
                }

            }
            if (checkIn) {
                shapes.add(rightTriangle);
            }
            return checkIn;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(canvas[i][j] == ' '){
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
        Comparator<Shape> comparator = Comparator.comparingInt(Shape::getArea).thenComparingInt(Shape::getPattern);
        shapes.sort(comparator);
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = Comparator.comparingInt((Shape shape) -> shape.getLocation().getX()).thenComparingInt((Shape shape) -> shape.getLocation().getY()).thenComparingInt(Shape::getPattern);
        shapes.sort(comparator);
        return shapes;
    }
    @Override
    public char[][] getCanvas() {
        return  canvas;
    }
}

