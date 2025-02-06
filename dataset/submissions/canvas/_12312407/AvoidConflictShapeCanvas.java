import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private static int rows;
    private static int cols;
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (x < 0 || y < 0 || x >= canvas.length || y >= canvas[0].length) {//If the starting point is not in the canvas
            return false;
        }

        Shape shape;
        if (params.length == 1) {
            // circle
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            //triangle
            Direction d = Direction.values()[params[2]];
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
        } else {
            return false;
        }


        char[][] shapeGrid = shape.getGrids();
        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[i].length; j++) {
                if (x+i>=AvoidConflictShapeCanvas.rows||y+j>=AvoidConflictShapeCanvas.cols) {//it goes beyond the boundary
                    return false;
                }
                if (shapeGrid[i][j]!=' '&&canvas[x + i][y + j] != ' '){//patterns overlap
                    return false;
                }
            }
        }

        // Add shape to canvas
        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[i].length; j++) {
                if (shapeGrid[i][j] == pattern) {
                    canvas[x + i][y + j] = shapeGrid[i][j];
                }
            }
        }

        shapes.add(shape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char c : row) {
                if (c == ' ') {
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
        sortedShapes.sort(Comparator.comparingInt(o -> o.area()));
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {//CSDN The sorting method found above
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                // x
                int xComparison = Integer.compare(s1.location.getX(), s2.location.getX());
                if (xComparison != 0) {
                    return xComparison;
                }
                // y
                int yComparison = Integer.compare(s1.location.getY(), s2.location.getY());
                if (yComparison != 0) {
                    return yComparison;
                }
                //else
                return Integer.compare(s1.pattern, s2.pattern);
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    public static void main(String[] args) {
        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20);
        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3, 1));
        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
        System.out.println(shapeCanvas.addShape(6,6,'D',5,7,1));
        System.out.println(shapeCanvas.addShape(0,8,'E',3));
        shapeCanvas.getShapesByArea().forEach(System.out::println);
        shapeCanvas.getShapesByLocation().forEach(System.out::println);
        for (char[] line:shapeCanvas.getCanvas()) {
            System.out.println(line);
        }
    }
}
