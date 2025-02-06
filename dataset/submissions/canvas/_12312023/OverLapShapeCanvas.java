import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        if(params.length==1){
            shape=new Circle(new Location(x,y),pattern,params[0]);
        }else {
            shape=new RightTriangle(new Location(x,y),pattern,params[0],params[1],getDirection(params[2]));
        }
        if(isInBound(shape)){
            shapes.add(shape);
            for (int j = 0; j < shape.grids.length; j++) {
                for (int k = 0; k < shape.grids[j].length; k++) {
                    if(shape.grids[j][k]!=' '&&isInCanvas(j+shape.location.getX(),k+shape.location.getY())){
                        canvas[j+shape.location.getX()][shape.location.getY()+k]=shape.grids[j][k];
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean isInBound(Shape shape){
        for (int i = 0; i < shape.grids.length; i++) {
            for (int j = 0; j < shape.grids[i].length; j++) {
                if((shape.grids[i][j]!=' ')&&(shape.location.getX()+i<canvas.length)&&(shape.location.getY()+j<canvas[0].length)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isInCanvas(int i,int j){
        return 0<=i&&i< canvas.length&&0<=j&&j< canvas[0].length;
    }
    public Direction getDirection(int n){
        switch (n){//LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN
            case 0:return Direction.LEFT_UP;
            case 1:return Direction.LEFT_DOWN;
            case 2:return Direction.RIGHT_UP;
            default: return Direction.RIGHT_DOWN;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==' '){
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
        List<Shape>out=new ArrayList<>();
        for (int i = 0; i < this.shapes.size(); i++) {
            out.add(shapes.get(i));
        }
        out.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.area==o2.area? o1.pattern-o2.pattern:o1.area-o2.area;
            }
        });
        return out;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape>out=new ArrayList<>();
        for (int i = 0; i < this.shapes.size(); i++) {
            out.add(shapes.get(i));
        }
        out.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.location.getX()!=o2.location.getX()){
                    return o1.location.getX()-o2.location.getX();
                }else if(o1.location.getY()!=o2.location.getY()){
                    return o1.location.getY()-o2.location.getY();
                }else return o1.pattern-o2.pattern;
            }
        });
        return out;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}