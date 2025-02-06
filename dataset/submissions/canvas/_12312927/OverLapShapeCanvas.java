import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows , int cols){
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int y, int x, char pattern, int... params) {
        if(y > canvas.length || x > canvas[0].length || y < 0 || x < 0){
            return false;
        }
        Location location = new Location(x,y);
        Shape newShape;
        if(params.length == 1){
            newShape = new Circle(location,pattern,params[0]);
            boolean isMoved = false;
            for (int j = x ; j < x + 2 * params[0] ; j++){
                for (int i = y ; i < y + 2 * params[0] ; i++){
                    if(newShape.getGrids()[i-y][j-x] != ' ' && isInBound(j , i , canvas[0].length , canvas.length)){
                        isMoved = true;
                        canvas[i][j] = newShape.getGrids()[i-y][j-x];
                    }
                }
            }
            if(!isMoved){
                return false;
            }
        }else{
            newShape = new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
            boolean isMoved = false;
            for (int j = x ; j < x + params[0] ; j++){
                for (int i = y ; i < y + params[1] ; i++){
                    if(newShape.getGrids()[i-y][j-x] != ' ' && isInBound(j , i , canvas[0].length , canvas.length)){
                        canvas[i][j] = newShape.getGrids()[i-y][j-x];
                        isMoved = true;
                    }
                }
            }
            if(!isMoved){
                return false;
            }
        }
        shapes.add(newShape);
        return true;
    }
    private boolean isInBound(int x , int y , int X , int Y){
        if(x >= 0 && x < X && y >= 0 && y < Y){
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0 ;
        for (int i = 0 ; i < canvas.length ; i ++){
            for (int j = 0 ; j < canvas[i].length ; j++){
                if(canvas[i][j] == ' '){
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
        ArrayList<Shape> queueShape = new ArrayList<>() , formerShape;
        formerShape = new ArrayList<>(shapes);
        while(!formerShape.isEmpty()){
            int area = formerShape.get(0).area();
            char pattern = formerShape.get(0).pattern;
            Shape defaultShape = formerShape.get(0);
            for(Shape shape : formerShape){
                if (shape.area() < area){
                    defaultShape = shape;
                    area = shape.area();
                    pattern = shape.pattern;
                } else if (shape.area() == area && shape.pattern < pattern) {
                    defaultShape = shape;
                    area = shape.area();
                    pattern = shape.pattern;
                }
            }
            queueShape.add(defaultShape);
            formerShape.remove(defaultShape);
        }
        return queueShape;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        ArrayList<Shape> queueShape = new ArrayList<>() , formerShape;
        formerShape = new ArrayList<>(shapes);
        while(!formerShape.isEmpty()){
            int x = formerShape.get(0).location.getX() , y = formerShape.get(0).location.getY();
            char pattern = formerShape.get(0).pattern;
            Shape defaultShape = formerShape.get(0);
            for(Shape shape : formerShape){
                if (shape.location.getX() < x){
                    x = shape.location.getX();
                    y = shape.location.getY();
                    pattern = shape.pattern;
                    defaultShape = shape;
                } else if (shape.location.getX() == x && shape.location.getY() < y) {
                    x = shape.location.getX();
                    y = shape.location.getY();
                    pattern = shape.pattern;
                    defaultShape = shape;
                } else if (shape.location.getY() == y && shape.pattern < pattern) {
                    x = shape.location.getX();
                    y = shape.location.getY();
                    pattern = shape.pattern;
                    defaultShape = shape;
                }
            }
            queueShape.add(defaultShape);
            formerShape.remove(defaultShape);
        }
        return queueShape;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
//    public static void main(String[] args) {
//        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
//        canvas1.addShape(0, 0, 'A', 6);
//        canvas1.addShape(1, 1, 'B', 5);
//        canvas1.addShape(2, 2, 'C', 4);
//        canvas1.addShape(3, 3, 'D', 3);
//        canvas1.addShape(10, 5, 'E', 4, 6, 2);
//        canvas1.addShape(14, 14, 'F', 4, 6, 3);
//        canvas1.addShape(10, 5, '0', 3, 2, 1);
//        canvas1.addShape(10, 5, '1', 1, 1, 2);
//        for (char[] line : canvas1.getCanvas()) {
//            System.out.println(line);
//        }
//        System.out.println(canvas1.getShapeCount());
//        System.out.println(canvas1.getSpaceGridCount());
//        canvas1.getShapesByArea().forEach(System.out::println);
//        canvas1.getShapesByLocation().forEach(System.out::println);
//    }
}
