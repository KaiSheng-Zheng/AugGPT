import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;

    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = null;
        Location location = new Location(x,y);
        int width = 0;
        int height = 0;
        if(params.length == 1){
            width = params[0];
            height = params[0];
            shape = new Circle(location,pattern,params[0]);
        }else if(params.length == 3){
            Direction[] values = Direction.values();
            width = params[0];
            height = params[1];
            if(params[2] > 0 && params[2]<values.length  ){
                shape = new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
            }
        }
        if(shape != null && height+x <= canvas.length && width+y <= canvas[0].length && !isOverlap(shape)){
            shapes.add(shape);
            char[][] grids = shape.grids;
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if(grids[i][j] == pattern){
                        canvas[location.getX()+i][location.getY()+j] = pattern;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean isOverlap(Shape shape) {
        char[][] grids = shape.grids;
        Location location = shape.location;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                // ArrayIndexOutOfBoundsException if location.getY() + grids[i].length > canvas[i].length
                // need to return false when "The shape is out of the bound of canvas."
                if(grids[i][j] == shape.pattern && canvas[location.getX()+i][location.getY()+j] != ' '){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
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
        List<Shape> result = new ArrayList<>(shapes);
        result.sort((a,b) -> {
            if(Integer.compare(a.area(),b.area()) == 0){
                return Character.compare(a.pattern,b.pattern);
            }
            return Integer.compare(a.area(),b.area());
        });
        return result;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> result = new ArrayList<>(shapes);
        result.sort((a,b) -> {
            Location locationA = a.location;
            Location locationB = b.location;
            if(Integer.compare(locationA.getX(),locationB.getX()) == 0){
                if(Integer.compare(locationA.getY(),locationB.getY()) == 0){
                    return Character.compare(a.pattern,b.pattern);
                }
                return Integer.compare(locationA.getY(),locationB.getY());
            }
            return Integer.compare(locationA.getX(),locationB.getX());
        });
        return result;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}