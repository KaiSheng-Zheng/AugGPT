
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if (params.length==1){
            int radius = params[0];
            shape = new Circle(new Location(x,y),pattern,radius);
        }else {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction direction = Direction.values()[directionIndex];
            shape = new RightTriangle(new Location(x,y),pattern,width,height,direction);
        }
        for(int i=x;i<x+shape.getGrids().length;i++){
            for(int j=y;j<y+shape.getGrids()[0].length;j++){
                if(shape.getGrids()[i-x][j-y]!=' '&& i>=0 && i<canvas.length && j>=0 && j<canvas[0].length){
                    canvas[i][j]=shape.getGrids()[i-x][j-y];
                }
            }
        }
        for(int i=x;i<x+shape.getGrids().length;i++){
            for(int j=y;j<y+shape.getGrids()[0].length;j++){
                if(shape.getGrids()[i-x][j-y]!=' '&& (i>=0 && i<canvas.length && j>=0 && j<canvas[0].length)){
                    shapes.add(shape);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean outOfBound(Shape shape) {
        int x = shape.location.getX();
        int y = shape.location.getY();
        for(int i=x;i<x+shape.getGrids().length;i++){
            for(int j=y;j<y+shape.getGrids()[0].length;j++){
                if(shape.getGrids()[i-x][j-y]!=' '&(i<0 | i>=canvas.length | j<0 | j>=canvas[0].length)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j] == ' '){
                    space++;
                }
            }
        }
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes);
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            public int compare(Shape s1, Shape s2) {
                int compareX = Double.compare(s1.location.getX(), s2.location.getX());
                if (compareX == 0) {
                    int compareY = Double.compare(s1.location.getY(), s2.location.getY());
                    if (compareY == 0) {
                        return Character.compare(s1.pattern, s2.pattern);
                    }
                    return compareY;
                }
                return compareX;
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


}