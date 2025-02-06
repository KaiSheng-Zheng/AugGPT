
public class RightTriangle
        extends Shape
{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location,pattern);
        this.width = width;
        this.height = height;
        m=height;
        n=width;
        this.d = d;
        fillGrids();
    }
    public void setWidth(int width) {
        this.width = width;
        fillGrids();
    }
    public void setHeight(int height) {
        this.height = height;
        fillGrids();
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int area(){
        // m and n are not updated when calling enlarge/shrink
        int area = 0;
        for (int i = 0; i <m; i++)
            for (int j = 0; j <n; j++)
                if (grids[i][j] == pattern)
                    area++;
        return area;
    }
    @Override public void fillGrids() {
        char[][] pre_grids=new char[height][width];
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++){
                if((double)(j+1)/i>(double)width/height+0.0001)
                    pre_grids[i][j]=pattern;
                else
                    pre_grids[i][j]=EMPTY;
            }
        grids=new char[height][width];
        switch(d){
            case RIGHT_UP:
                for(int i=0;i<height;i++)
                    for(int j=0;j<width;j++)
                        grids[i][j]=pre_grids[i][j];
                break;
            case LEFT_UP:
                for(int i=0;i<height;i++)
                    for(int j=0;j<width;j++)
                        grids[i][j]=pre_grids[i][width-1-j];
                break;
            case LEFT_DOWN:
                for(int i=0;i<height;i++)
                    for(int j=0;j<width;j++)
                        grids[i][j]=pre_grids[height-1-i][width-1-j];
                break;
            case RIGHT_DOWN:
                for(int i=0;i<height;i++)
                    for(int j=0;j<width;j++)
                        grids[i][j]=pre_grids[height-1-i][j];
                break;
        }
    }
    @Override public void enlarge() {
        this.height++;
        this.width++;
        fillGrids();
    }
    @Override public void shrink() {
        this.height--;
        this.width--;
        fillGrids();
    }
    @Override public String toString(){
        return String.format("RightTriangle: %s area=%d pattern=%c",location,area(),pattern);
    }
}