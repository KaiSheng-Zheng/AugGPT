import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows,int cols) {
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
            if(this.checkOnCanvas(circle)){
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
            if(this.checkOnCanvas(rightTriangle)){
                shapes.add(rightTriangle);
                this.paint(rightTriangle);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    public void paint(Shape shape){
        int x=shape.location.getX(), y=shape.location.getY();
        for (int i = 0; i < Math.min(shape.grids.length,canvas.length-x); i++) {
            for (int j = 0; j < Math.min(canvas[x+i].length-y,shape.grids[0].length); j++) {
                if(shape.grids[i][j]!=' ')
                    canvas[x+i][y+j]=shape.grids[i][j];
            }
        }
    }
    public boolean checkOnCanvas(Shape shape){
        int x=shape.location.getX(), y=shape.location.getY();
        for (int i = 0; i < shape.grids.length; i++) {
            for (int j = 0; j < shape.grids[0].length; j++) {
                if(x+i<canvas.length&&x+i>=0&&y+j<canvas[0].length&&y+j>=0){
                    if(shape.grids[i][j]!=' '){
                        return true;
                    }
                }
            }
        }
        return false;
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
