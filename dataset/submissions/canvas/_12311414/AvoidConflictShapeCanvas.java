import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<cols; j++){
                canvas[i][j] = ' ';
            }
        }

    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);
        if(params.length == 1){
            Circle shape = new Circle(location,pattern,params[0]);
            if(x+2*params[0] > canvas[0].length||y+2*params[0] > canvas.length||x<0||y<0){
                return false;
            }
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(shape.getGrids()[i][j] != ' '&&canvas[x+i][y+j] !=' '){
                        return false;
                    }
                }
            }
            shapes.add(shape);
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(shape.getGrids()[i][j]!=' '){
                    canvas[x+i][y+j] = shape.getGrids()[i][j];
                    }
                    }
                }
            return true;
            } else if(params.length == 3){
            Direction d = null;
            switch (params[2]){
                case 0: d = Direction.LEFT_UP;
                break;
                case 1: d = Direction.LEFT_DOWN;
                break;
                case 2: d = Direction.RIGHT_UP;
                break;
                case 3: d = Direction.RIGHT_DOWN;
                break;
            }
            RightTriangle shape = new RightTriangle(location,pattern,params[0],params[1],d);
            if(x+params[1] > canvas.length||y+params[0] > canvas[0].length||x<0||y<0){
                return false;
            }
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(shape.getGrids()[i][j] != ' '&&canvas[x+i][y+j] !=' '){
                        return false;
                    }
                }
            }
            shapes.add(shape);
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(shape.getGrids()[i][j]!=' '){
                        canvas[x+i][y+j] = shape.getGrids()[i][j];
                    }
                }
            }
            return true;

        }else {return false;}

    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for(int i = 0; i<canvas.length;i++){
            for (int j = 0; j<canvas[i].length;j++){
               if(canvas[i][j] !=0){count++;}
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
        List<Shape> shapes0 = new ArrayList<>();
        List<Shape> shapes1 = new ArrayList<>();
        for(int i =0;i<shapes.size();i++){
            shapes0.add(shapes.get(i));
        }
        int s = shapes0.size();
        for(int i =0;i<s;i++){
            int in = 0;
            Shape shape = shapes0.get(0);
            for(int j =0; j<shapes0.size();j++){
                if(shapes0.get(j).compareByArea(shape)<0){
                    in = j;
                    shape = shapes0.get(in);
                }
            }
            shapes0.remove(in);
            shapes1.add(shape);
        }
        return shapes1;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> shapes0 = new ArrayList<>();
        List<Shape> shapes1 = new ArrayList<>();
        for(int i =0;i<shapes.size();i++){
            shapes0.add(shapes.get(i));
        }
        int s = shapes0.size();
        for(int i =0;i<s;i++){
            int in = 0;
            Shape shape = shapes0.get(0);
            for(int j =0; j<shapes0.size();j++){
                if(shapes0.get(j).compareByLocation(shape)<0){
                    in = j;
                    shape = shapes0.get(in);
                }
            }
            shapes0.remove(in);
            shapes1.add(shape);
        }
        return shapes1;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}