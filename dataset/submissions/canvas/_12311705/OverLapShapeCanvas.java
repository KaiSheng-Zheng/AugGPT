import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int rows;
    int cols;
    int shapeCount;
    OverLapShapeCanvas(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        shapeCount=0;
        canvas=new char[rows][cols];
        for(int i=0;i<rows;++i)
                for (int j=0;j<cols;++j)
                    canvas[i][j]=' ';
        shapes=new ArrayList<Shape>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean return_value=false;
        char [][] tmp=new char[rows][cols];
        for(int i=0;i<rows;++i)
            for (int j=0;j<cols;++j)
                    tmp[i][j]=canvas[i][j];
        if(params.length==1){
            Circle t=new Circle(new Location(x,y),pattern,params[0]);
            char[][] grid=t.getGrids();
            for(int i=0;i<grid.length;++i)
                for (int j=0;j<grid[i].length;++j)
                    if(grid[i][j]!=' '&&y+j<cols&&x+i<rows){tmp[x+i][y+j]=grid[i][j];return_value=true;}
            if(return_value){
                shapes.add(t);
                shapeCount++;
                canvas=tmp;
            }
        }
        else {
            RightTriangle t=new RightTriangle(new Location(x,y),pattern,params[0],params[1],params[2]);
            char[][] grid=t.getGrids();
            for(int i=0;i<grid.length;++i)
                for (int j=0;j<grid[i].length;++j)
                    if(grid[i][j]!=' '&&y+j<cols&&x+i<rows)
                    {tmp[x+i][y+j]=grid[i][j];return_value=true;}
            if(return_value){
                shapes.add(t);
                shapeCount++;
                canvas=tmp;
            }
        }
        return return_value;
    }

    @Override
    public int getSpaceGridCount() {
        int ans = 0;
        for(int i=0;i<rows;++i)
            for (int j=0;j<cols;++j)
                if(canvas[i][j]==' ')ans++;
        return ans;
    }
    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes,new cmp());
        return shapes;
    }
    class cmp implements Comparator<Shape> {
        @Override
        public int compare(Shape o1,Shape o2) {
            if(o2.area()==o1.area())return o1.pattern-o2.pattern;
            return o1.area()-o2.area();
        }
    }
    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes);
        return shapes;
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
