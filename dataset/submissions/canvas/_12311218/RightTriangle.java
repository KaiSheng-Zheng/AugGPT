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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void fillGrids(){
        area=0;
        grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (checkUnder(i, j, width, height)) {
                    switch (d){
                        case LEFT_DOWN ->grids[i][j]=pattern;
                        case LEFT_UP -> grids[height-1-i][j]=pattern;
                        case RIGHT_DOWN -> grids[i][width-1-j]=pattern;
                        case RIGHT_UP -> grids[height-1-i][width-1-j]=pattern;
                    };
                    area++;
                }
                else {
                    switch (d) {
                        case LEFT_DOWN -> grids[i][j] = ' ';
                        case LEFT_UP -> grids[height - 1 - i][j] = ' ';
                        case RIGHT_DOWN -> grids[i][width - 1 - j] = ' ';
                        case RIGHT_UP -> grids[height - 1 - i][width - 1 - j] = ' ';
                    }
                }
            }
        }
    }
    public static boolean checkUnder(int x,int y,int width,int height){
        return (height*(y)-width*(x+1))<0;
    }
    //y-kx<=0,hy-wx<=0;

    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
        this.fillGrids();

    }

    @Override
    public int area() {
        return area;
    }
    public String toString(){
        return String.format("RightTriangle: "+location+" area="+area+" pattern="+pattern);
    }


}
