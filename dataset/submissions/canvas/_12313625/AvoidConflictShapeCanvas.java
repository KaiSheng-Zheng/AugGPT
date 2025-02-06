import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        Location l = new Location(x,y);
        boolean out1 = true;
        if(params.length == 1){
            if(x + 2*params[0] < canvas.length & x >= 0){
                if(y + 2*params[0] < canvas[0].length & y >= 0){
                    Circle c = new Circle(l,pattern,params[0]);
                    char[][] g = c.getGrids();
                    for (int i = x; i < x + 2*params[0]; i++) {
                        for (int j = y; j < y + 2*params[0]; j++) {
                            if(canvas[i][j] != ' '){
                                if(g[i - x][j - y] != ' '){
                                    out1 =false;
                                    break;
                                }
                            }
                        }
                    }
                    if(out1 == true){
                        this.shapes.add(c);
                        for (int i = x; i < x + 2*params[0]; i++) {
                            for (int j = y; j < y + 2*params[0]; j++) {
                                if(canvas[i][j] == ' '){
                                    canvas[i][j] = g[i - x][j - y];
                                }
                            }
                        }
                    }
                }else out1 = false;
            }else out1 = false;
        }else if(params.length == 3){
            if(x >= 0 & x + params[1] <= canvas.length){
                if(y + params[0] <= canvas[0].length & y >= 0){
                    if(params[2] == 0){
                        RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.LEFT_UP);
                        char[][] g = r.getGrids();
                        for (int i = x ; i < x + params[1]; i++) {
                            for (int j = y; j < y + params[0]; j++) {
                                if(canvas[i][j] != ' '){
                                    if(g[i - x][j - y] != ' '){
                                        out1 =false;
                                        break;
                                    }
                                }
                            }
                        }
                        if(out1 == true){
                            this.shapes.add(r);
                            for (int i = x ; i < x + params[1]; i++) {
                                for (int j = y; j < y + params[0]; j++) {
                                    if(canvas[i][j] == ' '){
                                        canvas[i][j] = g[i - x][j - y];
                                    }
                                }
                            }
                        }
                    } else if (params[2] == 1) {
                        RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.LEFT_DOWN);
                        char[][] g = r.getGrids();
                        for (int i = x ; i < x + params[1]; i++) {
                            for (int j = y; j < y + params[0]; j++) {
                                if(canvas[i][j] != ' '){
                                    if(g[i - x][j - y] != ' '){
                                        out1 =false;
                                        break;
                                    }
                                }
                            }
                        }
                        if(out1 == true){
                            this.shapes.add(r);
                            for (int i = x ; i < x + params[1]; i++) {
                                for (int j = y; j < y + params[0]; j++) {
                                    if(canvas[i][j] == ' '){
                                        canvas[i][j] = g[i - x][j - y];
                                    }
                                }
                            }
                        }
                    } else if (params[2] == 2) {
                        RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.RIGHT_UP);
                        char[][] g = r.getGrids();
                        for (int i = x ; i < x + params[1]; i++) {
                            for (int j = y; j < y + params[0]; j++) {
                                if(canvas[i][j] != ' '){
                                    if(g[i - x][j - y] != ' '){
                                        out1 =false;
                                        break;
                                    }
                                }
                            }
                        }
                        if(out1 == true){
                            this.shapes.add(r);
                            for (int i = x ; i < x + params[1]; i++) {
                                for (int j = y; j < y + params[0]; j++) {
                                    if(canvas[i][j] == ' '){
                                        canvas[i][j] = g[i - x][j - y];
                                    }
                                }
                            }
                        }
                    } else if (params[2] == 3) {
                        RightTriangle r = new RightTriangle(l,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                        char[][] g = r.getGrids();
                        for (int i = x ; i < x + params[1]; i++) {
                            for (int j = y; j < y + params[0]; j++) {
                                if(canvas[i][j] != ' '){
                                    if(g[i - x][j - y] != ' '){
                                        out1 =false;
                                        break;
                                    }
                                }
                            }
                        }
                        if(out1 == true){
                            this.shapes.add(r);
                            for (int i = x ; i < x + params[1]; i++) {
                                for (int j = y; j < y + params[0]; j++) {
                                    if(canvas[i][j] == ' '){
                                        canvas[i][j] = g[i - x][j - y];
                                    }
                                }
                            }
                        }
                    }
                }else out1 = false;
            }else out1 = false;
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
        int i = this.shapes.size();
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
