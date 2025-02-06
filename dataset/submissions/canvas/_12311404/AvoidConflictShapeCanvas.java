import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        Location location=new Location(x,y);
        if (params.length==1) {
            Shape circle = new Circle(location, pattern, params[0]);
            circle.fillGrids();
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids.length; j++) {
                    if (x+i>=canvas.length||y+j>=canvas[0].length)
                        return false;
                    else if (circle.grids[i][j]!=' '&& canvas[x+i][y+j]!=' ')
                        return false;
                }
            }
            shapes.add(circle);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids.length; j++) {
                    if (circle.grids[i][j]!=' ')
                        canvas[x+i][y+j]=circle.grids[i][j];
                }
            }
        }
        if (params.length==3){
            Shape shape=new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
            shape.fillGrids();
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (x+i>=canvas.length||y+j>=canvas[0].length)
                        return false;
                    else if (shape.grids[i][j]!=' '&& canvas[x+i][y+j]!=' ')
                        return false;
                }
            }
            shapes.add(shape);
            for (int i = 0; i < params[1] ; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (shape.grids[i][j]!=' ')
                        canvas[x+i][y+j]=shape.grids[i][j];
                }
            }
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int num=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]!=' ')
                    num++;
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = shapes.size()-1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (shapes.get(j).area()>shapes.get(j+1).area()){
                    Shape shape=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,shape);
                }
                else if (shapes.get(j).area()==shapes.get(j+1).area()){
                    if(Character.compare(shapes.get(j).pattern,shapes.get(j+1).pattern)>0){
                        Shape shape=shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,shape);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = shapes.size()-1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (shapes.get(j).location.getX()>shapes.get(j+1).location.getX()){
                    Shape shape=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,shape);
                }
                else if (shapes.get(j).location.getX()==shapes.get(j+1).location.getX()){
                    if(shapes.get(j).location.getY()>shapes.get(j+1).location.getY()){
                        Shape shape=shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,shape);
                    }
                    else if (shapes.get(j).location.getY()==shapes.get(j+1).location.getY()){
                        if(Character.compare(shapes.get(j).pattern,shapes.get(j+1).pattern)>0){
                            Shape shape=shapes.get(j);
                            shapes.set(j,shapes.get(j+1));
                            shapes.set(j+1,shape);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
}
