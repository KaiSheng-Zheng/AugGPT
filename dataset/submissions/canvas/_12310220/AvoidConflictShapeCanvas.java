import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    int row=0;
    int col=0;
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols)
    {
        row=rows;col=cols;
        canvas =new char[rows][cols];
        shapes = new ArrayList<>();
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                canvas[i][j]=' ';
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params)
    {
        int Len=params.length;
        if(Len==1){
            int radius=params[0];
            if(x+2*radius>row||y+2*radius>col||x<0||y<0)return false;
            Circle c=new Circle(new Location(x,y),pattern,params[0]);
            char[][]grid=c.getGrids();
            for(int i=x,p=0;i<x+2*radius;i++,p++)
            {
                for(int j=y,q=0;j<y+2*radius;j++,q++)
                    if(grid[p][q]!=' '&&canvas[i][j]!=' '){
                        return false;
                }
            }
            shapes.add(c);
            for(int i=x,p=0;i<x+2*radius;i++,p++) {
                for (int j = y, q = 0; j < y + 2*radius; j++, q++) {
                    if (grid[p][q] != ' ') canvas[i][j]=c.pattern;
                }
            }
            return true;
        }
        else {
            int width = params[0];
            int height = params[1];
            if(x<0||y<0||x+height>row||y+width>col)return false;

            Direction D;
            if (params[2] == 0) D = Direction.LEFT_UP;
            else if (params[2] == 1) D = Direction.LEFT_DOWN;
            else if (params[2] == 2) D = Direction.RIGHT_UP;
            else D = Direction.RIGHT_DOWN;

            RightTriangle rt = new RightTriangle(new Location(x, y), pattern, width, height, D);
            char[][] grid = rt.getGrids();

            for (int i = x, p = 0; i < x + height; i++, p++) {
                for (int j = y, q = 0; j < y + width; j++, q++) {
                    if (grid[p][q] != ' ' && canvas[i][j] != ' ') return false;
                }
            }
            shapes.add(rt);
            for (int i = x, p = 0; i < x + height; i++, p++) {
                for (int j = y, q = 0; j < y + width; j++, q++) {
                    if (grid[p][q] != ' ') canvas[i][j] = pattern;
                }
            }
            return true;
        }
    }
    @Override
    public int getSpaceGridCount()
    {
        int Count=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
                if(canvas[i][j]==' ')Count++;
        }
        return Count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new comp1());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new comp2());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}
class comp1 implements Comparator<Shape>
{
    @Override
    public int compare(Shape x,Shape y)
    {
        if(x.area()<y.area())return -1;
        else if(x.area()>y.area())return 1;
        else if(x.pattern<y.pattern)return -1;
        else return 1;
    }
}
class comp2 implements Comparator<Shape>
{
    @Override
    public int compare(Shape x,Shape y)
    {
        if(x.location.getX()<y.location.getX())return -1;
        else if(x.location.getX()>y.location.getX())return 1;
        else if(x.location.getY()<y.location.getY())return -1;
        else if(x.location.getY()>y.location.getY())return 1;
        else if(x.pattern<y.pattern)return -1;
        else return 1;
    }
}