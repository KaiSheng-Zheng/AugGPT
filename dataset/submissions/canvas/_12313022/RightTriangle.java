public class RightTriangle extends Shape {
    private int width;
    private int height;

    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    public void fillGrids(){
        grids=new char[height][width];
        if(d==Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(i*width<height*(j+1)) {
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else if(d==Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((j+1)*height>width*(height-i-1)) {
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else if(d==Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (height*(width-j)>width*(height-i-1)) {
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else{
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (height*(width-j)>width*i) {
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j]=' ';
                    }
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
    public void shrink(){
        if(height>=1&&width>=1){
            height--;
            width--;
            fillGrids();
        }
    }
    public int area(){
        int area=0;
        for(int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if(grids[i][j]==pattern){
                    area++;
                }
            }
        }
        return area;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(),pattern);
    }
}
