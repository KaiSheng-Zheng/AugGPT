import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        this.shapes=new ArrayList<>();
        this.canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if(params.length==1)
            return addCircle(x,y,pattern,params[0]);
        if(params.length==3)
            return addRightTriangle(x,y,pattern,params[0],params[1],params[2]);
        return false;
    }
    public boolean addCircle(int x,int y,char pattern,int radius){
        Location location=new Location(x,y);
        Shape circle=new Circle(location,pattern,radius);
        circle.fillGrids();
        int m;
        int n;
        m=0;
        for (int i = x; i < x+2*radius; i++) {
            n=0;
            for (int j = y; j < y+2*radius; j++) {
                if(i>=canvas.length||j>=canvas[0].length){
                    break;
                }
                if(circle.getGrids()[m][n]!=' ') {
                    canvas[i][j] = circle.getGrids()[m][n];
                }
                n++;
            }
            m++;
        }
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j]==pattern){
                    shapes.add(circle);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean addRightTriangle(int x,int y,char pattern,int width, int height,int direction){
        Location location=new Location(x,y);
        if (direction==0) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.LEFT_UP );
            rectangle.fillGrids();
            int m;
            int n;
            m=0;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(i>=canvas.length||j>=canvas[0].length){
                        break;
                    }
                    if(rectangle.getGrids()[m][n]!=' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                    }
                    n++;
                }
                m++;
            }
            for (int i = 0; i < x+height; i++) {
                for (int j = 0; j < y+width; j++) {
                    if(i>=canvas.length||j>=canvas[0].length){
                        break;
                    }
                    if(canvas[i][j]==pattern){
                        shapes.add(rectangle);
                        return true;
                    }
                }
            }
            return false;
        }
        if (direction==1) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.LEFT_DOWN );
            rectangle.fillGrids();
            int m;
            int n;
            m=0;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(i>=canvas.length||j>=canvas[0].length){
                        break;
                    }
                    if(rectangle.getGrids()[m][n]!=' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                    }
                    n++;
                }
                m++;
            }
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if(canvas[i][j]==pattern){
                        shapes.add(rectangle);
                        return true;
                    }
                }
            }
            return false;
        }
        if (direction==2) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.RIGHT_UP );
            rectangle.fillGrids();
            int m;
            int n;
            m=0;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(i>=canvas.length||j>=canvas[0].length){
                        break;
                    }
                    if(rectangle.getGrids()[m][n]!=' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                    }
                    n++;
                }
                m++;
            }
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if(canvas[i][j]==pattern){
                        shapes.add(rectangle);
                        return true;
                    }
                }
            }
            return false;
        }
        if (direction==3) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.RIGHT_DOWN );
            rectangle.fillGrids();
            int m;
            int n;
            m=0;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(i>=canvas.length||j>=canvas[0].length){
                        break;
                    }
                    if(rectangle.getGrids()[m][n]!=' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                    }
                    n++;
                }
                m++;
            }
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if(canvas[i][j]==pattern){
                        shapes.add(rectangle);
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
    public int getSpaceGridCount(){
        int num=0;
        int rows=this.canvas.length;
        int cols=this.canvas[0].length;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(canvas[i][j]==' ')
                    num=num+1;
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea(){
        List<Shape> newShapes1 = new ArrayList<>(this.shapes);
        Collections.sort(newShapes1, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int areaCompare = Integer.compare(o1.area(), o2.area());
                if (areaCompare != 0) {
                    return areaCompare;
                }
                return Character.compare(o1.pattern, o2.pattern);
            }
        });
        return newShapes1;
    }
    @Override
    public List<Shape> getShapesByLocation(){
        List<Shape> newShapes2 = new ArrayList<>(this.shapes);
        Collections.sort(newShapes2, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int xCompare  = Integer.compare(o1.location.getX(),o2.location.getX());
                if (xCompare!=0){
                    return xCompare;
                }
                int yCompare = Integer.compare(o1.location.getY(),o2.location.getY());
                if(yCompare!=0){
                    return yCompare;
                }
                return Character.compare(o1.pattern, o2.pattern);
            }
        });
        return newShapes2;
    }
    @Override
    public char[][] getCanvas(){
        return canvas;
    }
}