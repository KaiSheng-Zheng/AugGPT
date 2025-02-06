import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][]canvas;
    public OverLapShapeCanvas(int rows,int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        Location location = new Location(x,y);
        if(params.length ==1) {
            shape = new Circle(location, pattern, params[0]);
        }
        else {
            switch (params[2]){
                case 0 :
                    shape = new RightTriangle(location,pattern,params[0],params[1],Direction.LEFT_UP);
                    break;
                case 1 :
                    shape = new RightTriangle(location,pattern,params[0],params[1],Direction.LEFT_DOWN);
                    break;
                case 2 :
                    shape = new RightTriangle(location,pattern,params[0],params[1],Direction.RIGHT_UP);
                    break;
                default:
                    shape = new RightTriangle(location,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    break;
            }
        }
        char[][] grids = shape.getGrids();
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(grids[i][j] != ' '){
                    if(i+x<canvas.length&&j+y<canvas[0].length){
                        count++;
                    }
                }
            }
        }
        if(count == 0){
            return false;
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ') {
                    if (i + x < canvas.length && j + y < canvas[0].length) {
                        canvas[i + x][j + y] = pattern;
                    }
                }
            }
        }
        shapes.add(shape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        // incomplete implementation
        int count = 0;
        for (char[] canva : canvas) {
            for (char c : canva) {
                count++;
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
        for (int i = 0; i <shapes.size() ; i++) {
            for (int j = 0; j < shapes.size()-1-i; j++) {
                if(shapes.get(j).area()>shapes.get(j+1).area()){
                    Shape c = shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,c);
                }
                if(shapes.get(j).area() == shapes.get(j+1).area()){
                    if(shapes.get(j).pattern>shapes.get(j+1).pattern){
                        Shape c = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,c);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i <shapes.size() ; i++) {
            for (int j = 0; j <shapes.size()-1-i ; j++) {
                if(shapes.get(j).location.getX()>shapes.get(j+1).location.getX()){
                    Shape c = shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,c);
                }
                if(shapes.get(j).location.getX()==shapes.get(j+1).location.getX()) {
                    if (shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                        Shape c = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, c);
                    }
                    if (shapes.get(j).location.getY() == shapes.get(j + 1).location.getY()){
                        if(shapes.get(j).pattern>shapes.get(j+1).pattern){
                            Shape c = shapes.get(j);
                            shapes.set(j,shapes.get(j+1));
                            shapes.set(j+1,c);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
