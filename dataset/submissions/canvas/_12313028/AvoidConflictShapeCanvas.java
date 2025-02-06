import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int rows, cols;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for(int i = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                canvas[i][j] = ' ';
        this.rows = rows;
        this.cols = cols;
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        Location l = new Location(x,y);
        if(params.length == 1){
            int r = params[0];
            Circle circle= new Circle(l,pattern,r);
            char[][] returned = circle.getGrids();
            for(int i = 0; i < 2 * r; ++i) {
                for (int j = 0; j < 2 * r; ++j) {
                    if (x + i < rows && y + j < cols && x + i >= 0 && y + j >= 0) {
                        if (canvas[x + i][y + j] != ' ' && returned[i][j] != ' ') return false;
                    } else if(returned[i][j] != ' '){
                        return false;
                    }
                }
            }
            for(int i = 0; i < 2 * r; ++i) {
                for (int j = 0; j < 2 * r; ++j) {
                    if (x + i < rows && y + j < cols && x + i >= 0 && y + j >= 0) {
                        canvas[x + i][y + j] = returned[i][j];
                    }
                }
            }
            shapes.add(circle);
            return true;
        } else if(params.length == 3){
            RightTriangle rt;
            int a = params[0];
            int b = params[1];
            switch (params[2]) {
                case 0:
                    rt = new RightTriangle(l, pattern, params[0], params[1], Direction.LEFT_UP);
                    break;
                case 1:
                    rt = new RightTriangle(l, pattern, params[0], params[1], Direction.LEFT_DOWN);
                    break;
                case 2:
                    rt = new RightTriangle(l, pattern, params[0], params[1], Direction.RIGHT_UP);
                    break;
                case 3:
                    rt = new RightTriangle(l, pattern, params[0], params[1], Direction.RIGHT_DOWN);
                    break;
                default:
                    return false;
            }
            char[][] returned = rt.getGrids();
            for(int i = 0; i < b; ++i) {
                for (int j = 0; j < a; ++j) {
                    if (x + i < rows && y + j < cols && x + i >= 0 && y + j >= 0) {
                        if (canvas[x + i][y + j] != ' ' && returned[i][j] != ' ') return false;
                    } else if(returned[i][j] != ' '){
                        return false;
                    }
                }
            }
            for(int i = 0; i < b; ++i) {
                for (int j = 0; j < a; ++j) {
                    if (x + i < rows && y + j < cols && x + i >= 0 && y + j >= 0) {
                        if(returned[i][j] != ' ') canvas[x + i][y + j] = returned[i][j];
                    }
                }
            }
            shapes.add(rt);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount(){
        int sum = 0;
        for(int i = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                if(canvas[i][j] != ' ') sum++;
        return sum;
    }
    public int getShapeCount(){
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea(){
        for (int i = 1; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size() - i; j++) {
                if (shapes.get(j).area() > shapes.get(j+1).area()) {
                    Shape tmp = shapes.get(j);
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, tmp);
                } else if(shapes.get(j).pattern > shapes.get(j+1).pattern && shapes.get(j).area() == shapes.get(j+1).area()){
                    Shape tmp = shapes.get(j);
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, tmp);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation(){
        for (int i = 1; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size() - i; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j+1).location.getX()) {
                    Shape tmp = shapes.get(j);
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, tmp);
                } else if (shapes.get(j).location.getX() == shapes.get(j+1).location.getX() && shapes.get(j).location.getY() > shapes.get(j+1).location.getY()) {
                    Shape tmp = shapes.get(j);
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, tmp);
                } else if (shapes.get(j).location.getX() == shapes.get(j+1).location.getX() && shapes.get(j).location.getY() == shapes.get(j+1).location.getY()&&shapes.get(j).pattern > shapes.get(j+1).pattern) {
                    Shape tmp = shapes.get(j);
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, tmp);
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas(){
        return canvas;
    }

}
