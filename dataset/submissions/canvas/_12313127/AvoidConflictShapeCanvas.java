import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes = new ArrayList<>();
        this.canvas=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if(params.length==1){
            Shape c = new Circle(new Location(x, y), pattern, params[0]);
            c.fillGrids();
            for(int i=0;i<c.getGrids().length;i++){
                for(int j=0;j<c.getGrids()[0].length;j++){
                    if(c.getGrids()[i][j]==pattern){
                        if(x+i>=canvas.length|y+j>=canvas[0].length){
                            return false;
                        } else if (canvas[x+i][y+j]!=' '){
                            return false;
                        }
                    }
                }
            }
            shapes.add(c);
            for (int i=0;i<c.getGrids().length;i++){
                for(int j=0;j<c.getGrids()[0].length;j++){
                    if (c.getGrids()[i][j]==pattern){
                        canvas[x+i][y+j]=pattern;
                    }
                }
            }
        }
        if(params.length==3){
            Direction di=Direction.LEFT_UP;
            int width=params[0];
            int height=params[1];
            if(params[2]==1){
                di=Direction.LEFT_DOWN;
            }
            if(params[2]==2){
                di=Direction.RIGHT_UP;
            }
            if(params[2]==3){
                di=Direction.RIGHT_DOWN;
            }
            Shape re=new RightTriangle(new Location(x,y),pattern,width,height,di);
            re.fillGrids();
            for (int i=0;i<re.getGrids().length;i++){
                for(int j=0;j<re.getGrids()[0].length; j++){
                    if(re.getGrids()[i][j]==pattern){
                        if(x+i>=canvas.length|y+j>=canvas[0].length){
                            return false;
                        }
                        if (canvas[x+i][y+j]!=' '){
                            return false;
                        }
                    }
                }
            }
            shapes.add(re);
            for (int i=0;i<re.getGrids().length;i++){
                for(int j=0;j<re.getGrids()[0].length;j++){
                    if(re.getGrids()[i][j]==pattern){
                        canvas[x+i][y+j]=pattern;
                    }
                }
            }
        }
            return true;
    }
    public int getSpaceGridCount(){
        int a=0;
        for (int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                if(canvas[i][j]==' '){
                    a++;
                }
            }
        }
        return a;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2){
                if(o1.area()!=o2.area()){
                    return Double.compare(o1.area(),o2.area());
                }else return Character.compare(o1.getPattern(), o2.getPattern());
            }
        });
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX()!=o2.location.getX()) {
                    return Double.compare(o1.location.getX(),o2.location.getX());
                } else {
                    if (o1.location.getY()!=o2.location.getY()) {
                        return Double.compare(o1.location.getY(),o2.location.getY());
                    }else return Character.compare(o1.getPattern(), o2.getPattern());
                }
            }
        });
        return shapes;
    }
    public char[][]getCanvas(){
        return canvas;
    }

}
