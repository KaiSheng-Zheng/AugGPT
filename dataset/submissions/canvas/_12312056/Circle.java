public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        grids=new char[radius*2][radius*2];
        for(int i= 0;i<radius*2;i++)
            for(int j= 0;j<radius*2;j++)
                if((i-radius)*(i-radius)+(j-radius)*(j-radius)<radius*radius||(i-radius+1)*(i-radius+1)+(j-radius)*(j-radius)<radius*radius||(i-radius)*(i-radius)+(j-radius+1)*(j-radius+1)<radius*radius||(i-radius+1)*(i-radius+1)+(j-radius+1)*(j-radius+1)<radius*radius)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
    }
    @Override
    public void enlarge(){
        radius++;
        int r=radius;
        grids=new char[r*2][r*2];
        for(int i=0;i<r*2;i++)
            for(int j=0;j<r*2;j++)
                if((i-r)*(i-r)+(j-r)*(j-r)<r*r||(i-r+1)*(i-r+1)+(j-r)*(j-r)<r*r||(i-r)*(i-r)+(j-r+1)*(j-r+1)<r*r||(i-r+1)*(i-r+1)+(j-r+1)*(j-r+1)<r*r)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
    }
    @Override
    public void shrink(){
        radius--;
        int r=radius;
        grids=new char[r*2][r*2];
        for(int i=0;i<r*2;i++)
            for(int j=0;j<r*2;j++)
                if((i-r)*(i-r)+(j-r)*(j-r)<r*r||(i-r+1)*(i-r+1)+(j-r)*(j-r)<r*r||(i-r)*(i-r)+(j-r+1)*(j-r+1)<r*r||(i-r+1)*(i-r+1)+(j-r+1)*(j-r+1)<r*r)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
    }
    @Override
    public int area(){
        int sum=0;
        int r= grids.length;
        for (char[] grid : grids)
            for (int j = 0; j < r; j++)
                if (grid[j] == pattern)
                    sum++;
        return sum;
    }

    @Override
    public String toString() {
        String s;
        s="Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        return s;
    }
}
