import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i<canvas.length; i++) {
            for (int j = 0; j<canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int radius) {
        Location location = new Location(x, y);
        Circle circle = new Circle(location, pattern, radius);
        for (int i = 0; i < circle.getGrids().length; i++) {
            for (int j = 0; j < circle.getGrids()[0].length; j++) {
                if (circle.getGrids()[i][j] == pattern&&x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length) {
                    if (canvas[x + i][y + j] != ' ') {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < circle.getGrids().length; i++) {
            for (int j = 0; j < circle.getGrids()[0].length; j++) {
                if (circle.getGrids()[i][j] == pattern) {
                    if (x + i < 0 || x + i >= canvas.length || y + j < 0 || y + j >= canvas[0].length) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < circle.getGrids().length; i++) {
            for (int j = 0; j < circle.getGrids()[0].length; j++) {
                if (circle.getGrids()[i][j] == pattern&&x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length) {
                    canvas[x + i][y + j] = pattern;
                }
            }
        }
        shapes.add(circle);
        return true;
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int indexOfDirection) {
        Location location = new Location(x, y);
        Direction direction = Direction.values()[indexOfDirection];
        RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, direction);
        for (int i = 0; i < rightTriangle.getGrids().length; i++) {
            for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                if (rightTriangle.getGrids()[i][j] == pattern&&x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length) {
                    if (canvas[x + i][y + j] != ' ') {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < rightTriangle.getGrids().length; i++) {
            for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                if (rightTriangle.getGrids()[i][j] == pattern) {
                    if (x + i < 0 || x + i >= canvas.length || y + j < 0 || y + j >= canvas[0].length) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < rightTriangle.getGrids().length; i++) {
            for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                if (rightTriangle.getGrids()[i][j] == pattern&&x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length) {
                    canvas[x + i][y + j] = pattern;
                }
            }
        }
        shapes.add(rightTriangle);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i<canvas.length; i++) {
            for (int j = 0; j<canvas[0].length; j++) {
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
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((s1, s2) -> {
            if (s1.area() == s2.area()) {
                return s1.pattern - s2.pattern;
            }
            return s1.area() - s2.area();
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> shortedShapes = new ArrayList<>(shapes);
        shortedShapes.sort((s1, s2) -> {
            if (s1.location.getX() == s2.location.getX()) {
                if (s1.location.getY() == s2.location.getY()) {
                    return s1.pattern - s2.pattern;
                }
                return s1.location.getY() - s2.location.getY();
            }
            return s1.location.getX() - s2.location.getX();
        });
        return shortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}
