public class RightTriangle extends Shape{
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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double angle = (double)height/width;
                if((double)(height-i-1)/(width-j)<angle){
                    grids[i][j]=pattern;
                }else{
                    grids[i][j]=' ';
                }

            }
        }
        if(d==Direction.RIGHT_UP){
            for (int i = 0; i < height/2; i++) {
                for (int j = 0; j < width; j++) {
                    char t;
                    t=grids[i][j];
                    grids[i][j]=grids[height-1-i][j];
                    grids[height-1-i][j]=t;
                }

            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width/2; j++) {
                    char t;
                    t=grids[i][j];
                    grids[i][j]=grids[i][width-1-j];
                    grids[i][width-1-j]=t;
                }
            }


        } else if (d==Direction.LEFT_UP) {
            for (int i = 0; i < height/2; i++) {
                for (int j = 0; j < width; j++) {
                    char t;
                    t=grids[i][j];
                    grids[i][j]=grids[height-1-i][j];
                    grids[height-1-i][j]=t;
                }

            }

        } else if (d==Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width/2; j++) {
                    char t;
                    t=grids[i][j];
                    grids[i][j]=grids[i][width-1-j];
                    grids[i][width-1-j]=t;
                }
            }



        }

    }

    @Override
    public int area() {
        int area=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if( grids[i][j]==pattern){
                    area+=1;
                }

            }

        }
        return area;
    }

    @Override
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
    public String toString(){
        return (String.format("RightTriangle: (%d,%d) area=%d pattern=%s",location.getX(),location.getY(),area(),pattern));
    }

}
