
import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private final List<Shape> shapes;
    private final char[][] canvas;
    public OverLapShapeCanvas (int rows, int cols){
        shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        boolean r = false;
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            for (int i = x; i < x + 2 * params[0]; i++) {
                for (int j = y; j < y + 2 * params[0]; j++) {
                    if (circle.ifIn(i-circle.location.getX(), j-circle.location.getY()) && i >= 0 && j >= 0 && i < canvas.length && j < canvas[0].length)
                        r = true;
                }
            }
            if (!r){
                return false;
            }
            shapes.add(circle);
            for (int i = 0; i < 2*params[0]; i++) {
                for (int j = 0; j < 2*params[0]; j++) {
                    if (circle.grids[i][j] != ' ' && circle.location.getX()+i < canvas.length && circle.location.getX()+i >=0 && circle.location.getY()+j < canvas[0].length &&circle.location.getY()+j >= 0){
                        canvas[circle.location.getX()+i][circle.location.getY()+j] = pattern;
                    }
                }
            }
        }
        else {
            RightTriangle rightTriangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.values()[params[2]]);
            for (int i = x; i < x+params[1]; i++) {
                for (int j = y; j < y+params[0]; j++) {
                    if(rightTriangle.ifIn(i-x,j-y) && i >= 0 && j >= 0 && i < canvas.length && j < canvas[0].length)
                        r = true;
                }
            }
            if (!r)
                return false;
            shapes.add(rightTriangle);
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (rightTriangle.grids[i][j] != ' ' && rightTriangle.location.getX()+i >= 0 && rightTriangle.location.getX()+i < canvas.length && rightTriangle.location.getY()+j >= 0 && rightTriangle.location.getY()+j < canvas[0].length){
                        canvas[rightTriangle.location.getX()+i][rightTriangle.location.getY()+j] = pattern;
                    }
                }
            }
        }
        return r;
    }
    public int getSpaceGridCount(){
        int r = 0;
        for (char[] aCanvas : canvas) {
            for (char c : aCanvas) {
                if (c == ' ')
                    r++;
            }
        }
        return r;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        shapes.sort(new SortByArea());
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        Collections.sort(shapes);
        return shapes;
    }
    public char[][] getCanvas(){
        return canvas;
    }

}