public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;
    int s=0;
    public RightTriangle(Location location,char pattern,int width,int height,Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        initializeGrids(height, width);
        fillGrids();
    }
    @Override
    public void fillGrids() {
        switch (d) {
            case LEFT_UP:
                for(int x=0;x<height;x++){
                    for(int y=0;y<width;y++){
                        if(width*height-width*x> y * height){
                            grids[x][y]=pattern;
                            s++;
                        };
                    }
                }
                break;
            case LEFT_DOWN:
                for(int x=0;x<height;x++){
                    for(int y=0;y<width;y++){
                        if((x+1) *width >y * height){
                            grids[x][y]=pattern;
                            s++;
                        };
                    }
                }
                break;
            case RIGHT_UP:
                for (int x = 0; x < height; x++) {
                    for (int y = 0; y < width; y++) {
                        if ((x * width <(y+1)* height) ) {
                                grids[x][y] = pattern;
                                s++;
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for(int x=0;x<height;x++){
                    for(int y=0;y<width;y++){
                        if(width*(height-1)-x*width< (y+1) * height){
                            grids[x][y]=pattern;
                            s++;
                        };
                    }
                }
                break;
            default:break;
        }
    }
    @Override
    public void enlarge() {
        s=0;
        width++;
        height++;
        initializeGrids(height, width);
        fillGrids();
    }
    @Override
    public void shrink() {
        if(width>1&&height>1){
            s=0;
            width--;
            height--;
            initializeGrids(height, width);
            fillGrids();
        }
    }
    @Override
    public int area() {return s;}
    public String toString(){return super.toString();}
}
