import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private int gsc;
    private int gsgc;
    private Direction dd;
    public OverLapShapeCanvas(int rows, int cols){
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
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean a=false;
        Location p = new Location(x,y);

       if (params.length==1){
           int m=rows;
           int n=cols;
           if (rows>x+2*params[0]){
               m=x+2*params[0];
           }
           if (cols>y+2*params[0]){
               n=y+2*params[0];
           }
           Circle circle = new Circle(p,pattern,params[0]);

           circle.fillGrids();
           for (int i = x; i < m; i++) {
               for (int j = y; j < n; j++) {
                   if (circle.grids[i-x][j-y]!=' '){
                       a=true;
                       break;
                   }
               }
           }
           if (!a){
               return false;
           }else{
               for (int i = x; i <m ; i++) {
                   for (int j = y; j <n ; j++) {
                       if (circle.grids[i-x][j-y]!=' '){
                           canvas[i][j]=circle.grids[i-x][j-y];
                       }
                   }
               }
               gsc++;

               shapes.add(circle);
               return true;
           }
       }else {
           int m=rows;
           int n=cols;
           if (rows>x+params[1]){
               m=x+params[1];
           }
           if (cols>y+params[0]){
               n=y+params[0];
           }
           switch (params[2]) {
               case 0:
                   dd = Direction.LEFT_UP;
                   break;
               case 1:
                   dd = Direction.LEFT_DOWN;
                   break;
               case 2:
                   dd = Direction.RIGHT_UP;
                   break;
               case 3:
                   dd = Direction.RIGHT_DOWN;
           }
           RightTriangle rt = new RightTriangle(p,pattern,params[0],params[1],dd);
           rt.fillGrids();
           for (int i = x; i < m; i++) {
               for (int j = y; j <n ; j++) {
                   if (rt.grids[i-x][j-y]!=' '){
                       a=true;
                       break;
                   }
               }
           }
           if (!a){
               return false;
           }else{
               for (int i = x; i <m ; i++) {
                   for (int j = y; j <n ; j++) {
                       if (rt.grids[i-x][j-y]!=' '){
                           canvas[i][j]=rt.grids[i-x][j-y];
                       }
                   }
               }
               gsc++;

               shapes.add(rt);
               return true;
           }
       }
    }

    @Override
    public int getSpaceGridCount() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]!=' '){
                    gsgc++;
                }
            }
        }
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
