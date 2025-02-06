public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public char[][] getGrids() {
        return grids;
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double slope = (double) height / (double) width;
        double pointSlope = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0 && (d == Direction.LEFT_UP || d == Direction.LEFT_DOWN)) {
                    pointSlope = 10000;
                }
                if (j == width - 1 && (d == Direction.RIGHT_UP || d == Direction.RIGHT_DOWN)) {
                    pointSlope = 10000;
                }
                if (d == Direction.LEFT_DOWN && j != 0) {
                    pointSlope = (double) (i + 1) / (double) j;
                }
                if (d == Direction.LEFT_UP && j != 0) {
                    pointSlope = (double) (height - i) / (double) j;
                }
                if (d == Direction.RIGHT_UP && j != width - 1) {
                    pointSlope = (double) (height - i) / (double) (width - j - 1);
                }
                if (d == Direction.RIGHT_DOWN && j != width - 1) {
                    pointSlope = (double) (i + 1) / (double) (width - j - 1);
                }
                if (pointSlope > slope) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }
    @Override
    public void shrink() {
        if (width > 1 && height > 1) {
            width--;
            height--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int filledGrids = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    filledGrids++;
                }
            }
        }
        return filledGrids;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }
}