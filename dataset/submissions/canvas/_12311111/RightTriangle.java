public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        grids=new char[height][width];
        this.width=width;
        this.height=height;
        this.d=d;
        this.fillGrids();
    }
    public void fillGrids(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d==Direction.LEFT_UP){
                    if (i*width<height*(width-j)){
                        grids[i][j]=pattern;
                    }
                    grids[0][width-1]=pattern;
                    grids[height-1][0]=pattern;
                }
                if (d==Direction.LEFT_DOWN){
                    if ((i+1)*width>height*j){
                        grids[i][j]=pattern;
                    }
                    grids[0][0]=pattern;
                    grids[height-1][width-1]=pattern;
                }
                if (d==Direction.RIGHT_UP) {
                    if (i *width < height *(j+1)) {
                        grids[i][j] = pattern;
                    }
                    grids[0][0]=pattern;
                    grids[height-1][width-1]=pattern;
                }
                if (d==Direction.RIGHT_DOWN){
                    if ((i+1)*width>height*(width-1-j)){
                        grids[i][j]=pattern;
                    }
                    grids[height-1][0]=pattern;
                    grids[0][width-1]=pattern;
                }
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j]!=pattern){
                    grids[i][j]=' ';
                }
            }
        }
    }
    public void enlarge(){
        width++;
        height++;
        grids=new char[height][width];
        this.fillGrids();
    }
    public void shrink(){
        width--;
        height--;
        grids=new char[height][width];
        this.fillGrids();
    }
    public int area(){
        int count=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
}

