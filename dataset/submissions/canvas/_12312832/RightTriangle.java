public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
//        this.location = location;
//        this.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        switch (d) {
            case LEFT_DOWN -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
//                        if ( j== 0) {
//                            grids[i][j] = pattern;
//                        } else
                        if ((double)width / height > (double)j / (i + 1)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }

                    }

                }
                break;
            }
            case RIGHT_UP -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
//                        if (j == width - 1) {
//                            grids[i][j] = pattern;
//                        } else
                        if ((double)height / width > (double) i / (j + 1)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }

                    }
                }
                break;

            }
            case LEFT_UP -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
//                        if (j == 0) {
//                            grids[i][j] = pattern;
//                        } else
                        if ((double)height / width > (double) i / (width - j)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }

                    }

                }
                break;

            }
            case RIGHT_DOWN -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
//                        if (i == width) {
//                            grids[i][j] = pattern;
//                        } else
                        if ((double) height / width > (double)(height - i - 1)/(j + 1)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
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
        height--;
        width--;
        fillGrids();


    }

    @Override
    public int area() {
        int sum = 0;
        for (int i = 0; i < grids.length; i ++) {
            for (int j = 0; j < grids[i].length; j ++) {
                if (grids[i][j] == pattern) {
                    sum ++;
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }
}
