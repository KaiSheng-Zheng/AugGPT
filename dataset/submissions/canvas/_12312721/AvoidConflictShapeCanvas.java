import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]= ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length ==1){
            int r = params[0];
            if (x+2*r<=canvas.length&&y+2*r<=canvas[0].length){
                    Location l = new Location(x,y);
                    Circle c = new Circle(l,pattern,r);
                    for (int i = x; i < x+2*r; i++) {
                        for (int j = y; j < y+2*r; j++) {
                            if (canvas[i][j]!=' '){
                                return false;
                            }
                        }
                    }int n = 0;
                    for (int i = x; i < x+2*r; i++) {
                        int m = 0;
                        for (int j = y; j < y+2*r; j++) {
                            canvas[i][j] = c.grids[n][m];
                            m++;
                        }
                        n++;
                    }
                    shapes.add(c);
                    return true;
            }
            else{
                return false;
            }
        }
        else{
            int w = params[0];
            int h = params[1];
            Direction[] direction = Direction.values();
            Direction d = direction[params[2]];
            Location l = new Location(x,y);
            RightTriangle rt = new RightTriangle(l,pattern,w,h,d);
            if (x+h<=canvas.length&&y+w<=canvas[0].length){
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        if (rt.grids[j][i] == pattern){
                            if (canvas[x+j][y+i] != ' ') {
                                return false;
                            }
                        }
                    }
                }
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        if (rt.grids[j][i]!=' ')
                       canvas[x+j][y+i] = rt.grids[j][i];
                    }
                }
                shapes.add(rt);
                return true;
            }
            else{
                return false;
            }
        }
    }
    public int getSpaceGridCount(){
        int n =0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]== ' '){
                    n++;
                }
            }
        }
        return n;
    }
    public int getShapeCount(){
        int n =shapes.size();
        return n;
    }

    public List<Shape> getShapesByArea(){
        for (int j = 0; j < shapes.size(); j++) {
            for (int e = 0; e < shapes.size()-1; e++) {
                if (shapes.get(e).area()>shapes.get(e+1).area()) {
                    Shape temp = shapes.get(e);
                    shapes.set(e,shapes.get(e+1));
                    shapes.set(e+1,temp);
                }
                if (shapes.get(e).area()==shapes.get(e+1).area()) {
                    if (shapes.get(e).pattern>shapes.get(e+1).pattern){
                        Shape temp = shapes.get(e);
                        shapes.set(e,shapes.get(e+1));
                        shapes.set(e+1,temp);
                    }
                }
            }
        }
        return shapes;
    }

    public List<Shape> getShapesByLocation(){
        for (int j = 0; j < shapes.size(); j++) {
            for (int e = 0; e < shapes.size()-1; e++) {
                if (shapes.get(e).location.getX()>shapes.get(e+1).location.getX()) {
                    Shape temp = shapes.get(e);
                    shapes.set(e,shapes.get(e+1));
                    shapes.set(e+1,temp);
                }
                if (shapes.get(e).location.getX()==shapes.get(e+1).location.getX()) {
                    if (shapes.get(e).location.getY()>shapes.get(e+1).location.getY()){
                        Shape temp = shapes.get(e);
                        shapes.set(e,shapes.get(e+1));
                        shapes.set(e+1,temp);
                    }
                    if (shapes.get(e).location.getY()==shapes.get(e+1).location.getY()) {
                        if (shapes.get(e).pattern>shapes.get(e+1).pattern){
                            Shape temp = shapes.get(e);
                            shapes.set(e,shapes.get(e+1));
                            shapes.set(e+1,temp);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    public char[][] getCanvas(){
        return canvas;
    }

}
