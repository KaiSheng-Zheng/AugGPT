public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction direction;
    int sum;
    public RightTriangle(Location location,char pattern,int width, int height,Direction direction) {
        super(location , pattern);
        this.width = width;
        this.height = height;
        this.direction = direction;
        grids = new char[height][width];
        fillGrids();
    }
    public char[][] getGrids(){
        return grids;
    }
    public void fillGrids() {


        if(direction==Direction.LEFT_DOWN){
            int sum=0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double) (height-i-1)/ (double)(width-j) < (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
        if(direction==Direction.RIGHT_UP){
            int sum=0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width ; j++) {
                    if((double) (i)/ (double)(j+1) < (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
        if(direction==Direction.LEFT_UP){
            int sum=0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width ; j++) {
                    if((double) (i)/ (double)(width - j) < (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else grids[i][j] = ' ';
                }
            }
        }
        if(direction==Direction.RIGHT_DOWN){
            int sum=0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double) (i+1)/ (double)(width - j-1) > (double)height/(double)width){
                        grids[i][j] = pattern;
                    }else grids[i][j] = ' ';
                }
            }
        }
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grids[i][j]==pattern){
                    sum++;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width+=1;
        height+=1;
        grids = new char[height][width];
        sum=0;
        fillGrids();
    }

    @Override
    public void shrink() {
        width-=1;
        height-=1;
        grids = new char[height][width];
        sum=0;
        fillGrids();
    }

    @Override
    public int area() {
        return sum;
    }

    @Override
    public String toString() {
        int x = location.getX(), y = location.getY();
        sum=0;
        fillGrids();
        int m = area();
        return ("RightTriangle: (" + x + "," + y + ") area=" + m + " pattern=" + pattern);
    }
}
