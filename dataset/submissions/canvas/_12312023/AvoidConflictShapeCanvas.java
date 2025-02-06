import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
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
        if(isInBound(shape)&&!isOverLap(shape)){
            shapes.add(shape);
            for (int j = 0; j < shape.grids.length; j++) {
                for (int k = 0; k < shape.grids[j].length; k++) {
                    if(shape.grids[j][k]!=' '){
                        canvas[j+shape.location.getX()][shape.location.getY()+k]=shape.grids[j][k];
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean isInBound(Shape shape){
        boolean xFlag1=(shape.location.getX()<=canvas.length-1&&shape.location.getX()>=0);
        boolean yFlag1=(shape.location.getY()<=canvas[0].length-1&&shape.location.getY()>=0);
        boolean xFlag2=shape.location.getX()+shape.getGrids().length<=canvas.length;
        boolean yFlag2=shape.location.getY()+shape.getGrids()[0].length<=canvas[0].length;
        if(xFlag1&&yFlag1&&xFlag2&&yFlag2){
            return true;
        }return false;
    }
    public boolean isOverLap(Shape s){
        if(isInBound(s)){
            for (int i = 0; i < s.grids.length; i++) {
                for (int j = 0; j < s.grids[i].length; j++) {
                    if(s.grids[i][j]!=' '&&canvas[s.location.getX()+i][s.location.getY()+j]!=' '){
                        return true;
                    }
                }
            }
        }
        return  false;
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
