import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public OverLapShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
        } else {
            return false;
        }

        if (params.length == 1) {
            int m = 0;
            int n = 0;
            for (int i = 0; i < params[0] * 2; i++) {
                for (int j = 0; j < params[0] * 2; j++) {
                    if (i < params[0]) {
                        n = 1;
                    } else {
                        n = 0;
                    }
                    if (j < params[0]) {
                        m = 1;
                    } else {
                        m = 0;
                    }
                    if ((i + n - params[0]) * (i + n - params[0]) + (j + m - params[0]) * (j + m - params[0]) < params[0] * params[0]) {
                        if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                            shapes.add(shape);
                            drawShape(shape,params);
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (Direction.values()[params[2]] == Direction.LEFT_DOWN) {
                        if (params[1] * (params[0] - j) > params[0] * (params[1] - i - 1)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                shapes.add(shape);
                                drawShape(shape,params);
                                return true;
                            }
                        }
                    }

                    if (Direction.values()[params[2]] == Direction.LEFT_UP) {
                        if (params[1] * j < params[0] * (params[1] - i)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                shapes.add(shape);
                                drawShape(shape,params);
                                return true;
                            }
                        }
                    }
                    if (Direction.values()[params[2]] == Direction.RIGHT_DOWN) {
                        if (params[1] * (j + 1) > params[0] * (params[1] - i - 1)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                shapes.add(shape);
                                drawShape(shape,params);
                                return true;
                            }
                        }
                    }
                    if (Direction.values()[params[2]] == Direction.RIGHT_UP) {
                        if (params[1] * (params[0] - j - 1) < params[0] * (params[1] - i)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                shapes.add(shape);
                                drawShape(shape,params);
                                return true;
                            }
                        }
                    }
                }
            }
        }return false;
    }


    private void drawShape(Shape shape, int... params) {
        if (params.length == 1) {
            int m = 0;
            int n = 0;
            for (int i = 0; i < params[0] * 2; i++) {
                for (int j = 0; j < params[0] * 2; j++) {
                    if (i < params[0]) {
                        n = 1;
                    } else {
                        n = 0;
                    }
                    if (j < params[0]) {
                        m = 1;
                    } else {
                        m = 0;
                    }
                    if ((i + n - params[0]) * (i + n - params[0]) + (j + m - params[0]) * (j + m - params[0]) < params[0] * params[0]) {
                        if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                            canvas[i + shape.location.getX()][j + shape.location.getY()] = shape.pattern;
                        }
                    }
                }
            }
        }else {
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (Direction.values()[params[2]] == Direction.LEFT_DOWN) {
                        if (params[1] * (params[0] - j) > params[0] * (params[1] - i - 1)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                canvas[i + shape.location.getX()][j + shape.location.getY()] = shape.pattern;
                            }
                        }
                    }

                    if (Direction.values()[params[2]] == Direction.LEFT_UP) {
                        if (params[1] * j < params[0] * (params[1] - i)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                canvas[i + shape.location.getX()][j + shape.location.getY()] = shape.pattern;
                            }
                        }
                    }
                    if (Direction.values()[params[2]] == Direction.RIGHT_DOWN) {
                        if (params[1] * (j + 1) > params[0] * (params[1] - i - 1)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                canvas[i + shape.location.getX()][j + shape.location.getY()] = shape.pattern;
                            }
                        }
                    }
                    if (Direction.values()[params[2]] == Direction.RIGHT_UP) {
                        if (params[1] * (params[0] - j - 1) < params[0] * (params[1] - i)) {
                            if (i + shape.location.getX() >= 0 && i + shape.location.getX() < rows && j + shape.location.getY() >= 0 && j + shape.location.getY() < cols) {
                                canvas[i + shape.location.getX()][j + shape.location.getY()] = shape.pattern;
                            }
                        }
                    }
                }
            }
        }
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
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparing(o -> o.getPattern()));
        sortedShapes.sort(Comparator.comparingInt(s -> {
            int area = 0;
            for (char[] row : s.grids) {
                for (char cell : row) {
                    if (cell != ' ') {
                        area++;
                    }
                }
            }
            return area;
        }));
        return sortedShapes;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator.comparing(o -> o.getPattern()));
        sortedShapes.sort(Comparator.comparing(o -> o.getLocation().getY()));
        sortedShapes.sort(Comparator.comparing(o -> o.getLocation().getX()));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}