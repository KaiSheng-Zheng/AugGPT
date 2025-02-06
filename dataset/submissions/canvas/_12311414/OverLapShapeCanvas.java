import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols) {
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
            boolean add = false;
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(shape.getGrids()[i][j] != ' '&&x+i<canvas.length&&y+j<canvas[0].length){
                        add = true;
                        break;
                    }
                }
                if(add){break;}
            }
            if(!add){
                return false;
            }
            shapes.add(shape);
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(x+i<canvas.length&&y+j<canvas[0].length&&shape.getGrids()[i][j]!=' ') {
                        canvas[x + i][y + j] = shape.getGrids()[i][j];
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
            boolean add = false;
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(shape.getGrids()[i][j] != ' '&&x+i<canvas[0].length&&y+j<canvas.length){
                        add = true;
                        break;
                    }
                }
                if(add){break;}
            }
            if(!add){
                return false;
            }
            shapes.add(shape);
            for(int i = 0; i<shape.getGrids().length;i++){
                for (int j = 0; j<shape.getGrids()[i].length;j++){
                    if(x+i<canvas.length&&y+j<canvas[0].length&&shape.getGrids()[i][j]!=' ') {
                        canvas[x + i][y + j] = shape.getGrids()[i][j];
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
                if(canvas[i][j] !=0){count++;} // space is 32 in ASCII, not 0.
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