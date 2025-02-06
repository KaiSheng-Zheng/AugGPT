public class RightTriangle extends Shape{
    private int Area;
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.Area=0;
        this.location=location;
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    public void fillGrids(){
        Area=0;
        double p=(double)height/width;
        grids=new char[height][width];
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++)
                grids[i][j]=' ';
        if(d==Direction.LEFT_UP)
        {
            for(int i=0;i<height;i++)
            {
                for(int j=0;j<width;j++)
                {
                    if(j==0){
                        grids[i][j]=pattern;
                        Area++;
                        continue;
                    }
                    double pp=(double)(height-i)/(j);
                    if ( pp > p ) {
                        grids[i][j]=pattern;
                        Area++;
                    }
                    else break;
                }
            }
        }
        else if(d==Direction.RIGHT_UP){
            for(int i=0;i<height;i++)
            {
                for(int j=1;j<=width;j++)
                {
                    if(width==j){
                        grids[i][j-1]=pattern;
                        Area++;
                        continue;
                    }
                    double pp=(double)(height-i)/(width-j);
                    if(pp>p){
                        grids[i][j-1]=pattern;
                        Area++;
                    }
                }
            }
        }
        else if(d==Direction.RIGHT_DOWN){
            for(int i=1;i<=height;i++) {
                for(int j=1;j<=width;j++){
                    if(j==width){
                        grids[i-1][j-1]=pattern;
                        Area++;
                        continue;
                    }
                    double pp=(double)(i)/(width-j);
                    if(pp>p){
                        grids[i-1][j-1]=pattern;
                        Area++;
                    }
                }
            }
        }
        else {
            for(int i=1;i<=height;i++) {
                for(int j=0;j<width;j++)
                {
                    if(j==0){
                        grids[i-1][j]=pattern;
                        Area++;
                        continue;
                    }
                    double pp=(double)i/j;
                    if(pp>p){
                        grids[i-1][j]=pattern;
                        Area++;
                    }
                    else break;
                }
            }
        }
    }
    public void enlarge(){
        height++;width++;
        fillGrids();
    }
    public void shrink(){
        height--;width--;
        fillGrids();
    }
    public int area(){
        if(Area==0)fillGrids();
        return Area;
    }
    public String toString()
    {
        return "RightTriangle: (" + location.getX() + ','+ location.getY() + ") area=" +area()+" pattern="+pattern;
    }
}
