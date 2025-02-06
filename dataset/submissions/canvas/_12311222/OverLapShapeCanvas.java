import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private int SpaceGridCount=0;
    private int ShapeCount = 0;
    private int ShapeGridCount=0;
    private int WhetherShapeHasGridOnCanvas=0;
    public int getShapeGridCount() {
        return ShapeGridCount;
    }
    public void setShapeGridCount(int shapeGridCount) {
        ShapeGridCount = shapeGridCount;
    }
    public int getWhetherShapeHasGridOnCanvas() {
        return WhetherShapeHasGridOnCanvas;
    }
    public void setWhetherShapeHasGridOnCanvas(int whetherShapeHasGridOnCanvas) {
        WhetherShapeHasGridOnCanvas = whetherShapeHasGridOnCanvas;
    }
    public OverLapShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        setShapeGridCount(0);
        setWhetherShapeHasGridOnCanvas(0);
        if(params.length==1){
            double[]center = {x+params[0]-0.5,y+params[0]-0.5};
            for (int i = x; i < x+params[0]; i++) {
                for (int j = y; j < y+params[0]; j++) {
                    double[]rightDownCorner = {i+0.5,j+0.5};
                    double rrd = Math.sqrt(Math.pow(rightDownCorner[0]-center[0],2)+Math.pow(rightDownCorner[1]-center[1],2));
                    if(rrd<params[0]){
                        setShapeGridCount(getShapeGridCount()+1);
                        if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                            setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                            if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                            canvas[i][j]=pattern;
                        }
                    }
                }
            }
            for (int i = x; i < x+params[0]; i++) {
                for (int j = y+params[0]; j < y+2*params[0]; j++) {
                    double[]leftDownCorner = {i+0.5,j-0.5};
                    double rld = Math.sqrt(Math.pow((leftDownCorner[0]-center[0]),2)+Math.pow((leftDownCorner[1]-center[1]),2));
                    if(rld<params[0]){
                        setShapeGridCount(getShapeGridCount()+1);
                        if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                            setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                            if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                            canvas[i][j]=pattern;
                        }
                    }
                }
            }
            for (int i = x+params[0]; i < x+2*params[0]; i++) {
                for (int j = y; j < y+params[0]; j++) {
                    double[]rightUpCorner = {i-0.5,j+0.5};
                    double rru = Math.sqrt(Math.pow((rightUpCorner[0]-center[0]),2)+Math.pow((rightUpCorner[1]-center[1]),2));
                    if(rru<params[0]){
                        setShapeGridCount(getShapeGridCount()+1);
                        if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                            setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                            if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                            canvas[i][j]=pattern;
                        }
                    }
                }
            }
            for (int i = x+params[0]; i < x+2*params[0]; i++) {
                for (int j = y+params[0]; j < y+2*params[0]; j++) {
                    double[]leftUpCorner = {i-0.5,j-0.5};
                    double rlu = Math.sqrt(Math.pow((leftUpCorner[0]-center[0]),2)+Math.pow((leftUpCorner[1]-center[1]),2));
                    if(rlu<params[0]){
                        setShapeGridCount(getShapeGridCount()+1);
                        if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                            setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                            if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                            canvas[i][j]=pattern;
                        }
                    }
                }
            }
            if(getWhetherShapeHasGridOnCanvas()!=0){
                Location newlocation=new Location(x,y);
                Circle newCircle = new Circle(newlocation,pattern,params[0]);
                newCircle.setCount(getShapeGridCount());//==area
                shapes.add(newCircle);
                setShapeCount(getShapeCount()+1);
                return true;
            }else return false;
        }
        else if (params.length==3) {
            Direction d=Direction.LEFT_UP;
            if(params[2]==0){
                d =Direction.LEFT_UP;
                for (int i = x; i < x+params[1]; i++) {
                    for (int j = y; j < y+params[0]; j++) {
                        double[]leftUpCorner = {i-0.5,j-0.5};
                        if(params[1]*(leftUpCorner[1]-(y-0.5))<-params[0]*(leftUpCorner[0]-(x+params[1]-0.5))){
                            setShapeGridCount(getShapeGridCount()+1);
                            if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                                setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                                if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                                canvas[i][j]=pattern;
                            }
                        }
                    }
                }
            }
            else if (params[2]==1) {
                d =Direction.LEFT_DOWN;
                for (int i = x; i < x+params[1]; i++) {
                    for (int j = y; j < y+params[0]; j++) {
                        double[]leftDownCorner = {i+0.5,j-0.5};
                        if(params[1]*(leftDownCorner[1]-(y-0.5))<params[0]*(leftDownCorner[0]-(x-0.5))){
                            setShapeGridCount(getShapeGridCount()+1);
                            if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                                setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                                if(canvas[i][j]==' ')setSpaceGridCount(getSpaceGridCount()+1);
                                canvas[i][j]=pattern;
                            }
                        }
                    }
                }
            }
            else if (params[2]==2) {
                d = Direction.RIGHT_UP;
                for (int i = x; i < x+params[1]; i++) {
                    for (int j = y; j < y+params[0]; j++) {
                        double[]rightUpCorner = {i-0.5,j+0.5};
                        if(params[1]*(rightUpCorner[1]-(y-0.5))>params[0]*(rightUpCorner[0]-(x-0.5))){
                            setShapeGridCount(getShapeGridCount()+1);
                            if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                                setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                                if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                                canvas[i][j]=pattern;
                            }
                        }
                    }
                }
            }
            else if (params[2]==3) {
                d = Direction.RIGHT_DOWN;
                for (int i = x; i < x+params[1]; i++) {
                    for (int j = y; j < y+params[0]; j++) {
                        double[]rightDownCorner = {i+0.5,j+0.5};
                        if(params[1]*(rightDownCorner[1]-(y-0.5))>-params[0]*(rightDownCorner[0]-(x+params[1]-0.5))){
                            setShapeGridCount(getShapeGridCount()+1);
                            if(0<=i&&i<canvas.length&&0<=j&&j< canvas[0].length){
                                setWhetherShapeHasGridOnCanvas(getWhetherShapeHasGridOnCanvas()+1);
                                if(canvas[i][j]==' ') setSpaceGridCount(getSpaceGridCount()+1);
                                canvas[i][j]=pattern;
                            }
                        }
                    }
                }
            }
            if(getWhetherShapeHasGridOnCanvas() != 0){
                Location newLocation3 = new Location(x,y);
                RightTriangle newRightTriangle3 = new RightTriangle(newLocation3,pattern,params[0],params[1],d);
                newRightTriangle3.setCount(getShapeGridCount());
                shapes.add(newRightTriangle3);
                setShapeCount(getShapeCount()+1);
                return true;
            }else return false;
        }
        return false;
    }
    public void setSpaceGridCount(int spaceGridCount) {
        SpaceGridCount = spaceGridCount;
    }
    public int getSpaceGridCount(){
        return SpaceGridCount;
    }
    public void setShapeCount(int shapeCount) {
        ShapeCount = shapeCount;
    }
    public int getShapeCount(){
        return ShapeCount;
    }
    public char[][] getCanvas(){
        return canvas;
    }
    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area()) {
                    return Integer.compare(s1.area(), s2.area());
                }
                else return Character.compare(s1.getPattern(),s2.getPattern());
            }
        });
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if(s1.getLocation().getX()!=s2.getLocation().getX()){
                    return Integer.compare(s1.getLocation().getX(),s2.getLocation().getX());
                } else if (s1.getLocation().getY()!=s2.getLocation().getY()) {
                    return Integer.compare(s1.getLocation().getY(),s2.getLocation().getY());
                }else return Character.compare(s1.getPattern(),s2.getPattern());
            }
        });
        return shapes;
    }
}