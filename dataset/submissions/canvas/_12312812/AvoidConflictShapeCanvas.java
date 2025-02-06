import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private int shape;

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
        Location l1 = new Location(x, y);
        Shape s1;
        if (params.length == 1) {
            s1 = new Circle(l1, pattern, params[0]);
        } else {
            Direction d1;
            switch (params[2]) {
                case 0:
                    d1 = Direction.LEFT_UP;
                    break;
                case 1:
                    d1 = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d1 = Direction.RIGHT_UP;
                    break;
                default:
                    d1 = Direction.RIGHT_DOWN;
            }
            s1 = new RightTriangle(l1, pattern, params[0], params[1], d1);
        }
        if (checkConflict(s1)) {
            shapes.add(s1);
            shape++;
            return true;
        } else return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] != ' ') count++;
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shape;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 1; j < shapes.size(); j++) {
                if (shapes.get(j).area() < shapes.get(j - 1).area()) {
                    Shape e = shapes.get(j);
                    shapes.set(j, shapes.get(j - 1));
                    shapes.set(j - 1, e);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 1; j < shapes.size(); j++) {
                if (shapes.get(j).location.getX() < shapes.get(j - 1).location.getX() | (shapes.get(j).location.getX() == shapes.get(j - 1).location.getX() && shapes.get(j).location.getY() < shapes.get(j - 1).location.getY())) {
                    Shape e = shapes.get(j);
                    shapes.set(j, shapes.get(j - 1));
                    shapes.set(j - 1, e);
                }

            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private boolean checkConflict(Shape s) {
        char[][] rs = s.getGrids();
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[0].length; j++) {
                if (rs[i][j] != ' ' && (i + s.location.getX() >= canvas.length | j + s.location.getY() >= canvas[0].length)) {
                    return false;
                } else if (rs[i][j] != ' ' && canvas[i + s.location.getX()][j + s.location.getY()] != ' ') return false;
            }
        }
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[0].length; j++) {
                if (rs[i][j]!=' ') canvas[i + s.location.getX()][j + s.location.getY()] = rs[i][j];
            }
        }
        return true;
    }


}