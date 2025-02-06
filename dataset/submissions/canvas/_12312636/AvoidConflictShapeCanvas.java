import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
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
        if(x<0||x>=canvas.length||y<0||y>=canvas[0].length){
            return false;
        }
        if(params.length==1)
            return addCircle(x,y,pattern,params[0]);
        if(params.length==3)
            return addRightTriangle(x,y,pattern,params[0],params[1],params[2]);
        return false;
    }
    public boolean addCircle(int x,int y,char pattern,int radius) {
        char[][] copy = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j]=canvas[i][j];
            }
        }
        if(x+2*radius>canvas.length||x<0||y+2*radius>canvas.length||y<0)
            return false;
        Location location=new Location(x,y);
        Shape circle=new Circle(location,pattern,radius);
        circle.fillGrids();
        int m=0;
        int n;
        for (int i = x; i < x+2*radius; i++) {
            n=0;
            for (int j = y; j < y+2*radius; j++) {
                if(canvas[i][j]==' ') {
                    canvas[i][j] = circle.getGrids()[m][n];
                    n++;
                }
                else if(canvas[i][j]!=' '){
                    for (int k = 0; k < x+2*radius; k++) {
                        for (int l = y; l < y+2*radius; l++) {
                            canvas[k][l]=copy[k][l];
                        }
                    }
                    return false;
                }
            }
            m++;
        }
        shapes.add(circle);
        return true;
    }
    public boolean addRightTriangle(int x,int y,char pattern,int width, int height,int direction){
        if (y + width > canvas[0].length || x + height > canvas.length)
            return false;
        char[][] copy = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j]=canvas[i][j];
            }
        }
        Location location=new Location(x,y);
        if (direction==0) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.LEFT_UP );
            rectangle.fillGrids();
            int m=0;
            int n;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(canvas[i][j]==' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]==' '){
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]!=' '){
                        for (int k = 0; k < x+height; k++) {
                            for (int l = y; l < y+width; l++) {
                                canvas[k][l]=copy[k][l];
                            }
                        }
                        return false;
                    }
                }
                m++;
            }
            shapes.add(rectangle);
        }
        if (direction==1) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.LEFT_DOWN );
            rectangle.fillGrids();
            int m=0;
            int n;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(canvas[i][j]==' '&&rectangle.getGrids()[m][n]!=' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]==' '){
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]!=' '){
                        for (int k = 0; k < x+height; k++) {
                            for (int l = y; l < y+width; l++) {
                                canvas[k][l]=copy[k][l];
                            }
                        }
                        return false;
                    }
                }
                m++;
            }
            shapes.add(rectangle);
        }
        if (direction==2) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.RIGHT_UP );
            rectangle.fillGrids();
            int m=0;
            int n;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(canvas[i][j]==' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]==' '){
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]!=' '){
                        for (int k = 0; k < x+height; k++) {
                            for (int l = y; l < y+width; l++) {
                                canvas[k][l]=copy[k][l];
                            }
                        }
                        return false;
                    }
                }
                m++;
            }
            shapes.add(rectangle);
        }
        if (direction==3) {
            Shape rectangle = new RightTriangle(location, pattern, width, height,Direction.RIGHT_DOWN );
            rectangle.fillGrids();
            int m=0;
            int n;
            for (int i = x; i < x+height; i++) {
                n=0;
                for (int j = y; j < y+width; j++) {
                    if(canvas[i][j]==' ') {
                        canvas[i][j] = rectangle.getGrids()[m][n];
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]==' '){
                        n++;
                    }
                    else if(canvas[i][j]!=' '&&rectangle.getGrids()[m][n]!=' '){
                        for (int k = 0; k < x+height; k++) {
                            for (int l = y; l < y+width; l++) {
                                canvas[k][l]=copy[k][l];
                            }
                        }
                        return false;
                    }
                }
                m++;
            }
            shapes.add(rectangle);
        }
        return true;
    }

    @Override
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
