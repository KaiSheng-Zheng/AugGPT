import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private static int spaceGridCount=0,shapeCount=0;
    public OverLapShapeCanvas(int rows,int cols){
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
    public boolean addShape(int x, int y, char pattern, int... params){
        boolean flag=false;
        Location location=new Location(x,y);
        if (params.length==1){
            Shape shape=new Circle(location,pattern,params[0]);
            for (int i=location.getX();i<Math.min(location.getX()+2*params[0],rows);i++){
                for (int j=location.getY();j<Math.min(location.getY()+2*params[0],cols);j++){
                    if(shape.getGrids()[i-location.getX()][j-location.getY()]!=' '){
                        canvas[i][j]=shape.getGrids()[i-location.getX()][j-location.getY()];
                    }
                }
            }
            here:
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if (canvas[i][j]==pattern){
                        flag=true;
                        shapes.add(shape);
                        break here;
                    }
                }
            }
        }else {
            Shape shape=new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
            for (int i=location.getX();i<Math.min(location.getX()+params[1],rows);i++){
                for (int j=location.getY();j<Math.min(location.getY()+params[0],cols);j++){
                    if (shape.getGrids()[i-location.getX()][j-location.getY()]!=' '){
                        canvas[i][j]=shape.getGrids()[i-location.getX()][j-location.getY()];
                    }
                }
            }
            here:
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if (canvas[i][j]==pattern){
                        flag=true;
                        shapes.add(shape);
                        break here;
                    }
                }
            }
        }
        return flag;
    }
    @Override
    public int getSpaceGridCount() {
        //clear the counter before counting
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
