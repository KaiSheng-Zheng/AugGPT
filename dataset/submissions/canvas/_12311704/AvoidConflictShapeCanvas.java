
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            Shape newShape = new Circle(new Location(x, y), pattern, params[0]);
            char[][] shapeGrids = newShape.getGrids();
            for (int i = 0; i < shapeGrids.length; i++) {
                for (int j = 0; j < shapeGrids[i].length; j++) {
                    int canvasX = x + i;
                    int canvasY = y + j;
                    if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length) {
                        if (shapeGrids[i][j] == pattern && canvas[canvasX][canvasY] != ' ') {
                            return false; // Conflict detected
                        }
                    }
                }
            }
            if(x + shapeGrids.length-1 >= canvas.length || x + shapeGrids.length-1 <=0){
                return false;
            }
            for (int i = 0; i < shapeGrids.length; i++) {
                if (y + shapeGrids[i].length - 1 >= canvas[0].length || y + shapeGrids[i].length - 1 <0) {
                    return false;
                }
            }
            shapes.add(newShape);
            for (int i = 0; i < shapeGrids.length; i++) {
                for (int j = 0; j < shapeGrids[i].length; j++) {
                    int canvasX = x + i;
                    int canvasY = y + j;
                    if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length) {
                        if (shapeGrids[i][j] == pattern) {
                            canvas[canvasX][canvasY] = pattern;
                        }
                    }else return false;
                }
            }
        }
        if (params.length == 3) {
            Direction d = Direction.LEFT_UP;
            if(params[2]==0){
                d = Direction.LEFT_UP;
            }
            if(params[2]==1){
                d = Direction.LEFT_DOWN;
            }
            if(params[2]==2){
                d = Direction.RIGHT_UP;
            }
            if(params[2]==3){
                d = Direction.RIGHT_DOWN;
            }
            Shape newShape = new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);

            char[][] shapeGrids = newShape.getGrids();
            for (int i = 0; i < shapeGrids.length; i++) {
                for (int j = 0; j < shapeGrids[i].length; j++) {
                    int canvasX = x + i;
                    int canvasY = y + j;
                    if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length) {
                        if (shapeGrids[i][j] == pattern && canvas[canvasX][canvasY] != ' ') {
                            return false; // Conflict detected
                        }
                    }
                }
            }
            // No conflicts, add the shape
            if(x + shapeGrids.length-1 >= canvas.length || x + shapeGrids.length-1 <=0){
                return false;
            }
            for (int i = 0; i < shapeGrids.length; i++) {
                if (y + shapeGrids[i].length - 1 >= canvas[0].length || y + shapeGrids[i].length - 1 <0) {
                    return false;
                }
            }
            shapes.add(newShape);
            for (int i = 0; i < shapeGrids.length; i++) {
                for (int j = 0; j < shapeGrids[i].length; j++) {
                    int canvasX = x + i;
                    int canvasY = y + j;
                    if (canvasX >= 0 && canvasX < canvas.length && canvasY >= 0 && canvasY < canvas[0].length) {
                        if (shapeGrids[i][j] == pattern) {
                            canvas[canvasX][canvasY] = pattern;
                        }
                    }
                }
            }
        }



        return true;
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
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int areaComparison = Integer.compare(s1.area(), s2.area());
                if (areaComparison != 0) return areaComparison;
                return Character.compare(s1.pattern, s2.pattern);
            }
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int xComparison = Integer.compare(s1.location.getX(), s2.location.getX());
                if (xComparison != 0) return xComparison;
                int yComparison = Integer.compare(s1.location.getY(), s2.location.getY());
                if (yComparison != 0) return yComparison;
                return Character.compare(s1.pattern, s2.pattern);
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
