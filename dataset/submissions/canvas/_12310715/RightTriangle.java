public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    private double k;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        k = (double) height /width;

        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (ifInside(j,i)) {
                    grids[i][j] = pattern;
                }
                else {
                    grids[i][j] = ' ';
                }
            }
        }
    }


    @Override
    public void enlarge() {
        height++;
        width++;
        grids = new char[height][width];
        k = (double) height /width;
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        grids = new char[height][width];
        k = (double) height /width;
        fillGrids();
    }

    @Override
    public int area() {
        int tempArea = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    tempArea++;
                }
            }
        }
        return tempArea;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s",location.getX(),location.getY(),area(),pattern);
    }

    private boolean ifInside (int x, int y) {

        if (d == Direction.LEFT_UP) {
            return (y < ((-1) * k * x) + height);
        }
        else if (d == Direction.LEFT_DOWN) {
            return (y + 1 > k * x);
        }
        else if (d == Direction.RIGHT_UP) {
            return (y < k * (x + 1));
        }
        else if (d == Direction.RIGHT_DOWN) {
            return (y + 1 > ((-1) * k * (x + 1)) + height);
        }
        return false;
    }

}