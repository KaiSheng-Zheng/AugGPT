import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows , int cols){
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
            if(x + 2 * params[0] > canvas[0].length || y + 2 * params[0] > canvas.length){
                return false;
            }
            for (int j = x ; j < x + 2 * params[0] ; j++){
                for (int i = y ; i < y + 2 * params[0] ; i++){
                    if(canvas[i][j] != ' ' && newShape.getGrids()[i-y][j-x] != ' '){
                        return false;
                    }
                }
            }
            for (int j = x ; j < x + 2 * params[0] ; j++){
                for (int i = y ; i < y + 2 * params[0] ; i++){
                    if(newShape.getGrids()[i-y][j-x] != ' '){
                        canvas[i][j] = newShape.getGrids()[i-y][j-x];
                    }
                }
            }
        }else{
            newShape = new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
            if(x + params[0] > canvas[0].length || y + params[1] > canvas.length){
                return false;
            }
            for (int j = x ; j < x + params[0] ; j++){
                for (int i = y ; i < y + params[1] ; i++){
                    if(canvas[i][j] != ' ' && newShape.getGrids()[i-y][j-x] != ' '){
                        return false;
                    }
                }
            }
            for (int j = x ; j < x + params[0] ; j++){
                for (int i = y ; i < y + params[1] ; i++){
                    if(newShape.getGrids()[i-y][j-x] != ' '){
                        canvas[i][j] = newShape.getGrids()[i-y][j-x];
                    }
                }
            }
        }
        shapes.add(newShape);
        return true;
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
//        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20);
//        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3, 1));
//        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
//        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
//        System.out.println(shapeCanvas.addShape(6,6,'D',5,7,1));
//        System.out.println(shapeCanvas.addShape(0,8,'E',3));
//
//        shapeCanvas.getShapesByArea().forEach(System.out::println);
//        shapeCanvas.getShapesByLocation().forEach(System.out::println);
//
//        for (char[] line:shapeCanvas.getCanvas()) {
//            System.out.println(line);
//        }
//    }
}
