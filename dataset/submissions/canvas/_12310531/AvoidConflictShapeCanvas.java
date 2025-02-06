import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            // Add Circle to canvas
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            for (int a = 0; a < circle.getGrids().length; a++) {
                for (int b = 0; b < circle.getGrids()[0].length; b++) {
                    if (circle.getGrids()[a][b] != ' ') {
                        if (circle.location.getX()+a+1 > canvas.length
                                || circle.location.getY()+b+1 > canvas[0].length) {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j] != ' '&&canvas[circle.location.getX()+i][circle.location.getY()+j] != ' ') {
                        return false;
                    }
                }
            }
            updateCanvas(circle);
            shapes.add(circle);
        } else if (params.length == 3) {
            // Add RightTriangle to canvas
            Direction direction = Direction.values()[params[2]];
            RightTriangle triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
            for (int a = 0; a < triangle.getGrids().length; a++) {
                for (int b = 0; b < triangle.getGrids()[0].length; b++) {
                    if (triangle.getGrids()[a][b] != ' ') {
                        if (triangle.location.getX()+a+1 > canvas.length
                                || triangle.location.getY()+b+1 > canvas[0].length) {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < triangle.getGrids().length; i++) {
                for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                    if (triangle.getGrids()[i][j] != ' '&&canvas[triangle.location.getX()+i][triangle.location.getY()+j] != ' ') {
                        return false;
                    }
                }
            }
            updateCanvas(triangle);
            shapes.add(triangle);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
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
        Collections.sort(sortedShapes, (s1, s2) -> {
            if (s1.area() != s2.area()) {
                return s1.area() - s2.area();
            } else {
                return s1.pattern - s2.pattern;
            }
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, (s1, s2) -> {
            if (s1.location.getX() != s2.location.getX()) {
                return s1.location.getX() - s2.location.getX();
            } else if (s1.location.getY() != s2.location.getY()) {
                return s1.location.getY() - s2.location.getY();
            } else {
                return s1.pattern - s2.pattern;
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private void updateCanvas(Shape shape) {
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                    if (shape.getGrids()[i][j] != ' ') {
                        if (shape.location.getX()+i+1 <= canvas.length&&shape.location.getY()+j+1 <= canvas[0].length) {
                            canvas[shape.location.getX() + i][shape.location.getY() + j] = shape.getGrids()[i][j];
                        }
                    }
                }
            }
        }
    }

