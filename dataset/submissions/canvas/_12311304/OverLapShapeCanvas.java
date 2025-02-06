import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1){
            Shape circle = new Circle(location, pattern, params[0]);
            char[][] shape = circle.getGrids();
            boolean flag = false;
            for (int i = 0; i < shape.length; i++) {
                for (int j = 0; j < shape[0].length; j++) {
                    if (shape[i][j] != ' ' && i + x >= 0 && i + x < canvas.length
                    && j + y > 0 && j + y < canvas[0].length){
                        flag = true;
                        canvas[i + x][j + y] = shape[i][j];
                    }
                }
            }if (!flag){
                return false;
            }else {
                shapes.add(circle);
                return true;
            }
        }else {
            Direction[] directions = {Direction.LEFT_UP, Direction.LEFT_DOWN, Direction.RIGHT_UP, Direction.RIGHT_DOWN};
            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], directions[params[2]]);
            char [][] shape = rightTriangle.getGrids();
            boolean flag = false;
            for (int i = 0; i < shape.length; i++) {
                for (int j = 0; j < shape[0].length; j++) {
                    if (shape[i][j] != ' ' && i + x >= 0 && i + x < canvas.length
                            && j + y >= 0 && j + y < canvas[0].length){
                        flag = true;
                        canvas[i + x][j + y] = shape[i][j];
                    }
                }
            }if (!flag){
                return false;
            }else {
                shapes.add(rightTriangle);
                return true;
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int cnt = 0;
        for (int i = 0; i < canvas.length; i ++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' '){
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = shapes.size(); i > 1; i--) {
            for (int j = shapes.size() - 1; j > shapes.size() - i; j--){
                if (shapes.get(j - 1).area() > shapes.get(j).area()){
                    Shape c = shapes.get(j);
                    shapes.remove(j);
                    shapes.add(j - 1, c);
                } else if (shapes.get(j - 1).area() == shapes.get(j).area()) {
                    if (shapes.get(j - 1).pattern > shapes.get(j).pattern){
                        Shape c = shapes.get(j);
                        shapes.remove(j);
                        shapes.add(j - 1, c);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = shapes.size(); i > 1; i--) {
            for (int j = shapes.size() - 1; j > shapes.size() - i; j--){
                if (shapes.get(j - 1).location.getX() > shapes.get(j).location.getX()){
                    Shape c = shapes.get(j);
                    shapes.remove(j);
                    shapes.add(j - 1, c);
                } else if (shapes.get(j - 1).location.getX() == shapes.get(j).location.getX()) {
                    if (shapes.get(j - 1).location.getY() > shapes.get(j).location.getY()){
                        Shape c = shapes.get(j);
                        shapes.remove(j);
                        shapes.add(j - 1, c);
                    } else if (shapes.get(j - 1).location.getY() == shapes.get(j).location.getY()) {
                        if (shapes.get(j - 1).pattern > shapes.get(j).pattern){
                            Shape c = shapes.get(j);
                            shapes.remove(j);
                            shapes.add(j - 1, c);
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
