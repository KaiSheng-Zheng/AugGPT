public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    private int area;

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (ifInTriangle(j,-1*i, d, width, height)) {
                    grids[i][j] = pattern;
                    area++;
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
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area, pattern);
    }

    private static boolean ifInTriangle(int x0, int y0, Direction d, int width, int height) {
        if (d == Direction.LEFT_DOWN) {
            return (onePointIn(d, x0, y0, 0, 0, width, -1*height) ||
                    onePointIn(d, x0 + 1, y0, 0, 0, width, -1*height) ||
                    onePointIn(d, x0, y0 - 1, 0, 0, width, -1*height) ||
                    onePointIn(d, x0 + 1, y0 - 1, 0, 0, width, -1*height)
            );
        }
        if (d == Direction.RIGHT_DOWN) {
            return (onePointIn(d, x0, y0, width, 0, 0, -1*height) ||
                    onePointIn(d, x0 + 1, y0, width, 0, 0, -1*height) ||
                    onePointIn(d, x0, y0 - 1, width, 0, 0, -1*height) ||
                    onePointIn(d, x0 + 1, y0 - 1, width, 0, 0, -1*height)
            );
        }
        if (d == Direction.LEFT_UP) {
            return (onePointIn(d, x0, y0, width, 0, 0, -1*height) ||
                    onePointIn(d, x0 + 1, y0, width, 0, 0, -1*height) ||
                    onePointIn(d, x0, y0 - 1, width, 0, 0, -1*height) ||
                    onePointIn(d, x0 + 1, y0 - 1, width, 0, 0, -1*height)
            );
        }
        if (d == Direction.RIGHT_UP) {
            return (onePointIn(d, x0, y0, 0, 0, width, -1*height) ||
                    onePointIn(d, x0 + 1, y0, 0, 0, width, -1*height) ||
                    onePointIn(d, x0, y0 - 1, 0, 0, width, -1*height) ||
                    onePointIn(d, x0 + 1, y0 - 1, 0, 0, width, -1*height)
            );
        }
        return true;
    }

    private static boolean onePointIn(Direction d, int x0, int y0, int x1, int y1, int x2, int y2) {
        double k = (double) (y1 - y2) / (x1 - x2);
        double b = k * (-x1);
        if (d == Direction.LEFT_DOWN || d == Direction.RIGHT_DOWN) {
            if ((k * x0 + b) > y0) {
                return true;
            }
            if ((k * x0 + b) <= y0) {
                return false;
            }
        }
        if (d == Direction.LEFT_UP || d == Direction.RIGHT_UP) {
            if ((k * x0) + b < y0) {
                return true;
            }
            if ((k * x0 + b) >= y0) {
                return false;
            }
        }
        return true;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(pattern, location);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
}
