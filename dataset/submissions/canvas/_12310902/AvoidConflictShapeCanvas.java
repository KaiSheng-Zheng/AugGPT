import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private  char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols ){
        shapes=new ArrayList<>();
        canvas= new  char[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < cols; j++) {
               canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

    Location location=new Location(x,y);
    if (params.length==1) {
        Circle circle = new Circle(location, pattern, params[0]);
        char[][] grid = circle.getGrids();
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (y+grid[0].length>canvas[0].length||x+grid.length>canvas.length){
                    return false;
                }
               else if (canvas[x+i][y+j]!=' '&&grid[i][j]!=' '){
                   return false;
                }
            }
        }
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]!=' '){
                    canvas[x+i][y+j]=pattern;
                }

            }
        }
        Circle circle1 = new Circle(location, pattern, params[0],circle.area());
       shapes.add(circle1);
    }
    if (params.length==3){
        Direction d=null;
        if (params[2]==0){
             d=Direction.LEFT_UP;
        }if (params[2]==1){
            d=Direction.LEFT_DOWN;
            }
            if (params[2] == 2) {
                 d=Direction.RIGHT_UP;
            }if (params[2]==3) {
                d = Direction.RIGHT_DOWN;
            }
        RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],d);
            char[][]grid=rightTriangle.getGrids();
            for (int i = 0; i <grid.length ; i++) {
                for (int j = 0; j <grid[0].length ; j++) {
                    if (y+grid[0].length>canvas[0].length||x+grid.length>canvas.length){
                        return false;
                    }
                    else if (canvas[x+i][y+j]!=' '&&grid[i][j]!=' '){
                        return false;
                    }
                }
            }
            for (int i = 0; i <grid.length ; i++) {
                for (int j = 0; j <grid[0].length ; j++) {
                    if (grid[i][j]!=' '){
                        canvas[x+i][y+j]=pattern;
                    }

                }
            }
        RightTriangle rightTriangle1=new RightTriangle(location,pattern,params[0],params[1],d,rightTriangle.area());
            shapes.add(rightTriangle1);
        }
    return true;
    }

    @Override
    public int getSpaceGridCount() {
        return canvas.length*canvas[0].length;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape> customComparator = new Comparator<Shape>() {

            @Override
            public int compare(Shape o1, Shape o2) {
               if (o1.area()!=o2.area()){
                   return Integer.compare(o1.area(),o2.area());
               }else {
                   return Character.compare(o1.pattern,o2.pattern);
               }
            }
        };
    Collections.sort(shapes,customComparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> customComparator = new Comparator<Shape>(){

            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX()!=o2.location.getX()){
                    return Integer.compare(o1.location.getX(),o2.location.getX());
                }else if (o1.location.getY()!=o2.location.getY()){
                    return Integer.compare(o1.location.getY(),o2.location.getY());
                }else {
                    return Character.compare(o1.pattern,o2.pattern);
                }
            }
        };
        Collections.sort(shapes,customComparator);
     return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
