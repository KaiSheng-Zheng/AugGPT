import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    private int rows;
    private int cols;
    private int gsc;
    private int gsgc;
    private Direction dd;
    public AvoidConflictShapeCanvas(int rows, int cols) {

        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.rows=rows;
        this.cols=cols;

    }

    @Override
    public boolean addShape ( int x, int y, char pattern, int...params){
        boolean a=true;
        Location p = new Location(x,y);
        if (params.length == 1) {
            Circle circle = new Circle(p,pattern,params[0]);
            char[][] trydraws = new char[params[0]*2][params[0]*2];
            for (char[] trydraw :trydraws ){
                Arrays.fill(trydraw,pattern);
            }

            if (x + 2 * params[0] > rows||y+2*params[0]>cols){
                a=false;

            }else{

                for (int i = 1; i < params[0]; i++) {
                    for (int j = 1; j <params[0] ; j++) {
                        double length = Math.pow(params[0]-i,2)+Math.pow(params[0]-j,2);
                        int m=i-1;
                        int n=j-1;
                        if(length>=params[0]*params[0]){
                            trydraws[m][n]=' ';
                            trydraws[trydraws.length-m-1][n]=' ';
                            trydraws[m][trydraws.length-n-1]=' ';
                            trydraws[trydraws.length-m-1][trydraws.length-n-1]=' ';
                        }else{
                            break;
                        }
                    }
                }
                for (int i = x; i <x + 2 * params[0] ; i++) {
                    int b = i-x;
                    for (int j = y; j <y+2*params[0] ; j++) {
                        int c = j-y;
                        if(canvas[i][j]!=' '&&trydraws[b][c]!=' '){
                            a = false;

                            break;
                        }
                    }
                }

            }
            if (!a){
                return false;
            }else {
                for (int i = x; i < x+2*params[0]; i++) {
                    int b=i-x;
                    for (int j = y; j < y+2*params[0]; j++) {
                        int c =j-y;
                        if(canvas[i][j]==' '){
                            canvas[i][j]=trydraws[b][c];
                        }
                    }
                }
                gsc++;
                gsgc+=circle.area();
                shapes.add(circle);
                return true;
            }
        }else{

            switch (params[2]){
                case 0:
                    dd=Direction.LEFT_UP;
                    break;
                case 1:
                    dd=Direction.LEFT_DOWN;
                    break;
                case 2:
                    dd=Direction.RIGHT_UP;
                    break;
                case 3:
                    dd=Direction.RIGHT_DOWN;
            }
            RightTriangle rt=new RightTriangle(p,pattern,params[0],params[1],dd);

            if(x+params[1]>rows||y+params[0]>cols){
                a = false;

            }else {
                rt.fillGrids();
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (rt.grids[i][j]!=' '&&canvas[i+x][j+y]!=' '){
                            a=false;
                            break;
                        }
                    }
                }

            }
            if (!a){
                return false;
            }else{
                for (int i = x; i <x+params[1] ; i++) {
                    int b = i-x;
                    for (int j = y; j <y+params[0] ; j++) {
                         int c =j-y;
                         if (canvas[i][j]==' '){
                         canvas[i][j]=rt.grids[b][c];
                         }
                    }
                }
                gsc++;
                gsgc+=rt.area();
                shapes.add(rt);
                return true;
            }
        }

    }

    @Override
    public int getSpaceGridCount() {
        return gsgc;
    }

    @Override
    public int getShapeCount() {
        return gsc;
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape>sss=shapes;
        int n=sss.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(sss.get(j).area()> sss.get(j + 1).area()){
                    Shape t=sss.get(j);
                    sss.set(j, sss.get(j+1));
                    sss.set(j+1,t);
                } else if (sss.get(j).area()==sss.get(j+1).area()) {
                    if (sss.get(j).pattern>sss.get(j+1).pattern){
                        Shape s =sss.get(j);
                        sss.set(j,sss.get(j+1));
                        sss.set(j+1,s);
                    }
                }
            }
        }
        return sss;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape>ss=shapes;
        int n = ss.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(ss.get(j).location.getX()>ss.get(j+1).location.getX()){
                    Shape t = ss.get(j);
                    ss.set(j, ss.get(j+1));
                    ss.set(j+1,t);
                } else if (ss.get(j).location.getX()==ss.get(j+1).location.getX()) {
                    if (ss.get(j).location.getY()>ss.get(j+1).location.getY()){
                        Shape t = ss.get(j);
                        ss.set(j, ss.get(j+1));
                        ss.set(j+1,t);
                    } else if (ss.get(j).location.getY()==ss.get(j+1).location.getY()) {
                        if (ss.get(j).pattern>ss.get(j+1).pattern){
                            Shape t = ss.get(j);
                            ss.set(j, ss.get(j+1));
                            ss.set(j+1,t);
                        }
                    }
                }
            }
        }
        return ss;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}

