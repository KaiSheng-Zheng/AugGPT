public  class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    public void fillGrids(){
        grids=new char[height][width];
        for( int i=0;i<height;i++ ){
            for( int j =0 ; j<width;j++ ){
                grids[i][j] = ' ';
            }
        }
        char[][] map = new char[height][width];
        double slope = (double)height / (double)width;
        for(int i = 0;i < height;i++) {
            map[i][0] = pattern;
            for(int j = 1;j < width;j++) {
                //System.out.printf("$");
                if(((double)(i+1) / (double)j) > slope) {
                    map[i][j] = pattern;
                } else {
                    map[i][j] = ' ';
                }
            }
        }
        if(d == Direction.LEFT_DOWN) {
            grids = map;
        } else if (d == Direction.LEFT_UP) {
            for(int i = 0;i < height;i++) {
                for(int j = 0;j < width;j++) {
                    grids[i][j] = map[height - 1 - i][j];
                }
            }
        } else if (d == Direction.RIGHT_DOWN) {
            for(int i = 0;i < height;i++) {
                for(int j = 0;j < width;j++) {
                    grids[i][j] = map[i][width - 1 - j];
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            for(int i = 0;i < height;i++) {
                for(int j = 0;j < width;j++) {
                    grids[i][j] = map[height - 1 - i][width - 1 - j];
                }
            }
        }

    }
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        fillGrids();
    }
    public int area() {
        int num = 0;
        for(int i = 0;i < height;i++) {
            for(int j = 0;j < width;j++) {
                if(grids[i][j] == pattern) {
                    num++;
                }
            }
        }
        return num;
    }
    public String toString(){
        return "RightTriangle: ("+ location.getX()+","+location.getY()+") area="+area()+" pattern="+getPattern();
    }



}
