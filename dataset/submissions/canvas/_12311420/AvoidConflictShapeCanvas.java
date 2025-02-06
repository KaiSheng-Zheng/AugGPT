import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes=new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location=new Location(x,y);
       if (x<0|y<0)
           return false;
       if (params.length==1){
           if (x + 2 * params[0] > canvas.length  | y + 2 * params[0]>canvas[0].length)
               return false;
           Circle c=new Circle(location,pattern,params[0]);
           char[][] cGrids=c.getGrids();
           for (int i = x; i < x+2*params[0]; i++) {
               for (int j = y; j <y+2*params[0] ; j++) {
                   if (cGrids[i-x][j-y]!=' '&&canvas[i][j]!=' ')
                       return false;

               }
           }
           for (int i = x; i < x+2*params[0]; i++) {
               for (int j = y; j <y+2*params[0] ; j++) {
                   if (cGrids[i-x][j-y]!=' ')
                  canvas[i][j]= cGrids[i-x][j-y];
               }
           }
           shapes.add(c);
           return true;
       }
       if (params.length==3){
           RightTriangle r=new RightTriangle(location,pattern,params[0],params[1],getDirection(params[2]));
           char[][] rGrids=r.getGrids();
           if (x + rGrids.length> canvas.length |y + rGrids[0].length>canvas[0].length)
               return false;
           for (int i = x; i < x+rGrids.length; i++) {
               for (int j = y; j < y+rGrids[0].length; j++) {
                   if (canvas[i][j]!=' '&&rGrids[i-x][j-y]!=' ')
                       return false;
               }
           }
           for (int i = x; i < x+rGrids.length; i++) {
               for (int j = y; j <y+rGrids[0].length ; j++) {
                   if (rGrids[i-x][j-y]!=' ')
                       canvas[i][j]= rGrids[i-x][j-y];
               }
           }
           shapes.add(r);
           return true;
       }
       return false;
    }

    @Override
    public int getSpaceGridCount() {
       int counter =0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]==' ')
                    counter++;
            }
        }
        return counter;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
       List<Shape>resortedShapes=new ArrayList<>(shapes);
        Collections.sort(resortedShapes);
        return resortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape>resortedShapes=new ArrayList<>(shapes);
        resortedShapes.sort(new Circle(null,' ',0));
        return resortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public Direction getDirection(int param){
        if (param==0)
            return Direction.LEFT_UP;
        if (param==1)
            return Direction.LEFT_DOWN;
        if (param==2)
            return Direction.RIGHT_UP;
        else
            return Direction.RIGHT_DOWN;
    }

}
