public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location,char pattern,int width,int height,Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        if(d == Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)(height-i-1)/(double)(width-j) < (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else grids[i][j] = ' ';
                }
            }
        } else if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    if((double)(height-i)/(double)(j) > (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else grids[i][j] = ' ';
                }
                grids[i][0] = pattern;
            }
        } else if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)(height-i-1)/(double)(j+1) < (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else grids[i][j] = ' ';
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width-1; j++) {
                    if((double)(height-i)/(double)(width-j-1) > (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else grids[i][j] = ' ';
                }
                grids[i][width-1] = pattern;
            }
        }
    }
    @Override
    public void enlarge() {
        height = height+1;
        width = width+1;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        height = height-1;
        width = width-1;
        grids = new char[height][width];
        fillGrids();
    }
    @Override
    public int area() {
        int S = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    S++;
                }
            }
        }
        return S;
    }
    @Override
    public String toString() {
        int x,y;
        x = location.getX();
        y = location.getY();
        int s = area();
        return String.format("RightTriangle: ("+x+","+y+") area="+area()+" pattern="+pattern);
    }

    @Override
    public char[][] getGrids() {
        return super.getGrids();
    }
}