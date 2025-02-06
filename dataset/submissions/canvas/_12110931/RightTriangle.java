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
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean flag = false;
                if (d == Direction.LEFT_DOWN) {
                    if (j == 0) {
                        flag = true;
                    } else {
                        double k = (double) height / width;
                        double k1 = (double) i / j;
                        double k2 = (double) (i + 1) / j;
                        double k3 = (double) i / (j + 1);
                        double k4 = (double) (i + 1) / (j + 1);
                        if (k1 <= k && k2 <= k && k3 <= k && k4 <= k) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    }
                } else if (d == Direction.RIGHT_UP) {
                    if (j == width - 1) {
                        flag = true;
                    } else {
                        double k = (double) height / width;
                        double k1 = (double) (i - height) / (j - width);
                        double k2 = (double) (i + 1 - height) / (j - width);
                        double k3 = (double) (i - height) / (j + 1 - width);
                        double k4 = (double) (i + 1 - height) / (j + 1 - width);
                        if (k1 <= k && k2 <= k && k3 <= k && k4 <= k) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    }
                } else if (d == Direction.LEFT_UP) {
                    if (j == 0) {
                        flag = true;
                    } else {
                        double k = (double) height / width;
                        double k1 = (double) (height - i) / j;
                        double k2 = (double) (height - i - 1) / j;
                        double k3 = (double) (height - i) / (j + 1);
                        double k4 = (double) (height - i - 1) / (j + 1);
                        if (k1 <= k && k2 <= k && k3 <= k && k4 <= k) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    }
                } else {
                    if (j == width - 1) {
                        flag = true;
                    } else {
                        double k = (double) height / width;
                        double k1 = (double) i / (width - j);
                        double k2 = (double) (i + 1) / (width - j);
                        double k3 = (double) i / (width - j - 1);
                        double k4 = (double) (i + 1) / (width - j - 1);
                        if (k1 <= k && k2 <= k && k3 <= k && k4 <= k) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    }
                }
                if (flag) {
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
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        int m = grids.length;
        int n = grids[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grids[i][j] != ' ') ans++;
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return "RightTriangle: (" + location.getX() + ","+location.getY() + ") " +
                "area=" + area() + " pattern=" + pattern;
    }
}