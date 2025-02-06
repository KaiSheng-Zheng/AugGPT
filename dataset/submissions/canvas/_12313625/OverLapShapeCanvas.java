import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows,int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x,int y,char pattern,int... params){
        Location l = new Location(x,y);
        boolean out1 = false;
        if(params.length == 1){
            Circle c = new Circle(l,pattern,params[0]);
            char[][] g = c.getGrids();
            for (int i = x; i < x + 2*params[0]; i++) {
                for (int j = y; j < y + 2*params[0]; j++) {
                    if(g[i - x][j - y] != ' '){
                        if(i < canvas.length & i >= 0 & j < canvas[0].length & j >= 0){
                            canvas[i][j] = g[i - x][j - y];
                            out1 = true;
                        }
                    }
                }
            }
            if(out1 == true){
                shapes.add(c);
            }
        }else if(params.length == 3){
            if(params[2] == 0){
                RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.LEFT_UP);
                char[][] g = r.getGrids();
                for (int i = x ; i < x + params[1]; i++) {
                    for (int j = y; j < y + params[0]; j++) {
                        if(g[i - x][j - y] != ' '){
                            if(i < canvas.length & i >= 0 & j < canvas[0].length & j >= 0){
                                canvas[i][j] = g[i - x][j - y];
                                out1 = true;
                            }
                        }
                    }
                }
                if(out1 == true){
                    shapes.add(r);
                }
            } else if (params[2] == 1) {
                RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.LEFT_DOWN);
                char[][] g = r.getGrids();
                for (int i = x ; i < x + params[1]; i++) {
                    for (int j = y; j < y + params[0]; j++) {
                        if(g[i - x][j - y] != ' '){
                            if(i < canvas.length & i >= 0 & j < canvas[0].length & j >= 0){
                                canvas[i][j] = g[i - x][j - y];
                                out1 = true;
                            }
                        }
                    }
                }
                if(out1 == true){
                    shapes.add(r);
                }
            } else if (params[2] == 2) {
                RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.RIGHT_UP);
                char[][] g = r.getGrids();
                for (int i = x ; i < x + params[1]; i++) {
                    for (int j = y; j < y + params[0]; j++) {
                        if(g[i - x][j - y] != ' '){
                            if(i < canvas.length & i >= 0 & j < canvas[0].length & j >= 0){
                                canvas[i][j] = g[i - x][j - y];
                                out1 = true;
                            }
                        }
                    }
                }
                if(out1 == true){
                    shapes.add(r);
                }
            } else if (params[2] == 3) {
                RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                char[][] g = r.getGrids();
                for (int i = x ; i < x + params[1]; i++) {
                    for (int j = y; j < y + params[0]; j++) {
                        if(g[i - x][j - y] != ' '){
                            if(i < canvas.length & i >= 0 & j < canvas[0].length & j >= 0){
                                canvas[i][j] = g[i - x][j - y];
                                out1 = true;
                            }
                        }
                    }
                }
                if(out1 == true){
                    shapes.add(r);
                }
            }
        }
        return out1;
    }
    @Override
    public int getSpaceGridCount(){
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j] != ' '){
                    count++;
                }
            }
        }
        return count;
    }
    @Override
    public int getShapeCount(){
        int i = shapes.size();
        return i;
    }
    @Override
    public List<Shape>getShapesByArea(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.area() == o2.area()){
                    return (int)o1.pattern-(int)o2.pattern;
                }else return o1.area()- o2.area();
            }
        });
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.location.getX() == o2.location.getX()){
                    if(o1.location.getY() == o2.location.getY()){
                        return (int)o1.pattern-(int) o2.pattern;
                    }else return o1.location.getY() - o2.location.getY();
                }else return o1.location.getX() - o2.location.getX();
            }
        });
        return shapes;
    }
    @Override
    public char[][] getCanvas(){
        return canvas;
    }
}
