import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            Arrays.fill(canvas[i], ' ');
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location newLocationIn = new Location(x,y);
        Shape newShapeIn;
        if(params.length==1){
            newShapeIn = new Circle(newLocationIn,pattern,params[0]);
        } else{
            Direction newDirectionIn ;
            if(params[2]==0){
                newDirectionIn = Direction.LEFT_UP;
            } else if (params[2]==1) {
                newDirectionIn = Direction.LEFT_DOWN;
            } else if (params[2]==2) {
                newDirectionIn = Direction.RIGHT_UP;
            } else {
                newDirectionIn = Direction.RIGHT_DOWN;
            }
            newShapeIn = new RightTriangle(newLocationIn,pattern,params[0],params[1],newDirectionIn );
        }
        boolean returnKey = true;
        char[][] tempCanvas = newShapeIn.ConflictShapeCanvasCheck(canvas);
        if(tempCanvas==null){
            returnKey = false;
        } else{
            canvas = tempCanvas;
            shapes.add(newShapeIn);
        }
        return returnKey;
    }

    @Override
    public int getSpaceGridCount() {
        int spaces = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if(canvas[i][j]==' '){
                    spaces++;
                }
            }
        }
        return spaces;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        boolean loopFlag = true;
        while(loopFlag){
            loopFlag = false;
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).area()>shapes.get(i+1).area()){
                    loopFlag = true;
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                } else if (shapes.get(i).area()==shapes.get(i+1).area()&&shapes.get(i).pattern>shapes.get(i+1).pattern) {
                    loopFlag = true;
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        boolean loopFlag = true;
        while(loopFlag){
            loopFlag = false;
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).location.getX()>shapes.get(i+1).location.getX()){
                    loopFlag = true;
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                } else if (shapes.get(i).location.getX()==shapes.get(i+1).location.getX()&&shapes.get(i).location.getY()>shapes.get(i+1).location.getY()) {
                    loopFlag = true;
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }
            }
        }
        boolean loopFlag02 = true;
        while(loopFlag02){
            loopFlag02 = false;
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).location.getX()==shapes.get(i+1).location.getX()&&shapes.get(i).location.getY()==shapes.get(i+1).location.getY()&&shapes.get(i).pattern>shapes.get(i+1).pattern){
                    loopFlag02 = true;
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
