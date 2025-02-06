public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        grids=new char[height][width];
        fillGrids();
    }
    @Override
    public void fillGrids(){
        char[][]Grids=new char[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Grids[i][j]=' ';
            }
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                double k0=(double)height/(double)width;
                double k1=(double)(i+1)/(double)j;
                if(k1>k0||j==0){
                    if (d == Direction.LEFT_DOWN) {
                        Grids[i][j]=pattern;
                    }
                    if (d == Direction.LEFT_UP) {
                        Grids[height-i-1][j]=pattern;
                    }
                    if (d == Direction.RIGHT_DOWN) {
                        Grids[i][width-j-1]=pattern;
                    }
                    if (d == Direction.RIGHT_UP) {
                        Grids[height-i-1][width-j-1]=pattern;
                    }
                }
            }
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                grids[i][j]=Grids[i][j];
            }
        }
    }
    @Override
    public void enlarge(){
        height++;
        width++;
        grids=new char[height][width];
        fillGrids();
    }
    @Override
    public void shrink(){
        height--;
        width--;
        grids=new char[height][width];
        fillGrids();
    }
    @Override
    public int area(){
        int count=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        int x= location.getX();
        int y= location.getY();
        int area=area();
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",x,y,area,pattern);
    }
}