
public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.height = height;
        this.d = d;
        this.pattern = pattern;
        this.width = width;
        fillGrids();
    }


    @Override
    public void fillGrids() {
        grids = new char[height][width];
        switch (d) {
            case LEFT_DOWN: {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double) j / (i + 1) < (double) width / height) {
                            grids[i][j] = pattern;
                        } else grids[i][j] = ' ';
                    }
                }
                break;
            }
            case LEFT_UP: {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double) j / (height - i) < (double) width / height) {
                            grids[i][j] = pattern;
                        } else grids[i][j] = ' ';
                    }
                }
                break;
            }
            case RIGHT_UP: {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double) (j + 1) / i > (double) width / height) {
                            grids[i][j] = pattern;
                        } else grids[i][j] = ' ';
                    }
                }
                break;
            }
            case RIGHT_DOWN: {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double) (width - j - 1) / (i + 1) < (double) width / height) {
                            grids[i][j] = pattern;
                        } else grids[i][j] = ' ';
                    }
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
