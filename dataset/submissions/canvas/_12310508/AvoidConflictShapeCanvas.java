import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (char[] canva : canvas) {
            Arrays.fill(canva, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean test = false;
        if (params.length == 1) {
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            boolean judge = true;
            if ((y + 2 * params[0] < canvas.length) && (x + 2 * params[0] < canvas[0].length)) {
                for (int i = 0; i < 2 * params[0]; i++) {
                    for (int j = 0; j < 2 * params[0]; j++) {
                        if (circle.getGrids()[i][j] != ' ') {
                            if (canvas[i+x][y+j] != ' ') {
                                judge = false;
                                break;
                            }
                        }
                    }
                }
                if (judge) {
                    test = true;
                    shapes.add(circle);
                    for (int i = 0; i < 2 * params[0]; i++) {
                        for (int j = 0; j < 2 * params[0]; j++) {
                            if (circle.getGrids()[i][j] != ' ') {
                                canvas[i + x][j + y] = pattern;
                            }
                        }
                    }
                }
            }
            return test;
        }
        if (params.length == 3) {
            Location location = new Location(x, y);
            boolean judge = true;
            Direction d = Direction.LEFT_UP;
            RightTriangle rightTriangle = null;

            d = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                case 3 -> Direction.RIGHT_DOWN;
                default -> d;
            };
            rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            if ((x + params[1] <= canvas.length) && (y + params[0] <= canvas[0].length)) {
                for (int i = 0; i < params[0]; i++) {
                    for (int j = 0; j < params[1]; j++) {
                        if (rightTriangle.getGrids()[j][i] !=' ') {
                            if (canvas[j+x][i+y] != ' '){
                                judge = false;
                                break;
                            }
                        }
                    }
                    if (!judge) break;
                }

                if (judge) {
                    test = true;
                    shapes.add(rightTriangle);
                    for (int i = 0; i < params[0]; i++) {
                        for (int j = 0; j < params[1]; j++) {
                            if (rightTriangle.getGrids()[j][i] != ' ') {
                                canvas[j + x][y + i] = rightTriangle.getGrids()[j][i];
                            }
                        }
                    }
                }
            }
        }
        return test;
    }

    @Override
    public int getSpaceGridCount() {
        int k = 0;
        for (char[] canva : canvas) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canva[j] == ' ') {
                    k++;
                }
            }
        }
        return k;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(Comparator.comparingInt(Shape::area).thenComparingInt(s -> s.pattern));
        return new ArrayList<>(shapes);
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((s1, s2) -> {
            int xCompare = Integer.compare(s1.location.getX(), s2.location.getX());
            if (xCompare != 0) {
                return xCompare;
            }
            int yCompare = Integer.compare(s1.location.getY(), s2.location.getY());
            if (yCompare != 0) {
                return yCompare;
            }
            return Character.compare(s1.pattern, s2.pattern);
        });
        return new ArrayList<>(shapes);
    }


    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
