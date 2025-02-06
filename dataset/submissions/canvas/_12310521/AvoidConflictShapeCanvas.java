import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<Shape>();

    }
    public boolean addShape(int x, int y, char pattern, int... params){

        if(params.length==1){

            int radius = params[0];
            Location location = new Location(x,y);
            Circle circle = new Circle(location,pattern,radius);
            char[][] grids = circle.getGrids();

            if (!inCanvas(x,y,2*radius,2*radius)){
                return false;
            }
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {

                    if (grids[i][j]==' '){continue;}

                    if(canvas[x+i][y+j]!=' '){
                        return false;
                    }
                }
            }
            shapes.add(circle);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(grids[i][j]!=' '){
                        canvas[x+i][y+j]=pattern;
                    }
                }
            }
            return true;
        }
        if (params.length==3){
            Location location = new Location(x,y);
            int width = params[0];
            int height = params[1];
            Direction d = null;
            switch (params[2]){
                case 0-> { d = Direction.LEFT_UP;}
                case 1-> { d = Direction.LEFT_DOWN;}
                case 2-> { d = Direction.RIGHT_UP;}
                case 3-> { d = Direction.RIGHT_DOWN;}
            }
            RightTriangle triangle = new RightTriangle(location,pattern,width,height,d);
            char[][] grids = triangle.getGrids();
            if (!inCanvas(x,y,width,height)){
                return false;
            }
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (grids[i][j]==' '){continue;}
                    if(canvas[x+i][y+j]!=' '){
                        return false;
                    }
                }
            }
            shapes.add(triangle);
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(grids[i][j]!=' '){
                        canvas[x+i][y+j]=pattern;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean inCanvas(int x,int y,int width,int height){

        if(x>=0&&x<=canvas.length-1&&x+height-1<=canvas.length-1&&y>=0&&y<=canvas[0].length-1&&y+width-1<=canvas[0].length-1){
            return true;
        }
        return false;
    }
    public int getSpaceGridCount(){
        int space = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==0){
                    space++;
                }
            }
        }
        return space;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        ShapeComparatorByArea comparator= new ShapeComparatorByArea();
        Collections.sort(shapes,comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        ShapeComparatorByLocation comparator= new ShapeComparatorByLocation();
        Collections.sort(shapes,comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
class ShapeComparatorByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.area() > o2.area()) {
            return 1;
        } else if (o1.area() < o2.area()) {
            return -1;
        } else if (o1.pattern > o2.pattern) {
            return 1;
        } else if (o1.pattern < o2.pattern) {
            return -1;
        } else {
            return 0;
        }
    }
}
class ShapeComparatorByLocation implements Comparator<Shape>{

        @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.location.getX() != o2.location.getX()){
            return  o1.location.getX()-o2.location.getX();
        }else if (o1.location.getY() != o2.location.getY()){
            return o1.location.getY()-o2.location.getY();
        }else {
            return o1.pattern - o2.pattern;
        }
    }
}
