public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location,char pattern, int width,int height,Direction d){
        super(location,pattern);
        this.d=d;
        this.width=width;
        this.height=height;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j]=' ';
            }
        }double slope;
        switch (d) {
            case LEFT_DOWN -> {
                for (int i = 1; i <= height; i++) {
                    for (int j = 0; j <= width; j++) {
                        slope = (double) height / width;
                        if ((double) i / j > slope) grids[i-1][j]=pattern;
                    }
                }
            }
            case LEFT_UP -> {
                for (int i = 1; i <= height; i++) {
                    for (int j = 0; j <= width; j++) {
                        slope = (double) height / width;
                        if ((double) i / j > slope) grids[height-i][j]=pattern;
                    }
                }
            }
            case RIGHT_DOWN -> {
                for (int i = 1; i <= height; i++) {
                    for (int j = 0; j <= width; j++) {
                        slope = (double) height / width;
                        if ((double) i / j > slope) grids[i-1][width-j-1]=pattern;
                    }
                }
            }
            case RIGHT_UP -> {
                for (int i = 1; i <= height; i++) {
                    for (int j = 0; j <= width; j++) {
                        slope = (double) height / width;
                        if ((double) i / j > slope) grids[height-i][width-j-1]=pattern;
                    }
                }
            }
        }
    }
    @Override
    public void enlarge() {
        height+=1;
        width+=1;
        fillGrids();
    }

    @Override
    public void shrink() {
        height-=1;
        width-=1;
        fillGrids();
    }

    @Override
    public int area() {
        double slope;
        int count=0;
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                slope = (double) height / width;
                if ((double) i / j > slope) count++;
            }
        }
    return count;
    }

    public String toString(){
        return ("RightTriangle: (%d,%d) area=%d pattern=%c".formatted(this.getLocation().getX(),this.getLocation().getY(),this.area(),this.getPattern()));
    }
}
