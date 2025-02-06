import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int rows;
    int cols;
    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        for (char[] canva : canvas) {
            Arrays.fill(canva,' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        char[][] readycanvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                readycanvas[i][j]=canvas[i][j];
            }
        }//deep copy of canvas
        if (params.length==1){
            Circle circle=new Circle(new Location(x,y),pattern,params[0]);
            try {
                for (int i = 0; i < circle.grids.length; i++) {
                    for (int j = 0; j < circle.grids.length; j++) {
                        if (canvas[x + i][y + j] != ' ' & circle.grids[i][j] != ' ') {return false;}
                        if (circle.grids[i][j]!=' '){readycanvas[x + i][y + j] = circle.grids[i][j];}
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {return false;}
            canvas = readycanvas;
            shapes.add(circle);
            return true;

            }
        RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],findDirection(params[2]));
        try {
            for (int i = 0; i < rightTriangle.getHeight(); i++) {
                for (int j = 0; j < rightTriangle.getWidth(); j++) {
                    if (canvas[x + i][y + j] != ' ' && rightTriangle.grids[i][j] != ' ') {return false;}
                    if (rightTriangle.grids[i][j]!=' '){readycanvas[x + i][y + j] = rightTriangle.grids[i][j];}
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){return false;}
        canvas=readycanvas;
        shapes.add(rightTriangle);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int counter=0;
        for (char[] canva :canvas){
            for (int i = 0; i < canva.length; i++) {
                if (canva[i]==' '){
                    counter++;
                }
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
        shapes.sort(new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new LocationComparator());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
