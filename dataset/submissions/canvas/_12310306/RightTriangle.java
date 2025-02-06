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

    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
        coordinate = new int[height + 1][width + 1];
        if (d == Direction.LEFT_UP) {
            double k = -((double) height / width);
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    if (i < k * j + height ) {
                        coordinate[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    checking(i, j);
                }
            }
        } else if (d == Direction.LEFT_DOWN) {
            double k = ((double) height / width);
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    if (i > k * j) {
                        coordinate[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    checking(i, j);
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            double k = ((double) height / width);
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    if (i < k * j) {
                        coordinate[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    checking(i, j);
                }
            }

        } else if (d == Direction.RIGHT_DOWN) {
            double k = -((double) height / width);
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    if (i > k * j + height) {
                        coordinate[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    checking(i, j);
                }
            }
        }
    }

    public void checking(int i, int j) {
        if (coordinate[i][j] == 1) {
            if (i < height && j < width)
                grids[i][j] = pattern;
            if (i >= 1 && j < width)
                grids[i - 1][j] = pattern;
            if (j >= 1 && i < height)
                grids[i][j - 1] = pattern;
            if (i >= 1 && j >= 1)
                grids[i - 1][j - 1] = pattern;
        }
    }

    public void enlarge() {
        this.width++;
        this.height++;
        fillGrids();
    }

    public void shrink() {
        if (width == 1 || height == 1)
            return;
        this.width--;
        this.height--;
        fillGrids();
    }

    public int area() {
        int num = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) num++;
            }
        }
        return num;
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }
}
