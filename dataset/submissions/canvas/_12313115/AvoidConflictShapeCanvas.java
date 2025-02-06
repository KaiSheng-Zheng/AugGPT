import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int[] in = params;
        if (in.length == 1) {
            Circle c = new Circle(new Location(x, y), pattern, in[0]);
            if (x + 2 * in[0] - 1 > canvas.length - 1 || y + 2 * in[0] - 1 > canvas[0].length - 1) {
                return false;
            } else {
                c.fillGrids();
                for (int i = 0; i < c.grids.length; i++) {
                    for (int j = 0; j < c.grids[i].length; j++) {
                        if (c.grids[i][j] != ' ' && canvas[i + x][j + y] != ' ') {
                            return false;
                        }
                    }
                }
                for (int i = 0; i < c.grids.length; i++) {
                    for (int j = 0; j < c.grids[i].length; j++) {
                        if (c.grids[i][j] != ' ') {
                            canvas[i + x][j + y] = c.grids[i][j];
                        }
                    }
                }
                shapes.add(c);
            }
        }
        if (in.length == 3) {
            Direction d = Direction.LEFT_UP;//default
            switch (in[2]) {
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;
                    break;
            }
            RightTriangle t = new RightTriangle(new Location(x, y), pattern, in[0], in[1], d);
            if (x + in[1] - 1 > canvas.length - 1 || y + in[0] - 1 > canvas[0].length - 1) {
                return false;
            } else {
                t.fillGrids();
                for (int i = 0; i < t.grids.length; i++) {
                    for (int j = 0; j < t.grids[i].length; j++) {
                        if (t.grids[i][j] != ' ') {
                            if (canvas[i + x][j + y] != ' ') {
                                return false;
                            }
                        }
                    }
                }
                for (int i = 0; i < t.grids.length; i++) {
                    for (int j = 0; j < t.grids[i].length; j++) {
                        if (t.grids[i][j] != ' ') {
                            canvas[i + x][j + y] = t.grids[i][j];
                        }
                    }
                }
                shapes.add(t);
            }
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        return canvas.length * canvas[0].length;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new MyComparator(true));
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new MyComparator(false));
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    class MyComparator implements Comparator<Shape> {
        private boolean sort;

        public MyComparator(boolean sort) {
            this.sort = sort;
        }

        @Override
        public int compare(Shape s1, Shape s2) {
            if (sort) {
                if (s1.area() > s2.area()) {
                    return 1;
                } else if (s1.area() < s2.area()) {
                    return -1;
                } else if (s1.area() == s2.area()) {
                    if (s1.getPattern() > s2.getPattern()) {
                        return 1;
                    }
                    if (s1.getPattern() < s2.getPattern()) {
                        return -1;
                    }
                }
                return 0;
            } else {
                if (s1.getLocation().getX() > s2.getLocation().getX()) {
                    return 1;
                } else if (s1.getLocation().getX() < s2.getLocation().getX()) {
                    return -1;
                } else if (s1.getLocation().getX() == s2.getLocation().getX()) {
                    if (s1.getLocation().getY() > s2.getLocation().getY()) {
                        return 1;
                    } else if (s1.getLocation().getY() < s2.getLocation().getY()) {
                        return -1;
                    } else if (s1.getLocation().getY() == s2.getLocation().getY()) {
                        if (s1.getPattern() > s2.getPattern()) {
                            return 1;
                        }
                        if (s1.getPattern() < s2.getPattern()) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        }
    }
}

