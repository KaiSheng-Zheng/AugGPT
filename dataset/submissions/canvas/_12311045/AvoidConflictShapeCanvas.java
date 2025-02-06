import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private  int cols;
    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
        this.rows=rows;
        this.cols=cols;
    }

    public List<Shape> getShapes() {return shapes;}

    public void setShapes(List<Shape> shapes) {this.shapes = shapes;}

    public void setCanvas(char[][] canvas) {this.canvas = canvas;}

    public int getSpaceGridCount(){
        return rows*cols;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        Comparator<Shape> comparator = Comparator.comparing(Shape::area).thenComparing(Shape::getPattern);
        shapes.sort(comparator);
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        Comparator<Shape> comparator = Comparator.comparing(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern);
        shapes.sort(comparator);
        return shapes;
    }
    public char[][] getCanvas(){
        return canvas;
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int ...params){
        int a=0;
        if(params.length==1){
            Location location = new Location(x, y);
            Circle circle=new Circle(location,pattern,params[0]);
            if(x+2*params[0]>rows|y+2*params[0]>cols){a++;}
            else for(int i=x;i-x<2*params[0];i++){
                for(int j=y;j-y<2*params[0];j++)
                    if (canvas[i][j] != ' '&&circle.grids[i-x][j-y]!=' ') {
                        a++;
                    }
            }
        }
        else {
            if(x+params[1]>rows|y+params[0]>cols){a++;}
            else {
                Location location = new Location(x, y);
                Direction d = null;
                if(params[2]==0){d=Direction.LEFT_UP;}
                else if(params[2]==1){d=Direction.LEFT_DOWN;}
                else if(params[2]==2){d=Direction.RIGHT_UP;}
                else if(params[2]==3){d=Direction.RIGHT_DOWN;}
                RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],d);
                for (int i=x;i-x<params[1];i++){
                    for(int j=y;j-y<params[0];j++)
                        if (rightTriangle.grids[i-x][j-y] != ' ' && canvas[i][j] != ' ') {
                            a++;
                        }
                }
            }
        }
        if(x<0|y<0){a++;}
        if(a==0){
            Location location = new Location(x, y);
            if(params.length==1){
                Circle circle=new Circle(location,pattern,params[0]);
                shapes.add(circle);
                for(int i=x;i<x+2*params[0];i++){
                    for(int j=y;j<y+2*params[0];j++){
                        if(circle.grids[i-x][j-y]!=' '){
                            canvas[i][j]=circle.grids[i-x][j-y];
                        }
                    }
                }
            }
            else {
                Direction d = null;
                if(params[2]==0){d=Direction.LEFT_UP;}
                else if(params[2]==1){d=Direction.LEFT_DOWN;}
                else if(params[2]==2){d=Direction.RIGHT_UP;}
                else if(params[2]==3){d=Direction.RIGHT_DOWN;}
                RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],d);
                shapes.add(rightTriangle);
                for (int i=x;i<x+params[1];i++){
                    for(int j=y;j<y+params[0];j++){
                        if(rightTriangle.grids[i-x][j-y]!=' '){
                            canvas[i][j]=rightTriangle.grids[i-x][j-y];
                        }
                    }
                }
            }
        }
        return a == 0;
    }
}
