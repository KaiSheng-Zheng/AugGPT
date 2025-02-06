import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private static int spaceGridCount=0,shapeCount=0;

    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas=new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
        shapes=new ArrayList<Shape>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        boolean flag=true;
        Location location=new Location(x,y);
        if (params.length==1){
            Shape shape=new Circle(location,pattern,params[0]);
            if (location.getX()+2*params[0]>rows | location.getY()+2*params[0]>cols){
                flag=false;
            }
            here:
            if (flag){
                for (int i=location.getX();i<location.getX()+2*params[0];i++){
                    for (int j=location.getY();j<location.getY()+2*params[0];j++){
                        if (canvas[i][j]!=' ' & shape.getGrids()[i-location.getX()][j-location.getY()]!=' '){
                            flag=false;
                            break here;
                        }
                    }
                }
            }
            if (flag){
                for (int i=location.getX();i<location.getX()+2*params[0];i++){
                    for (int j=location.getY();j<location.getY()+2*params[0];j++){
                        if(shape.getGrids()[i-location.getX()][j-location.getY()]!=' '){
                            canvas[i][j]=shape.getGrids()[i-location.getX()][j-location.getY()];
                        }
                    }
                }
                shapes.add(shape);
            }
        }else {
            Shape shape=new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
            if (location.getX()+params[1]>rows | location.getY()+params[0]>cols){
                flag=false;
            }
            here:
            if (flag){
                for (int i=location.getX();i<location.getX()+params[1];i++){
                    for (int j=location.getY();j<location.getY()+params[0];j++){
                        if (canvas[i][j]!=' ' & shape.getGrids()[i-location.getX()][j-location.getY()]!=' '){
                            flag=false;
                            break here;
                        }
                    }
                }
            }
            if (flag){
                for (int i=location.getX();i<location.getX()+params[1];i++){
                    for (int j=location.getY();j<location.getY()+params[0];j++){
                        if(shape.getGrids()[i-location.getX()][j-location.getY()]!=' '){
                            canvas[i][j]=shape.getGrids()[i-location.getX()][j-location.getY()];
                        }
                    }
                }
                shapes.add(shape);
            }
        }
        return flag;
    }

    @Override
    public int getSpaceGridCount() {
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (canvas[i][j]!=' '){
                    spaceGridCount++;
                }
            }
        }
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        shapeCount=shapes.size();
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort( new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                double area1= o1.area();
                double area2=o2.area();
                if (area1<area2){
                    return -1;
                } else if (area1>area2) {
                    return 1;
                }else {
                    return o1.getPattern()<o2.getPattern()? -1:1;
                }
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                double x1=o1.location.getX();
                double x2=o2.location.getX();
                if (x1<x2){
                    return  -1;
                } else if (x1>x2) {
                    return 1;
                }else {
                    if (o1.location.getY()<o2.location.getY()){
                        return -1;
                    } else if (o1.location.getY()>o2.location.getY()) {
                        return 1;
                    }else {
                        return o1.getPattern()<o2.getPattern()? -1:1;
                    }
                }
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
