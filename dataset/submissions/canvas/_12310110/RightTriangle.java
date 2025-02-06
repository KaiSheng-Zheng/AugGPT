public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.height = height;
        this.width = width;
        this.d = d;
        fillGrids();
    }
    @Override
    public void fillGrids(char[][] canvas, int x, int y) {
        double h = height;
        double w = width;
        grids = new char[height][width];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(d==Direction.LEFT_UP){
                    if(i+h/w*j-h<0){
                        grids[i][j] = pattern;
                    }
                }
                if (d==Direction.LEFT_DOWN){
                    if((i+1)-h/w*j>0){
                        grids[i][j] = pattern;
                    }
                }
                if (d==Direction.RIGHT_DOWN){
                    if ((i+1)+h/w*(j+1)-h>0){
                        grids[i][j] = pattern;
                    }
                }
                if (d==Direction.RIGHT_UP){
                    if(i-h/w*(j+1)<0){
                        grids[i][j] = pattern;
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]!=' '){canvas[i+x][j+y] = grids[i][j];}
            }
        }
    }
    public void fillGrids() {
        double h = height;
        double w = width;
        grids = new char[height][width];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(d==Direction.LEFT_UP){
                    if(i+h/w*j-h<0){
                        grids[i][j] = pattern;
                    }
                }
                if (d==Direction.LEFT_DOWN){
                    if((i+1)-h/w*j>0){
                        grids[i][j] = pattern;
                    }
                }
                if (d==Direction.RIGHT_DOWN){
                    if ((i+1)+h/w*(j+1)-h>0){
                        grids[i][j] = pattern;
                    }
                }
                if (d==Direction.RIGHT_UP){
                    if(i-h/w*(j+1)<0){
                        grids[i][j] = pattern;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.height++;
        this.width++;
        fillGrids();
    }
    @Override
    public void shrink() {
        this.height--;
        this.width--;
        fillGrids();
    }
//
    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}
