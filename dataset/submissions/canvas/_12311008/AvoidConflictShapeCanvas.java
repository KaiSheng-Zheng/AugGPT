import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public int getSpaceGridCount() {
        int spaceGridCount = 0;
        for (int i = 0; i < canvas.length - 1; i++) {
            for (int j = 0; j < canvas[0].length - 1; j++) {
                if (canvas[i][j] == ' ') {
                    spaceGridCount++;
                }
            }
        }
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area > s2.area) {
                    return 1;
                } else if (s1.area == s2.area) {
                    if (s1.pattern > s2.pattern) {
                        return 1;
                    } else if (s1.pattern < s2.pattern) {
                        return -1;
                    }
                    return 0;
                }
                return -1;
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() > s2.location.getX()) {
                    return 1;
                } else if (s1.location.getX() == s2.location.getX()) {
                    if (s1.location.getY() > s2.location.getY()) {
                        return 1;
                    } else if (s1.location.getY() == s2.location.getY()) {
                        if (s1.pattern > s2.pattern) {
                            return 1;
                        } else if (s1.pattern == s2.pattern) {
                            return 0;
                        } else return -1;
                    }
                    return -1;
                }
                return -1;
            }
        });
        return shapes;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Shape circle = new Circle(new Location(x, y), pattern, params[0]);
            if (x + params[0] * 2 <= canvas.length && y + params[0] * 2 <= canvas[0].length) {
                for (int i = 0; i <= params[0] * 2 - 1; i++) {
                    for (int j = 0; j <= params[0] * 2 - 1; j++) {
                        if (canvas[x + i][y + j] != ' ') {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= params[0] * 2 - 1; i++) {
                    for (int j = 0; j <= params[0] * 2 - 1; j++) {
                        if (circle.grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
                for (int i = 0; i <= params[0] * 2 - 1; i++) {
                    for (int j = 0; j <= params[0] * 2 - 1; j++) {
                        if (canvas[x + i][y + j] == pattern) {
                            shapes.add(circle);
                            return true;
                        }
                    }
                }
                return false;
            } else return false;
        } else if (params.length == 3) {
            Shape triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            if (x + params[1] <= canvas.length && y + params[0] <= canvas[0].length) {
                for (int i = 0; i <= params[1] - 1; i++) {
                    for (int j = 0; j <= params[0] - 1; j++) {
                        if (canvas[x + i][y + j] != ' ') {
                            if (triangle.grids[i][j] == pattern) {
                                return false;
                            }
                        }
                    }
                }

                for (int i = 0; i <= params[1] - 1; i++) {
                    for (int j = 0; j <= params[0] - 1; j++) {
                        if (triangle.grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
                for (int i = 0; i <= params[1] - 1; i++) {
                    for (int j = 0; j <= params[0] - 1; j++) {
                        if (canvas[x + i][y + j] == pattern) {
                            shapes.add(triangle);
                            return true;
                        }
                    }
                }
                return false;
            } else return false;
        }else return false;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}