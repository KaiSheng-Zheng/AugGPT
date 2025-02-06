import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length == 1) {
            int radius = params[0];
            if (x + 2 * radius > canvas.length || y + 2 * radius > canvas[0].length) {
                return false;
            }
            Circle c = new Circle(new Location(x, y), pattern, radius);
            char[][] grids = c.getGrids();
            for (int i = 0; i < radius * 2; i++) {
                for (int j = 0; j < radius * 2; j++) {
                    if (grids[i][j] == pattern && canvas[x + i][y + j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < radius * 2; i++) {
                for (int j = 0; j < radius * 2; j++) {
                    if (grids[i][j] == pattern) {
                        canvas[x + i][y + j] = pattern;
                    }
                }
            }
            if(shapes == null) {
                shapes = new ArrayList<>();
            }
            shapes.add(c);
        } else {
            int width = params[0];
            int height = params[1];
            int d = params[2];
            if (x + height > canvas.length || y + width > canvas[0].length) {
                return false;
            }
            Direction dir = Direction.LEFT_UP;
            switch (d) {
                case 0:
                    dir = Direction.LEFT_UP;
                    break;
                case 1:
                    dir = Direction.LEFT_DOWN;
                    break;
                case 2:
                    dir = Direction.RIGHT_UP;
                    break;
                case 3:
                    dir = Direction.RIGHT_DOWN;
                    break;
            }
            RightTriangle r = new RightTriangle(new Location(x, y), pattern, width, height, dir);
            char[][] grids = r.getGrids();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grids[i][j] == pattern && canvas[x + i][y + j] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grids[i][j] == pattern) {
                        canvas[x + i][y + j] = pattern;
                    }
                }
            }
            if(shapes == null) {
                shapes = new ArrayList<>();
            }
            shapes.add(r);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for(int i = 0;i < canvas.length;i++) {
            for(int j = 0;j < canvas[0].length;j++) {
                if(canvas[i][j] == ' ') {
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
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area())
                    return Integer.compare(s1.area(), s2.area());
                else
                    return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX())
                    return Integer.compare(s1.location.getX(), s2.location.getX());
                else if (s1.location.getY() != s2.location.getY())
                    return Integer.compare(s1.location.getY(), s2.location.getY());
                else
                    return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
