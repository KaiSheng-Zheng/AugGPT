import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
            c.fillGrids();
            boolean b = false;
            for (int i = 0; i < c.grids.length; i++) {
                for (int j = 0; j < c.grids[i].length; j++) {
                    if (c.grids[i][j] != ' ' && (i + x) < canvas.length && (j + y) < canvas[0].length) {
                        canvas[i + x][j + y] = c.grids[i][j];
                        b = true;
                    }
                }
            }
            if (b) {
                shapes.add(c);
                return true;
            } else {
                return false;
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
            t.fillGrids();
            boolean b = false;
            for (int i = 0; i < t.grids.length; i++) {
                for (int j = 0; j < t.grids[i].length; j++) {
                    if (t.grids[i][j] != ' ' && (i + x) < canvas.length && (j + y) < canvas[0].length) {
                        canvas[i + x][j + y] = t.grids[i][j];
                        b = true;
                    }
                }
            }
            if (b) {
                shapes.add(t);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        // fail to count space after adding any shape.
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


