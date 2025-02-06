import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    int row=0;
    int col=0;
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols)
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
            Circle c=new Circle(new Location(x,y),pattern,params[0]);
            char[][]grid=c.getGrids();
            boolean flag=false;
            for(int i=x,p=0;i<x+2*radius;i++,p++)
            {
                if(i<0)continue;
                if(i>=row||p>=2*radius)break;
                for(int j=y,q=0;j<y+2*radius;j++,q++) {
                    if(j<0)continue;
                    if(j>=col||q>=2*radius)break;
                    if (grid[p][q] != ' '){
                        flag=true;
                        canvas[i][j]=c.pattern;
                    }
                }
            }
            if(!flag)return false;
            shapes.add(c);
            return true;
        }
        else {
            int width = params[0];
            int height = params[1];

            Direction D;
            if (params[2] == 0) D = Direction.LEFT_UP;
            else if (params[2] == 1) D = Direction.LEFT_DOWN;
            else if (params[2] == 2) D = Direction.RIGHT_UP;
            else D = Direction.RIGHT_DOWN;

            RightTriangle rt = new RightTriangle(new Location(x, y), pattern, width, height, D);
            char[][] grid = rt.getGrids();
            boolean flag=false;

            for (int i = x, p = 0; i < x + height; i++, p++)
            {
                if(i<0)continue;
                if(i>=row||p>=height)break;
                for (int j = y, q = 0; j < y + width; j++, q++)
                {
                    if(j<0)continue;
                    if(j>=col||q>=width)break;
                    if (grid[p][q] != ' ')
                    {
                        flag=true;
                        canvas[i][j]=rt.pattern;
                    }
                }
            }
            if(!flag)return false;
            shapes.add(rt);
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