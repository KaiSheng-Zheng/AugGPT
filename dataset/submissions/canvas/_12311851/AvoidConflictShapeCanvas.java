import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if ((i + x >= rows || j + y >= cols) && circle.getGrids()[i][j] == pattern)
                        return false;
                    if (circle.getGrids()[i][j] == pattern && (canvas[i + x][j + y] != ' '))
                        return false;

                }
            }
            this.shapes.add(circle);
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (i + x < rows && j + y < cols&&circle.getGrids()[i][j]!=' ') {
                        canvas[i + x][j + y] = circle.getGrids()[i][j];
                    }
                }
            }
            return true;
        }
        if (params.length == 3) {
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if ((i + x >= rows || j + y >= cols) && rightTriangle.getGrids()[i][j] == pattern){
                        return false;
                    }
                    if (rightTriangle.getGrids()[i][j] == pattern && (canvas[i + x][j + y] != ' '))
                        return false;

                }
            }
            shapes.add(rightTriangle);
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (i + x < rows && j + y < cols&&rightTriangle.getGrids()[i][j]!=' ') {
                        canvas[i + x][j + y] = rightTriangle.getGrids()[i][j];
                    }
                }}
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int num=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j]==' '){
                    num++;
                }

            }
        }
        return num;
    }

    public int getShapeCount() {
        return shapes.size();
    }

//    public int compareTo(Shape other,SortBy sortBy ) {///?
//
//        switch (sortBy) {
//            case AREA:
//                for (Shape shape : shapes) {
//                    return Integer.compare(shape.area(), other.area());
//                }
//                break;
//            case X:
//                for (Shape shape : shapes) {
//                    return Integer.compare(shape.location.getX(), other.location.getX());
//                }
//                break;
//            case Y:
//                for (Shape shape : shapes) {
//                    return Integer.compare(shape.location.getY(), other.location.getY());
//                }break;
//            case PATTERN:
//                for (Shape shape : shapes) {
//                    return Character.compare(shape.pattern,other.pattern);
//
//                }break;
//            default:
//                throw new IllegalArgumentException("Unknown sort by: " + sortBy);
//
//    }
//
//    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, Comparator.comparingInt(Shape::area)
                .thenComparing(Shape::getPattern));
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, Comparator.comparingInt(Shape::getX)
                .thenComparingInt(Shape::getY)
                .thenComparing(Shape::getPattern));
        return shapes;
    }

    public char[][] getCanvas() {
        return canvas;

    }


}

