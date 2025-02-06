public class Circle extends Shape{
    private int radius;
    boolean check(int x,int y){
        if((x-radius)*(x-radius)+(y-radius)*(y-radius)<radius*radius)return true;
        if((x-radius+1)*(x-radius+1)+(y-radius)*(y-radius)<radius*radius)return true;
        if((x-radius)*(x-radius)+(y-radius+1)*(y-radius+1)<radius*radius)return true;
        if((x-radius+1)*(x-radius+1)+(y-radius+1)*(y-radius+1)<radius*radius)return true;
        return false;
    }
    public void fillGrids(){
        grids=new char[2*radius][2*radius];
        for(int i=0;i<2*radius;++i)
            for (int j=0;j<2*radius;++j)
                if(check(i,j))grids[i][j]=pattern;
                else grids[i][j]=' ';
    }
    public void enlarge(){
        radius++;
        fillGrids();
    }
    public void shrink(){
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int ans=0;
        for(int i=0;i<2*radius;++i)
            for (int j=0;j<2*radius;++j)
                if(grids[i][j]!=' ')ans++;
        return ans;
    }

    Circle (Location location, char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    @Override
    public String toString() {
        return "Circle: ("+location.getX()+","+location.getY()+") "+"area="+area()+" pattern="+pattern;
    }
    int getRadius(){
        return radius;
    }
}
