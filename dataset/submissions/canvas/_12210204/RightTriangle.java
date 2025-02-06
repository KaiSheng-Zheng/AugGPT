public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d = Direction.LEFT_UP;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        if (d != null) {
            this.d = d;
        }
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (checkqualification(i,j,height,width,d)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j] = ' ';
                }
            }

        }
        setGrids(grids);
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
            width--;
            height--;
            fillGrids();

    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]== pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkqualification(int row, int col, int height, int width, Direction d) {
        boolean b = false;
        int x;
        int y;
        double k=tagent(height,width);
        switch (d) {
            case LEFT_UP:
                 x=col;
                 y=-row;
                if (k*x-y-height<0){
                    b=true;
                }
                break;
            case LEFT_DOWN:
                x=col;
                y=-row-1;
                if (-k*x-y>0){
                    b=true;
                }
                break;
            case RIGHT_UP:
                x=col+1;
                y=-row;
                if (-k*x-y<0) {
                    b = true;
                }

                break;
            case RIGHT_DOWN:
                 y=-row-1;
                 x=col+1;
                if (k*x-y-height>0){
                    b=true;
                }
                break;
        }
        return b;
    }

    private double tagent(int y, int x) {
        double d = (double) y / x;
        return d;
    }
}