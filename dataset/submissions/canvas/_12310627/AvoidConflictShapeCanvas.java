import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows,int cols){
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (char[] canva : canvas) {
            Arrays.fill(canva,' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1){
            Circle circle =new Circle(new Location(x,y),pattern,params[0]);
            if(this.checkOutOfBound(circle)&&this.checkOverLap(circle)){
                shapes.add(circle);
                this.paint(circle);
                return true;
            }else {
                return false;
            }
        }
        if(params.length==3&&0<=params[2]&&params[2]<=3){
            RightTriangle rightTriangle=new RightTriangle(new Location(x,y)
                    ,pattern,params[0],params[1],Direction.values()[params[2]]);
            if(this.checkOutOfBound(rightTriangle)&&this.checkOverLap(rightTriangle)){
                shapes.add(rightTriangle);
                this.paint(rightTriangle);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    public boolean checkOutOfBound(Shape shape){
        if(shape.location.getX()<0||shape.location.getY()<0||
                shape.location.getX()+shape.grids.length>canvas.length||shape.location.getY()+shape.grids[0].length>canvas[0].length){
            return false;
        }
        return true;
    }
    public boolean checkOverLap(Shape shape){
        for (int i = 0; i < shape.grids.length; i++) {
            for (int j = 0; j < shape.grids[0].length; j++) {
                if(shape.grids[i][j]!=' '&&canvas[shape.location.getX()+i][shape.location.getY()+j]!=' '){
                    return false;
                }
            }
        }
        return true;
    }
    public void paint(Shape shape){
        int x=shape.location.getX(), y=shape.location.getY();
        for (int i = 0; i < shape.grids.length; i++) {
            for (int j = 0; j < shape.grids[0].length; j++) {
                if(canvas[x+i][j+y]==' ')
                    canvas[x+i][y+j]=shape.grids[i][j];
            }
        }
    }
    @Override
    public int getSpaceGridCount() {
        int sum=0;
        for (char[] canva : canvas) {
            for (char c : canva) {
                if(c==' '){
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(new AreaComparator());
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(new LocationComparator());
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
