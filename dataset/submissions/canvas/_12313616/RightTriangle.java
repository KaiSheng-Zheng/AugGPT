public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        fillGrids();
    }

    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = 32;
            }
        }

        switch (d) {
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (calculateSlope(0, -height, j, - i) > calculateSlope(0, - height, width, 0)) {
                            grids[i][j] = pattern;
                        }
                    }
                }
                return;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (calculateSlope(0, 0, j + 1, i) < calculateSlope(0, 0, width, height)) {
                            grids[i][j] = pattern;
                        }
                    }
                }
                return;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (calculateSlope(0, 0, j,  i + 1) > calculateSlope(0, 0, width, height)) {
                            grids[i][j] = pattern;
                        }
                    }
                }
                return;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (calculateSlope(0, -height, j + 1, - i - 1) < calculateSlope(0, -height, width, 0)) {
                            grids[i][j] = pattern;
                        }
                    }
                }

        }
    }

    public void enlarge() {
        width++;
        height++;
        update();
    }

    public void shrink() {
        width--;
        height--;
        update();
    }

    public void update() {
        grids = new char[height][width];
        fillGrids();
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }
}
