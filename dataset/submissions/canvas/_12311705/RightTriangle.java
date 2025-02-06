import static java.lang.Integer.min;

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private  Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    public RightTriangle(Location location, char pattern, int width, int height, int d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        switch (d){
            case 0:this.d=Direction.LEFT_UP;break;
            case 1:this.d=Direction.LEFT_DOWN;break;
            case 2:this.d=Direction.RIGHT_UP;break;
            case 3:this.d=Direction.RIGHT_DOWN;break;
        }
        fillGrids();
    }
    @Override
    public void fillGrids() {
        grids=new char[height][width];
        for (int i=0;i<height;++i){
            if(d.equals(Direction.LEFT_UP))
                for (int j=0;j<Math.ceil((width-1.0*width*(i)/height));++j)grids[i][j]=pattern;
            if(d.equals(Direction.RIGHT_DOWN))
                for (int j=(int)(width-1.0*width*(i+1)/height);j<width;++j)grids[i][j]=pattern;
            if(d.equals(Direction.LEFT_DOWN))
                for (int j=0;j<min(width,(int)(Math.ceil(1.0*width/height*(i+1))));++j)grids[i][j]=pattern;
            if(d.equals(Direction.RIGHT_UP))
                for (int j=(int)(1.0*width/height*(i));j<width;++j)grids[i][j]=pattern;
        }
        for(int i=0;i<height;++i)
            for (int j=0;j<width;++j)
                if(grids[i][j]==0)grids[i][j]=' ';
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }
    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }
    @Override
    public int area() {
        int ans=0;
        for(int i=0;i<height;++i)
            for (int j=0;j<width;++j)
                if(grids[i][j]!=' ')ans++;
        return ans;
    }
    @Override
    public String toString() {
        return "RightTriangle: ("+location.getX()+","+location.getY()+") "+"area="+area()+" pattern="+pattern;
    }
}
