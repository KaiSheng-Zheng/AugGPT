public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d)
    {
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.width=width;
        this.d=d;
        fillGrids();
    }
    @Override
    public void fillGrids()
    {
        grids=new char[height][width];
        for (int i =0;i<height ; i++) {
            for(int j=0;j<width;j++)
            {
                int ni=i,nj=j;
                switch (d)
                {
                    case RIGHT_UP:
                        nj=width-j-1;
                        ni=height-i-1;
                        break;
                    case LEFT_UP:
                        ni=height-i-1;
                        break;
                    case RIGHT_DOWN:
                        nj=width-j-1;
                        break;
                }
                grids[i][j]=' ';
                if(height*nj-width*ni<0)
                {
                    grids[i][j]=pattern;
                }
                if(height*(nj+1)-width*ni<0)
                {
                    grids[i][j]=pattern;
                }
                if(height*nj-width*(1+ni)<0)
                {
                    grids[i][j]=pattern;
                }
                if(height*(nj+1)-width*(ni+1)<0)
                {
                    grids[i][j]=pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }
    @Override
    public void shrink()
    {
        height--;
        width--;
        fillGrids();
    }
    @Override
    public int area()
    {
        int cnt=0;
        for (int i = 0; i <height ; i++) {
            for (int j =0; j <width; j++) {
                if(grids[i][j]!=' ')cnt++;
            }
        }
        return cnt;
    }
    public String toString()
    {
        return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}
