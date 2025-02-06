import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        if (params.length == 1) {
            newShape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            newShape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction(params[2]));
        } else {
            throw new IllegalArgumentException("Invalid number of parameters");
        }

        if (x < 0 || y < 0 || x + newShape.getHeight() > canvas.length || y + newShape.getWidth() > canvas[0].length) {
            return false;
        }

        for (int i = 0; i < newShape.getHeight(); i++) {
            for (int j = 0; j < newShape.getWidth(); j++) {
                if (canvas[x + i][y + j] != ' ' && newShape.grids[i][j] != ' ')
                    return false;

            }
        }
        for (int i = 0; i < newShape.getHeight(); i++) {
            for (int j = 0; j < newShape.getWidth(); j++) {
                if ((canvas[x + i][y + j] == ' ') || ((canvas[x + i][y + j] != ' ' && newShape.grids[i][j] == ' ')) && newShape.grids[i][j] != ' ')
                    canvas[x + i][y + j] = newShape.grids[i][j];
            }
        }
        shapes.add(newShape);

        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char cell : row) {
                if (cell == ' ') {
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
        return shapes.stream()
                .sorted(Comparator.comparingInt(Shape::area))
                .collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).getLocation().getX() > shapes.get(j + 1).getLocation().getX()) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
                if (shapes.get(j).getLocation().getX() == shapes.get(j + 1).getLocation().getX()) {
                    if (shapes.get(j).getLocation().getY() > shapes.get(j + 1).getLocation().getY()) {
                        Shape temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
                if (shapes.get(j).getLocation().getX() == shapes.get(j + 1).getLocation().getX()) {
                    if (shapes.get(j).getLocation().getY() == shapes.get(j + 1).getLocation().getY()) {
                        if (shapes.get(j).getPattern() > shapes.get(j + 1).getPattern()) {
                            Shape temp = shapes.get(j);
                            shapes.set(j, shapes.get(j + 1));
                            shapes.set(j + 1, temp);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public Direction direction(int a) {
        if (a == 0)
            return Direction.LEFT_UP;
        if (a == 1)
            return Direction.LEFT_DOWN;
        if (a == 2)
            return Direction.RIGHT_UP;
        if (a == 3)
            return Direction.RIGHT_DOWN;
        else return null;
    }

}

