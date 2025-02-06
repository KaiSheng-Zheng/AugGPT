import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }

    public boolean addShape(int x, int y, char pattern, int... params){
        Location location = new Location( x, y);
        Shape shape ;
        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);

        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            shape = new RightTriangle(location, pattern, params[0], params[1], direction);
        } else {
            return false;
        }

        shape.fillGrids();
        char[][] grids = shape.getGrids();
        if (x + grids.length > canvas.length){
            return false;
        }
        if (x < 0){
            return false;
        }
        if (y < 0){
            return false;
        }
        if (y + grids[0].length > canvas[0].length){
            return false;
        }
        for (int i = 0; i < grids.length; i++){
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j]!=' '&&canvas[i + x][j + y]!=' '){
                    return false;
                }
            }
        }
        shapes.add(shape);
        for (int i = 0; i < grids.length; i++){
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j]!=' '){
                  canvas[i+ x][j + y]= grids[i][j];
                }
            }
        }

        return true;
    }

    public int getSpaceGridCount(){
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]!=' ') {
                    count++;
                }
            }

        }
        return count;
    }

    public int getShapeCount(){
        return shapes.size();
    }

    public List<Shape> getShapesByArea(){
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        for (int i = 1; i < sortedShapes.size(); i++) {
            Shape key = sortedShapes.get(i);
            int j = i - 1;

            while (j >= 0 && (sortedShapes.get(j).getArea() > key.getArea() ||
                    (sortedShapes.get(j).getArea() == key.getArea() && sortedShapes.get(j).getPattern() > key.getPattern()))) {
                sortedShapes.set(j + 1, sortedShapes.get(j));
                j = j - 1;
            }
            sortedShapes.set(j + 1, key);
        }

        return sortedShapes;
    }

    public List<Shape> getShapesByLocation(){
        List<Shape> sortedShapes = new ArrayList<>(shapes);

        for (int i = 1; i < sortedShapes.size(); i++) {
            Shape key = sortedShapes.get(i);
            int j = i - 1;

            while (j >= 0 && (sortedShapes.get(j).getX() > key.getX() ||
                    (sortedShapes.get(j).getX() == key.getX() && sortedShapes.get(j).getY() > key.getY()) ||
                    (sortedShapes.get(j).getX() == key.getX() && sortedShapes.get(j).getY() == key.getY() && sortedShapes.get(j).getPattern() > key.getPattern()))) {
                sortedShapes.set(j + 1, sortedShapes.get(j));
                j = j - 1;
            }
            sortedShapes.set(j + 1, key);
        }


        return sortedShapes;
    }

    public char[][] getCanvas(){
        return canvas;
    }
}
