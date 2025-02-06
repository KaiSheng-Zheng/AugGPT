public class Circle extends Shape{
    private int radius;
    private int Area;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        Area=0;
        this.location=location;
        this.pattern=pattern;
        this.radius=radius;
        fillGrids();
    }
    private void fill(int x,int y)
    {
        grids[x][y]=pattern;
    }
    public void fillGrids(){
        int max=radius*2;
        Area=0;
        grids=new char[max][max];
        for(int i=0;i<max;i++)
            for(int j=0;j<max;j++)
                grids[i][j]=' ';
        for(int i=0;i<=max;i++)
        {
            for(int j=0;j<=max;j++)
            {
                int d=(i-radius)*(i-radius)+(j-radius)*(j-radius);
                if(d<radius*radius){
                    if(i<=radius&&j<=radius){
                        fill(i-1,j-1);
                        Area++;
                    }
                    if(i>=radius&&j<=radius){
                        fill(i,j-1);
                        Area++;
                    }
                    if(i<=radius&&j>=radius){
                        fill(i-1,j);
                        Area++;
                    }
                    if(i>=radius&&j>=radius){
                        fill(i,j);
                        Area++;
                    }
                }
            }
        }
    }
    public void enlarge(){
        radius++;
        fillGrids();
    }
    public void shrink(){
        radius--;
        fillGrids();
    }
    public int area(){
        if(Area==0)fillGrids();
        return Area;
    }
    public String toString(){
        if(Area==0)fillGrids();
        return "Circle: (" + location.getX()+ ',' + location.getY() + ") area=" + area()+" pattern=" + pattern;
    }
}
