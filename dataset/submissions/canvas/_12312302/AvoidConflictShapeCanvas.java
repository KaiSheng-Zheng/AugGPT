import java.util.*;
public class AvoidConflictShapeCanvas implements ShapeCanvas, Comparable<Shape> {
    private List<Shape> shapes;
    private char[][] canvas;
    private int a = 0;
    private int shapeCount;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i=0; i < canvas.length; i++) {
            for (int j=0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean canAdd = true;
        if (params.length == 1) {
            Circle c = new Circle(new Location(x, y), pattern, params[0]);
            if (x + (2*c.getRadius()) > canvas.length) {
                canAdd = false;
            } else if (y + (2*c.getRadius()) > canvas[0].length) {
                canAdd = false;
            }
            if (canAdd) {
                for (int i = 0; i < c.getGrids().length; i++) {
                    for (int j = 0; j < c.getGrids()[0].length; j++) {
                        if (c.getGrids()[i][j] != ' ' && canvas[x+i][y+j] != ' ') {
                            canAdd = false;
                            break;
                        }
                    }
                    if (!canAdd) {
                        break;
                    }
                }
            }
            if (canAdd) {
                shapeCount += 1;
                shapes.add(c);
                c.fillGrids();
                for (int i=0; i < c.getGrids().length; i++) {
                    for (int j=0; j < c.getGrids()[0].length; j++) {
                        if (canvas[x+i][y+j] == ' ') {
                            canvas[x+i][y+j] = c.getGrids()[i][j];
                        }
                    }
                }
            }
        }
        else if (params.length == 3) {
            Direction d = null;
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            } else if (params[2] == 3) {
                d = Direction.RIGHT_DOWN;
            }
            RightTriangle r = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            if (x + r.getHeight() > canvas.length) {
                canAdd = false;
            } else if (y + r.getWidth() > canvas[0].length) {
                canAdd = false;
            }
            if (canAdd) {
                for (int i = 0; i < r.getGrids().length; i++) {
                    for (int j = 0; j < r.getGrids()[0].length; j++) {
                        if (r.getGrids()[i][j] != ' ' && canvas[x+i][y+j] != ' ') {
                            canAdd = false;
                            break;
                        }
                    }
                    if (!canAdd) {
                        break;
                    }
                }
            }
            if (canAdd) {
                shapeCount += 1;
                shapes.add(r);
                r.fillGrids();
                for (int i=0; i < r.getGrids().length; i++) {
                    for (int j=0; j < r.getGrids()[0].length; j++) {
                        if (canvas[x+i][y+j] == ' ') {
                            canvas[x+i][y+j] = r.getGrids()[i][j];
                        }
                    }
                }
            }
        }
        return canAdd;
    }
    @Override
    public int getSpaceGridCount() {
        int spaceGridCount = 0;
        for (int i=0; i < canvas.length; i++) {
            for (int j=0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    spaceGridCount += 1;
                }
            }
        }
        return spaceGridCount;
    }
    @Override
    public int getShapeCount() {
        return shapeCount;
    }
    public int compareTo(Shape s) {
        if (a == 1) {
            for (int i=0; i < shapes.size(); i++) {
                if (shapes.get(i).area() > s.area()) {
                    return 1;
                } else if (shapes.get(i).area() < s.area()) {
                    return -1;
                } else {
                    if (shapes.get(i).pattern > s.pattern) {
                        return 1;
                    } else if (shapes.get(i).pattern < s.pattern) {
                        return -1;
                    }
                }
            }
        }
        else if (a == 2) {
            for (int i=0; i < shapes.size(); i++) {
                if (shapes.get(i).location.getX() > s.location.getX()) {
                    return 1;
                } else if (shapes.get(i).location.getX() < s.location.getX()) {
                    return -1;
                } else {
                    if (shapes.get(i).location.getY() > s.location.getY()) {
                        return 1;
                    } else if (shapes.get(i).location.getY() < s.location.getY()) {
                        return -1;
                    } else {
                        if (shapes.get(i).pattern > s.pattern) {
                            return 1;
                        } else if (shapes.get(i).pattern < s.pattern) {
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    @Override
    public List<Shape> getShapesByArea() {
        a = 1;
        List<Shape> shapes1;
        shapes1 = shapes;
        shapes1.sort(Comparator.comparingInt(Shape::area).thenComparing(shape -> shape.pattern));     // This line of code is referred from CSDN.
        return shapes1;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        a = 2;
        List<Shape> shapes2;
        shapes2 = shapes;
        shapes2.sort(Comparator.comparingInt(Shape::getX).thenComparing(Shape::getY).thenComparing(shape -> shape.pattern));     // This line of code is referred from CSDN.
        return shapes2;
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}