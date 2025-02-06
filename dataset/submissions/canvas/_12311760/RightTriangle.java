public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d == Direction.LEFT_DOWN) {
                    if (width*(i+1) > height*(j)) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (d == Direction.LEFT_UP) {
                    if (width*(height-i) > height*(j)) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (d == Direction.RIGHT_DOWN) {
                    if (width*(i+1) > height*(width-j-1)) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (d == Direction.RIGHT_UP) {
                    if (width*(height-i) > height*(width-j-1)) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height ++;
        width ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        height --;
        width --;
        fillGrids();
    }

    @Override
    public int area() {
        int t = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    t ++;
                }
            }
        }
        return t;
    }
    public String toString() {
        return "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}