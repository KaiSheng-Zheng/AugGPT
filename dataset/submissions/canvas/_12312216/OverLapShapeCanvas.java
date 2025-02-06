import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
            Circle circle= new Circle(new Location(x, y), pattern, params[0]);
            boolean check = false;
            for (int i=0; i<params[0]*2; i++){
                for (int j=0; j<params[0]*2; j++){
                    if (x+i>=0 & x+i<canvas.length & y+j>=0 & y+j<canvas[0].length){
                        if (circle.getGrids()[i][j]!=' ') {
                            check = true;
                            canvas[x+i][y+j]=pattern;
                        }
                    }
                }
            }
            if (check){
                shapes.add(circle);
            }else{
                return false;
            }
        }else if (params.length==3) {
            RightTriangle triangle= new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            boolean check = false;

            for (int i=0; i<params[1]; i++){
                for (int j=0; j<params[0]; j++){
                    if (x+i>=0 & x+i<canvas.length & y+j>=0 & y+j<canvas[0].length){
                        if (triangle.getGrids()[i][j]!=' ') {
                            check = true;
                            canvas[x+i][y+j]=pattern;
                        }
                    }
                }
            }
            if (check){
                shapes.add(triangle);
            }else{
                return false;
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
