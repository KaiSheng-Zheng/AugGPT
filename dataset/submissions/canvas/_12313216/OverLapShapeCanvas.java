import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    ArrayList<Integer> area =  new ArrayList<>();

    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean flag = false;
        int area = 0;
        if (params.length == 1) {
            Location loc = new Location(x, y);
            Shape newCircle = new Circle(loc,pattern,params[0]);
            if (x < canvas.length && y < canvas[0].length){
                for (int i = 0 ; i < 2 * params[0]; i++) {
                    for (int j = 0; j < 2 * params[0]; j++) {
                        if (newCircle.getGrids()[i][j] != ' '){
                            if (x + i < canvas.length && y + j < canvas[0].length){
                                canvas[x + i][y + j] = newCircle.getGrids()[i][j];
                                flag = true;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < canvas.length; i++){
                for (int j = 0; j < canvas[0].length; j++){
                    if (canvas[i][j] == pattern){
                        area++;
                    }
                }
            }
            this.area.add(area);
            if (flag){
                newCircle.setArea(area);
                shapes.add(newCircle);
                return true;
            }else return false;
        }else if (params.length == 3){
            Direction dir = Direction.LEFT_UP;
            switch (params[2]){
                case 0: {
                    break;
                }
                case 1: {
                    dir = Direction.LEFT_DOWN;
                    break;
                }
                case 2: {
                    dir = Direction.RIGHT_UP;
                    break;
                }
                case 3: {
                    dir = Direction.RIGHT_DOWN;
                    break;
                }
            }
            Location loc = new Location(x, y);
            Shape newRectangle = new RightTriangle(loc,pattern,params[0],params[1],dir);
            if (x < canvas.length && y < canvas[0].length){
                for (int i = 0 ; i < params[1] ; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (newRectangle.getGrids()[i][j] != ' '){
                            if (x + i < canvas.length && y + j < canvas[0].length){
                                this.canvas[x + i][y + j] = newRectangle.getGrids()[i][j];
                                flag = true;
                            }
                        }
                    }
                }
                for (int i = 0; i < shapes.size(); i++){
                    for (int j = 0; j < shapes.size(); j++){
                        if (canvas[i][j] == pattern){
                            area++;
                        }
                    }
                }
                if (flag){
                    newRectangle.setArea(area);
                    shapes.add(newRectangle);
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0 ; i< canvas.length ; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] != ' ') {
                    count++;
                }
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
        for (int i = 0;i < shapes.size();i++){
            for (int j = 0;j < shapes.size() - 1;j++){
                if (shapes.get(j).area() > shapes.get(j+1).area()){
                    Shape bridge = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, bridge);
                }else if (shapes.get(j).area() == shapes.get(j+1).area()){
                    if (shapes.get(j).location.getX() > shapes.get(j + 1).location.getX()){
                        Shape bridge = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, bridge);
                    } else if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX()) {
                        if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                            Shape bridge = shapes.get(j);
                            shapes.set(j, shapes.get(j + 1));
                            shapes.set(j + 1, bridge);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size() - 1; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j + 1).location.getX()){
                    Shape bridge = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, bridge);
                } else if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX()) {
                    if (shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                        Shape bridge = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, bridge);
                    } else if (shapes.get(j).location.getY() == shapes.get(j + 1).location.getY()) {
                        if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                            Shape bridge = shapes.get(j);
                            shapes.set(j, shapes.get(j + 1));
                            shapes.set(j + 1, bridge);
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