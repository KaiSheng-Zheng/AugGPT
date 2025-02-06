import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private List<Integer> areaList;
    private List<Integer> locationList;
    private char[][] canvas;
     int rows;
     int cols;
     int shapeCount = 0;
    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);
        if (params.length == 1){//circle
            int test1=0;
            int radius = params[0];
            int height = radius*2;
            int width = radius*2;
            Circle circle = new Circle(location,pattern,radius);
            //add pattern
            for (int i = x; i < x+height&&i<rows; i++) {
                for (int j = y; j < y+width&&j<cols; j++) {//canvas not empty,only pattern can overlap
                    if (canvas[i][j] != ' ' && circle.grids[i - x][j - y] != ' ') {
                        canvas[i][j] = circle.grids[i - x][j - y];
                        test1++;
                    }
                    if (canvas[i][j] == ' ' && circle.grids[i - x][j - y] != ' ') {
                        canvas[i][j] = circle.grids[i - x][j - y];
                        test1++;
                    }
                }
            }
            if (test1==0){
                return false;
            }
            shapes.add(circle);
        }

        if(params.length == 3){
            int test2 = 0;
            int height = params[1];
            int width =params[0];
            Direction d = null ;
            if (params[2]==0) d = Direction.LEFT_UP;
            if (params[2]==1) d = Direction.LEFT_DOWN;
            if (params[2]==2) d = Direction.RIGHT_UP;
            if (params[2]==3) d = Direction.RIGHT_DOWN;
            RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,d);

            //add pattern
            for (int i = x; i < x+height&&i<rows; i++) {
                for (int j = y; j < y+width&&j<cols; j++) {//canvas not empty,only pattern can overlap
                    if (canvas[i][j] != ' ' && rightTriangle.grids[i - x][j - y] != ' ') {
                        canvas[i][j] = rightTriangle.grids[i - x][j - y];
                        test2++;
                    }
                    if (canvas[i][j] == ' ' && rightTriangle.grids[i - x][j - y] != ' ') {
                        canvas[i][j] = rightTriangle.grids[i - x][j - y];
                        test2++;
                    }
                }
            }
            if (test2==0){
                return false;
            }
            shapes.add(rightTriangle);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]==' '){
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area()!=s2.area()) {
                    return Integer.compare(s1.area(), s2.area());
                }
                else {
                    return Integer.compare(s1.pattern, s2.pattern);
                }
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX()){
                    return Integer.compare(s1.location.getX(),s2.location.getX());
                } else if (s1.location.getX() == s2.location.getX()&&s1.location.getY() != s2.location.getY()) {
                    return Integer.compare(s1.location.getY(),s2.location.getY());
                }else {
                    return Integer.compare(s1.pattern, s2.pattern);
                }
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
