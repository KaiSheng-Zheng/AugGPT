import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
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
        if (params.length==1){
            int r = params[0];
            Location l = new Location(x,y);
            Circle c = new Circle(l,pattern,r);
            for (int i = 0; i < 2*r; i++) {
                for (int j = 0; j < 2*r; j++) {
                    if (c.grids[i][j]==pattern){
                        if (i+x<canvas.length&&y+j<canvas[0].length){
                            shapes.add(c);
                            for (int k = 0; k < 2*r; k++) {
                                for (int m = 0; m < 2*r; m++) {
                                    if (c.grids[k][m]==pattern){
                                        if (k+x<canvas.length&&m+y<canvas[0].length){
                                            canvas[k+x][m+y] = c.grids[k][m];
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        else{
            int w = params[0];
            int h = params[1];
            Direction[] direction = Direction.values();
            Direction d = direction[params[2]];
            Location l = new Location(x,y);
            RightTriangle rt = new RightTriangle(l,pattern,w,h,d);
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (rt.grids[j][i] == pattern){
                        if (x+j<canvas.length&&y+i<canvas[0].length){
                            shapes.add(rt);
                            for (int k = 0; k < h; k++) {
                                for (int m = 0; m < w; m++) {
                                    if (rt.grids[k][m] == pattern){
                                        if (k+x<canvas.length&&m+y<canvas[0].length){
                                            canvas[k+x][m+y] = rt.grids[k][m];
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
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
