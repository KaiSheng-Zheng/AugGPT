public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        char[][] res = new char[height][width];
        grids = new char[height][width];
        double k = (double)height / (double)width;
        for(int i = 1;i <= height;i++) {
            res[i-1][0] = pattern;
            for(int j = 1;j < width;j++) {
                if(((double)i / (double)j) > k) {
                    res[i - 1][j] = pattern;
                } else {
                    res[i - 1][j] = ' ';
                }
            }
        }
        if(d == Direction.LEFT_DOWN) {
            grids = res;
        } else if (d == Direction.LEFT_UP) {
            for(int i = 0;i < height;i++) {
                for(int j = 0;j < width;j++) {
                    grids[i][j] = res[height - 1 - i][j];
                }
            }
        } else if (d == Direction.RIGHT_DOWN) {
            for(int i = 0;i < height;i++) {
                for(int j = 0;j < width;j++) {
                    grids[i][j] = res[i][width - 1 - j];
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            for(int i = 0;i < height;i++) {
                for(int j = 0;j < width;j++) {
                    grids[i][j] = res[height - 1 - i][width - 1 - j];
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height += 1;
        width += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        height -= 1;
        width -= 1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for(int i = 0;i < height;i++) {
            for(int j = 0;j < width;j++) {
                if(grids[i][j] == pattern) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%s", getClass().getName(), this.location.getX(), this.location.getY(), area(), pattern);
    }
}
