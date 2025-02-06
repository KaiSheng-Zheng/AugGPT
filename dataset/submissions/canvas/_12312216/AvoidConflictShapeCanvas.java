import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i=0; i<canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length==1) {
            if (x<0 |y<0 | x+2*params[0]-1>=canvas.length | y+2*params[0]-1>=canvas[0].length) {
                return false;
            }else{
                Circle circle= new Circle(new Location(x, y), pattern, params[0]);
                boolean check = true;
                loop:
                for (int i=0; i<params[0]*2; i++){
                    for (int j=0; j<params[0]*2; j++){
                        if (canvas[x+i][y+j]!=' '&circle.getGrids()[i][j]==pattern){
                            check = false;
                            break loop;
                        }
                    }
                }
                if (check){
                    shapes.add(circle);
                    for (int i=0; i<params[0]*2; i++){
                        for (int j=0; j<params[0]*2; j++){
                            if (circle.getGrids()[i][j]==pattern){
                                canvas[x+i][y+j]=pattern;
                            }
                        }
                    }
                }else{
                    return false;
                }
            }
        }else if (params.length==3) {
            if (x<0 |y<0 | x+params[1]-1>=canvas.length | y+params[0]-1>=canvas[0].length) {
                return false;
            }else{
                RightTriangle triangle= new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
                boolean check = true;
                loop:
                for (int i=0; i<params[1]; i++){
                    for (int j=0; j<params[0]; j++){
                        if (canvas[x+i][y+j]!=' '&triangle.getGrids()[i][j]==pattern){
                            check = false;
                            break loop;
                        }
                    }
                }
                if (check){
                    shapes.add(triangle);
                    for (int i=0; i<params[1]; i++){
                        for (int j=0; j<params[0]; j++){
                            if (triangle.getGrids()[i][j]==pattern){
                                canvas[x+i][y+j]=pattern;
                            }
                        }
                    }
                }else{
                    return false;
                }
            }
        }

        return true;
    }
    @Override
    public int getSpaceGridCount(){
        int count = 0;
        for (int i=0; i<canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    @Override
    public int getShapeCount(){
        return shapes.size();
    }
    @Override
    public List<Shape> getShapesByArea(){
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j <shapes.size() - i - 1; j++) {
                if (shapes .get(j).area() > shapes .get(j+1).area()) {
                    Shape temp = shapes .get(j);
                    shapes .set(j, shapes .get(j+1));
                    shapes .set(j+1, temp);
                }else if (shapes .get(j).area() == shapes.get(j + 1).area()) {
                    if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                        Shape temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation(){
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j <shapes.size() - i - 1; j++) {
                if (shapes.get(j).location.getX() > shapes .get(j+1).location.getX()) {
                    Shape temp = shapes .get(j);
                    shapes .set(j, shapes .get(j+1));
                    shapes .set(j+1, temp);
                }else if (shapes.get(j).location.getX() == shapes .get(j+1).location.getX()) {
                    if (shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                        Shape temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    } else if (shapes.get(j).location.getY() == shapes.get(j + 1).location.getY()) {
                        if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                            Shape temp = shapes.get(j);
                            shapes.set(j, shapes.get(j + 1));
                            shapes.set(j + 1, temp);
                        }
                    }
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

