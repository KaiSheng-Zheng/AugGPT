import java.lang.*;
import java.util.*;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[cols][rows];
        for (char[] grid : canvas) {
            Arrays.fill(grid, ' ');
        }
    }

    private Direction directionByNumber(int n){
        Direction DBN = Direction.LEFT_UP;
        switch (n) {
            case 0:{
                DBN = Direction.LEFT_UP;
                break;
            }
            case 1:{
                DBN = Direction.LEFT_DOWN;
                break;
            }
            case 2:{
                DBN = Direction.RIGHT_UP;
                break;
            }
            case 3:{
                DBN = Direction.RIGHT_DOWN;
                break;
            }
        }
        return DBN;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        Location location = new Location(x,y);
        boolean created = true;
        char[][] draft = new char[canvas.length][canvas[0].length];
        Shape shape;
        boolean ifBreak = false;
        for (char[] grid : draft) {
            Arrays.fill(grid, ' ');
        }

        if(params.length == 1){
            shape = new Circle(location, pattern, params[0]);
            int X = location.getX();
            int Y = location.getY();
            int paintedSpace = 0;
            while(!ifBreak){
                for (int i = 0; i < 2*params[0]; i++) {
                    for (int j = 0; j < 2*params[0]; j++) {
                        if(i+location.getY() < canvas.length) {
                            Y = i + location.getY();
                            if (j + location.getX() < canvas[0].length) {
                                X = j + location.getX();
                                draft[Y][X] = pattern;
                                paintedSpace += 1;
                            }
                        }
                    }
                }
            }
            if(paintedSpace == 0){
                ifBreak = true;
            }
            while(!ifBreak){
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        canvas[i][j] = draft[i][j];
                    }
                }
            }
        }
        if(params.length == 3){
            shape = new RightTriangle(location, pattern, params[0], params[1], directionByNumber(params[2]));
            shape = new Circle(location, pattern, params[0]);
            int X = location.getX();
            int Y = location.getY();
            int paintedSpace = 0;
            while(!ifBreak){
                for (int i = 0; i < params[0]; i++) {
                    for (int j = 0; j < params[1]; j++) {
                        if(i+location.getY() < canvas.length) {

                            if (j + location.getX() < canvas[0].length) {
                                X = j + location.getX();
                                Y = i + location.getY();
                                draft[Y][X] = pattern;
                                paintedSpace += 1;
                            }
                        }
                    }
                }
            }
            if(paintedSpace == 0){
                ifBreak = true;
            }
            while(!ifBreak){
                shapes.add(shape);
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        canvas[i][j] = draft[i][j];
                    }
                }
            }
        }
        return (!ifBreak);
    }




    @java.lang.Override
    public int getSpaceGridCount() {
        int space = 0;
        for(char[] cs: canvas){
            for(char c:cs){
                if(c == 32)space += 1;
            }
        }
        return space;
    }

    @java.lang.Override
    public int getShapeCount() {
        return shapes.size();
    }

    @java.lang.Override
    public List<Shape> getShapesByArea() {
        ArrayList<Shape> waiting = new ArrayList<>();
        Shape middle;
        for (int i = 0; i < shapes.size(); i++) {
            waiting.set(i, shapes.get(i));
        }
        for (int i = 0; i < shapes.size()-1; i++) {
            for (int j = 0; j < shapes.size()-1; j++) {
                if(shapes.get(i).area>shapes.get(i+1).area){
                    middle = shapes.get(i);
                    shapes.set(i, shapes.get(i+1));
                    shapes.set(i+1,middle);
                }
            }
        }
        for (int i = 0; i < waiting.size()-1; i++) {
            for (int j = 0; j < waiting.size()-1; j++) {
                if(waiting.get(i).area == waiting.get(i+1).area
                        && waiting.get(i).pattern>waiting.get(i+1).pattern){
                    middle = waiting.get(i);
                    waiting.set(i, waiting.get(i+1));
                    waiting.set(i+1,middle);
                }
            }
        }
        return waiting;
    }

    @java.lang.Override
    public List<Shape> getShapesByLocation() {
        ArrayList<Shape> waiting = new ArrayList<>();
        Shape middle;
        for (int i = 0; i < shapes.size(); i++) {
            waiting.set(i, shapes.get(i));
        }
        for (int i = 0; i < shapes.size()-1; i++) {
            for (int j = 0; j < shapes.size()-1; j++) {
                if(shapes.get(i).area>shapes.get(i+1).area){
                    middle = shapes.get(i);
                    shapes.set(i, shapes.get(i+1));
                    shapes.set(i+1,middle);
                }
            }
        }
        for (int i = 0; i < waiting.size()-1; i++) {
            for (int j = 0; j < waiting.size()-1; j++) {
                if(waiting.get(i).location.getX() == waiting.get(i+1).location.getX()
                        && waiting.get(i).pattern>waiting.get(i+1).pattern){
                    middle = waiting.get(i);
                    waiting.set(i, waiting.get(i+1));
                    waiting.set(i+1,middle);
                }
            }
        }
        for (int i = 0; i < waiting.size()-1; i++) {
            for (int j = 0; j < waiting.size() - 1; j++) {
                if (waiting.get(i).location.getX() == waiting.get(i + 1).location.getX()
                        && waiting.get(i).location.getY() == waiting.get(i + 1).location.getY()
                        && waiting.get(i).pattern > waiting.get(i + 1).pattern) {
                    middle = waiting.get(i);
                    waiting.set(i, waiting.get(i + 1));
                    waiting.set(i + 1, middle);
                }
            }
        }
        return waiting;
    }

    @java.lang.Override
    public char[][] getCanvas() {
        return canvas;
    }

}