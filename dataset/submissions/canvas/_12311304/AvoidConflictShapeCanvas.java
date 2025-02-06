import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
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
            if (x < 0 || y < 0 || x + params[0] * 2 > canvas.length
                    || y + params[0] * 2 > canvas[0].length){
                return false;
            }else {
                char[][] shape = circle.getGrids();
                char[][] copyCanvas = new char[canvas.length][canvas[0].length];
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        copyCanvas[i][j] = ' ';
                    }
                }
                for (int i = x; i < x + shape.length; i++){
                    for (int j = y; j < y + shape[0].length; j ++){
                        copyCanvas[i][j] = shape[i - x][j - y];
                    }
                }
                for (int i = 0; i < canvas.length; i ++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (canvas[i][j] != ' ' &&  copyCanvas[i][j] != ' '){
                            return false;
                        }
                    }
                }
                shapes.add(circle);
                for (int i = 0; i < canvas.length; i ++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (copyCanvas[i][j] != ' '){
                            canvas[i][j] = copyCanvas[i][j];
                        }
                    }
                }
                return true;
            }
        }else {
            Direction[] directions = {Direction.LEFT_UP, Direction.LEFT_DOWN, Direction.RIGHT_UP, Direction.RIGHT_DOWN};
            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], directions[params[2]]);
            if (x < 0 || y < 0 || x + params[1] > canvas.length
                    || y + params[0] > canvas[0].length) {
                return false;
            } else {
                char[][] shape = rightTriangle.getGrids();
                char[][] copyCanvas = new char[canvas.length][canvas[0].length];
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        copyCanvas[i][j] = ' ';
                    }
                }
                for (int i = x; i < x + shape.length; i++) {
                    for (int j = y; j < y + shape[0].length; j++) {
                        copyCanvas[i][j] = shape[i - x][j - y];
                    }
                }
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (canvas[i][j] != ' ' && copyCanvas[i][j] != ' ') {
                            return false;
                        }
                    }
                }
                shapes.add(rightTriangle);
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (copyCanvas[i][j] != ' '){
                            canvas[i][j] = copyCanvas[i][j];
                        }
                    }
                }
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
