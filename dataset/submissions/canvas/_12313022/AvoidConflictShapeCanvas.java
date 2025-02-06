import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean flag=true;
        Direction d = Direction.LEFT_UP;
        if(params.length==3) {
            if (params[2] == 0) {
                 d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                 d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                 d = Direction.RIGHT_UP;
            } else {
                 d = Direction.RIGHT_DOWN;
            }
        }
        if(params.length==3){
            if(x+params[1]>canvas.length||y+params[0]>canvas[0].length){
                return  false;
            }
        }else{
            if(x+params[0]*2>canvas.length||y+params[0]*2>canvas[0].length){
                return  false;
            }
        }
        if(params.length==3){
            RightTriangle RT = new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
            char[][] grids = RT.grids;
            for(int i = x;i<x+params[1];i++){
                for(int j=y;j<y+params[0];j++){
                    if(canvas[i][j]!=' '&&grids[i-x][j-y]!=' '){
                        flag=false;
                    }
                }
            }
        }else{
            Circle c = new Circle(new Location(x,y),pattern,params[0]);
            char[][] grids = c.grids;
            for(int i = x;i<x+grids.length;i++){
                for(int j=y;j<y+grids.length;j++){
                    if(canvas[i][j]!=' '&&grids[i-x][j-y]!=' '){
                        flag=false;
                    }
                }
            }
        }
        if(flag==false){
            return false;
        }
        if(params.length==3){
            RightTriangle RT = new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
            char[][] grids = RT.grids;
            for(int i = x;i<x+params[1];i++){
                for(int j=y;j<y+params[0];j++){
                    if(grids[i-x][j-y]==pattern){
                        canvas[i][j]=grids[i-x][j-y];
                    }
                }
            }
            shapes.add(RT);
        }else{
            Circle c = new Circle(new Location(x,y),pattern,params[0]);
            char[][] grids = c.grids;
            for(int i = x;i<x+params[0]*2;i++){
                for(int j=y;j<y+params[0]*2;j++){
                    if(grids[i-x][j-y]==pattern){
                        canvas[i][j]=grids[i-x][j-y];
                    }
                }
            }
            shapes.add(c);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for(int i=0;i<canvas.length;i++){
            for(int j=0;j<canvas[i].length;j++){
                if(canvas[i][j]==' '){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for(int i=0;i<shapes.size()-1;i++){
            for(int j=1;j<shapes.size();j++){
                if(shapes.get(j-1).area()>shapes.get(j).area()){
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j - 1));
                    shapes.set(j - 1, temp);
                }else if(shapes.get(j-1).area()==shapes.get(j).area()){
                    int unicode_i = (int) shapes.get(j-1).pattern;
                    int unicode_j = (int) shapes.get(j).pattern;
                    if(unicode_i>unicode_j){
                        Shape temp = shapes.get(j);
                        shapes.set(j, shapes.get(j - 1));
                        shapes.set(j - 1, temp);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for(int i=0;i<shapes.size()-1;i++){
            for(int j=1;j<shapes.size();j++){
                if(shapes.get(j-1).location.getX()>shapes.get(j).location.getX()){
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j - 1));
                    shapes.set(j - 1, temp);
                }else if(shapes.get(j-1).location.getX()==shapes.get(j).location.getX()){
                   if(shapes.get(j-1).location.getY()>shapes.get(j).location.getY()){
                       Shape temp = shapes.get(j);
                       shapes.set(j, shapes.get(j - 1));
                       shapes.set(j - 1, temp);
                   }else if(shapes.get(j-1).location.getY()==shapes.get(j).location.getY()){
                       int unicode_i = (int) shapes.get(j-1).pattern;
                       int unicode_j = (int) shapes.get(j).pattern;
                       if(unicode_i>unicode_j){
                           Shape temp = shapes.get(j);
                           shapes.set(j, shapes.get(j - 1));
                           shapes.set(j - 1, temp);
                       }
                   }
                }
            }
        }
        return shapes;
    }

    public char[][] getCanvas() {
        return canvas;
    }

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }

    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }

}
