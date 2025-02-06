import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<Shape>();
    private char[][] canvas;
    private int rows;
    private int cols;
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.rows = rows;
        this.cols = cols;
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length==1){
            Location location = new Location(x,y);
            Shape a = new Circle(location,pattern,params[0]);
            for (int i = 0; i < 2*params[0]; i++) {
                for (int j = 0; j < 2*params[0]; j++) {
                    if (a.grids[i][j]==pattern){
                        if (i+x<=rows-1&&j+y<=cols-1) {
                            if (canvas[i + x][j + y] != ' ') {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
            shapes.add(a);
            for (int i = 0; i < 2*params[0]; i++) {
                for (int j = 0; j < 2*params[0]; j++) {
                    if (a.grids[i][j]==pattern){
                        canvas[i+x][j+y]=pattern;
                    }
                }
            }
            return true;
        } else {
            Location location = new Location(x, y);
            Direction d = Direction.LEFT_UP;
            switch (params[2]){
                case 0: {
                    d = Direction.LEFT_UP;
                    break;
                }
                case 1: {
                    d = Direction.LEFT_DOWN;
                    break;
                }
                case 2: {
                    d = Direction.RIGHT_UP;
                    break;
                }
                case 3: {
                    d = Direction.RIGHT_DOWN;
                    break;
                }
            }
            Shape b = new RightTriangle(location,pattern,params[0],params[1],d);
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (b.grids[i][j]==pattern){
                        if (i+x<=rows-1&&j+y<=cols-1) {
                            if (canvas[i + x][j + y] != ' ') {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (b.grids[i][j]==pattern){
                        canvas[i+x][j+y]= pattern;
                    }
                }
            }
            shapes.add(b);
            return true;
        }
    }
    public int getSpaceGridCount(){
        int counter = 0;
        for (char[] line : canvas){
            for (int i = 0; i < line.length; i++) {
                if (line[i]==' '){
                    counter++;
                }
            }
        }
        return counter;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size()-1; j++) {
                if (shapes.get(j).area()!=shapes.get(j+1).area()){
                    if (shapes.get(j).area()>shapes.get(j+1).area()){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                } else {
                    if (shapes.get(j).pattern>shapes.get(j+1).pattern){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                }
            }
        }
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size()-1; j++) {
                if (shapes.get(j).location.getX()!=shapes.get(j+1).location.getX()){
                    if (shapes.get(j).location.getX()>shapes.get(j+1).location.getX()){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                } else if (shapes.get(j).location.getY()!=shapes.get(j+1).location.getY()){
                    if (shapes.get(j).location.getY()>shapes.get(j+1).location.getY()){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                } else {
                    if (shapes.get(j).pattern>shapes.get(j+1).pattern){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                }
            }
        }
        return shapes;
    }
    public char[][] getCanvas(){
        return canvas;
    }

}
