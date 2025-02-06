import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int k=0;

    public OverLapShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        Shape shape;
        if (params.length == 1) {
            //circlke
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else if (params.length == 3) {
            // right triangle
            Direction d = Direction.values()[params[2]];
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
        } else {
            return false;
        }


        char[][] shapeGrid = shape.getGrids();
        if (x>=canvas.length||y>=canvas[0].length){
            return false;
        }

        boolean stop = false;
        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[i].length; j++) {
                if (0<=x+i && x+i<canvas.length && 0<=y+j && y+j<canvas[0].length){
                    if(shapeGrid[i][j] != ' '){
                        stop = true;
                        break;
                    }
                }
            }
        }
        if (!stop) {
            return false;
        }

        // Add shape to canvas
        for (int i = 0; i < shapeGrid.length; i++) {
            for (int j = 0; j < shapeGrid[i].length; j++) {
                if (shapeGrid[i][j] == pattern && x+i < canvas.length && y+j < canvas[0].length) {
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
                if (c == ' ') count++;
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
        sortedShapes.sort(Comparator.comparingInt(Shape::area));
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
                // else
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
        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
        canvas1.addShape(0, 0, 'A', 6);
        canvas1.addShape(1, 1, 'B', 5);
        canvas1.addShape(2, 2, 'C', 4);
        canvas1.addShape(3, 3, 'D', 3);
        canvas1.addShape(10, 5, 'E', 4, 6, 2);
        canvas1.addShape(14, 14, 'F', 4, 6, 3);
        canvas1.addShape(10, 5, '0', 3, 2, 1);
        canvas1.addShape(10, 5, '1', 1, 1, 2);
        for (char[] line : canvas1.getCanvas()) {
            System.out.println(line);
        }
        System.out.println(canvas1.getShapeCount());
        System.out.println(canvas1.getSpaceGridCount());
        canvas1.getShapesByArea().forEach(System.out::println);
        canvas1.getShapesByLocation().forEach(System.out::println);
    }
}