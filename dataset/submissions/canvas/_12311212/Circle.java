public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius)
    {
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids()
    {
        grids=new char[2*radius][2*radius];
        for (int i =0; i <2*radius ; i++) {
            for(int j=0;j<2*radius;j++)
            {
                grids[i][j]=' ';
                if((i-radius)*(i-radius)+(j-radius)*(j-radius)<radius*radius)
                {
                    grids[i][j]=pattern;
                }
                if((i+1-radius)*(i+1-radius)+(j-radius)*(j-radius)<radius*radius)
                {
                    grids[i][j]=pattern;
                }
                if((i-radius)*(i-radius)+(j+1-radius)*(j+1-radius)<radius*radius)
                {
                    grids[i][j]=pattern;
                }
                if((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius)<radius*radius)
                {
                    grids[i][j]=pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }
    @Override
    public void shrink()
    {
        radius--;
        fillGrids();
    }
    @Override
    public int area()
    {
        int cnt=0;
        for (int i = 0; i <2*radius ; i++) {
            for (int j =0; j <2*radius; j++) {
                if(grids[i][j]!=' ')cnt++;
            }
        }
        return cnt;
    }
    public String toString()
    {
        return "Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}
