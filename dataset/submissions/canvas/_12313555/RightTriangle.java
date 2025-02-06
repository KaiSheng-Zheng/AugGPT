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

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        switch (d) {
            case LEFT_DOWN:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double)(height - i - 1) / (width - j) < (double)height / width) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double)(height - i - 1) / (j + 1) < (double)height / width) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;

            case RIGHT_UP:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double)(i) / (j + 1) <(double) height / width) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double)(i) / (width-j) < (double)height / width) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    public void shrink() {
        height--;
        width--;
        fillGrids();
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < width; j++) {
                if ((double) (height - i - 1) / (width - j) < (double) height / width) {
                    count++;
                }
            }
        }
        return count;
    }

        public String toString() {
            return (String.format("RightTriangle: (%s,%s) area=%s pattern=%s", location.getX(), location.getY(), area(), pattern));
        }
}
