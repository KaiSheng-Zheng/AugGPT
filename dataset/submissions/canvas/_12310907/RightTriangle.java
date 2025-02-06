public class RightTriangle extends Shape {

    private int width;
    private int height;
    private final Direction d;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        // initialize grids with with space
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
        //rightUp
        if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 1; j <= width; j++) {
                    if (j == width) {
                        grids[i][j - 1] = pattern;
                    }
                    if (j != width && (height - i) * 1.0 / (width - j) > height * 1.0 / width) {
                        grids[i][j - 1] = pattern;
                    }
                }
            }
        }
        //leftDown
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0 && i < height) {
                        grids[i][j] = pattern;
                    }
                    if (j != 0 && i * 1.0 / j > height * 1.0 / width) {
                        grids[i-1][j] = pattern;
                    }
                }
            }
        }
        //leftUp
        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0) {
                        grids[i][j] = pattern;
                    } else if ((height - i) * 1.0 / j > height * 1.0 / width) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
        //rightDown
        if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    if (j == width) {
                        if (i < height) {
                            grids[i][j - 1] = pattern;
                        }
                    } else if (i * 1.0 / (width - j) > height * 1.0 / width) {
                        grids[i - 1][j - 1] = pattern;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        if (height > 1 && width > 1) {
            height--;
            width--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        return areaCount(grids, pattern);
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }
}






