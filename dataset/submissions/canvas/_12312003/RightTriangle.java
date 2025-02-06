public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    int TriangleCount;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(pattern, location);
        this.height=height;
        this.width=width;
        this.d=d;
        fillGrids();
    }

    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        fillGrids();
    }

    @Override
    public char[][] fillGrids() {
        char [][]grid = new char[height][width];
        TriangleCount=height;
        if(d==Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
               grid[i][0]=pattern;
            }for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width-1; j++) {
                    if((double)i/j >(double) height/width){
                        grid[i-1][j]=pattern;
                        TriangleCount++;
                    }else grid[i-1][j]=' ';
                }
            }setGrids(grid);
        }if(d==Direction.LEFT_UP){
            for (int i = 0; i < height; i++) {
                grid[i][0]=pattern;
            } for (int i = 0; i <= height-1; i++) {
                for (int j = 1; j <= width-1; j++) {
                    if((double)(height-i)/j > (double)height/width){
                        grid[i][j]=pattern;
                        TriangleCount++;
                    }else grid[i][j]=' ';
                }
            }setGrids(grid);
        }if(d==Direction.RIGHT_UP){
            for (int i = 0; i < height; i++) {
                grid[i][width-1]=pattern;
            } for (int i = 0; i <= height-1; i++) {
                for (int j = 1; j <= width-1; j++) {
                    if((double)(height-i)/(width-j) > (double)height/width){
                        grid[i][j-1]=pattern;
                        TriangleCount++;
                    }else grid[i][j-1]=' ';
                }
            }
            setGrids(grid);
        }if(d==Direction.RIGHT_DOWN){
            for (int i = 0; i < height ; i++) {
                grid[i][width-1]=pattern;
            }for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width-1; j++) {
                    if((double)i/(width-j) >(double) height/width){
                        grid[i-1][j-1]=pattern;
                        TriangleCount++;
                    }else grid[i-1][j-1]=' ';
                }
            }setGrids(grid);
        }
        return grid;
    }
    @Override
    public void shrink() {
        this.width--;
        this.height--;
        fillGrids();
    }

    @Override
    public int area() {
        return TriangleCount;
    }


    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%c",location.toString(),area(),pattern);
    }
}
