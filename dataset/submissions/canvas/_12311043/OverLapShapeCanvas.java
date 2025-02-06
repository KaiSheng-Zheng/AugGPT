import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        if(x<0||y<0){
            return false;
        }
        char[][] temp_canvas=new char[canvas.length][canvas[0].length];
        for(int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                temp_canvas[i][j]=canvas[i][j];
            }
        }
        Shape S;
        if(params.length==1){
            S=new Circle(new Location(x,y),pattern,params[0]);

        }
        else {
            switch (params[2]){
                case 0:
                    S=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_UP);
                    break;
                case 1:
                    S=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_DOWN);
                    break;
                case 2:
                    S=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_UP);
                    break;
                case 3:
                    S=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    break;
                default:S=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_UP);
            }
        }
        boolean condition=false;
        for(int i=0;i<S.grids.length;i++){
            for(int j=0;j<S.grids[i].length;j++){
                if(S.grids[i][j]!=' '){
                    if(i+x>=0&&i+x<canvas.length&&j+y>=0&&j+y<canvas[0].length){
                        condition=true;
                        temp_canvas[i+x][j+y]=pattern;
                    }
                }
            }
        }
        if(!condition){
            return false;
        }
        for(int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                canvas[i][j]=temp_canvas[i][j];
            }
        }
        shapes.add(S);
        return true;
    }
    public int getSpaceGridCount(){
        int count=0;
        for(int i=0;i<canvas.length;i++){
            for(int j=0;j<canvas[0].length;j++){
                if(canvas[i][j]==' '){
                    count++;
                }
            }
        }
        return count;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        for(int i=0;i<shapes.size();i++){
            for(int j=0;j<shapes.size()-1-i;j++){
                if(shapes.get(j).area()>shapes.get(j+1).area()){
                    Collections.swap(shapes, j, j+1);
                } else if (shapes.get(j).area()==shapes.get(j+1).area()) {
                    if(shapes.get(j).pattern>shapes.get(j+1).pattern){
                        Collections.swap(shapes, j, j+1);
                    }
                }
            }
        }
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        for(int i=0;i<shapes.size();i++){
            for(int j=0;j<shapes.size()-1-i;j++){
                if(shapes.get(j).location.getX()>shapes.get(j+1).location.getX()){
                    Collections.swap(shapes, j, j+1);
                } else if (shapes.get(j).location.getX()==shapes.get(j+1).location.getX()) {
                    if(shapes.get(j).location.getY()>shapes.get(j+1).location.getY()){
                        Collections.swap(shapes, j, j+1);
                    }else if (shapes.get(j).location.getY()==shapes.get(j+1).location.getY()) {
                        if(shapes.get(j).pattern>shapes.get(j+1).pattern){
                            Collections.swap(shapes, j, j+1);
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
