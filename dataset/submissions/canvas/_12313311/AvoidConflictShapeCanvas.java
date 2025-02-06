/*No conflict,no over canvas.*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private int rows;
    private int cols;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows=rows;
        this.cols=cols;
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1) {
            Circle circle=new Circle(new Location(x,y),pattern,params[0]);
            for(int i=0;i<2*circle.getRadius();i++) {
                for(int j=0;j<2*circle.getRadius();j++) {
                    if(circle.grids[i][j]!=' ') {
                        if(x+i>=0&&x+i<rows&&y+j>=0&&y+j<cols) {
                            if(canvas[x+i][y+j]!=' ') {
                                return false;
                            }
                        }
                        else
                            return false;
                    }
                }
            }

            shapes.add(circle);
            for(int i=0;i<2*circle.getRadius();i++) {
                for(int j=0;j<2*circle.getRadius();j++) {
                    if(circle.grids[i][j]!=' ') {
                        canvas[x+i][y+j]=circle.grids[i][j];
                    }
                }
            }
            return true;
        }
        else {
            RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.getByIndex(params[2]));
            for(int i=0;i<rightTriangle.getHeight();i++) {
                for(int j=0;j<rightTriangle.getWidth();j++) {
                    if(rightTriangle.grids[i][j]!=' ') {
                        if(x+i>=0&&x+i<rows&&y+j>=0&&y+j<cols) {
                            if(canvas[x+i][y+j]!=' ') {
                                return false;
                            }
                        }
                        else
                            return false;
                    }
                }
            }

            shapes.add(rightTriangle);
            for(int i=0;i<rightTriangle.getHeight();i++) {
                for(int j=0;j<rightTriangle.getWidth();j++) {
                    if(rightTriangle.grids[i][j]!=' ') {
                        canvas[x+i][y+j]=rightTriangle.grids[i][j];
                    }
                }
            }
            return true;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int cnt=0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(canvas[i][j]!=' ')
                    cnt++;
            }
        }
        return cnt;
    }

    @Override
    public int getShapeCount(){
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea(){
        OrderByArea c=new OrderByArea();
        shapes.sort(c);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation(){
        OrderByLocation c=new OrderByLocation();
        shapes.sort(c);
        return shapes;
    }

    @Override
    public char[][] getCanvas(){
        return canvas;
    }
}
