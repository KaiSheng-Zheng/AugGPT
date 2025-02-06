public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[this.height][this.width];
        double k = (double) this.width / this.height;
        int count=0;
        switch (this.d) {
            case LEFT_UP:
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        if (i == 0) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            double k1 = (double) (width - j) / i;
                            double k2 = (double) (width - j-1) / i;
                            double k3 = (double) (width - j) / (i + 1);
                            double k4 = (double) (width - j-1) / (i + 1);
                            if (k1 > k | k2 > k | k3 > k | k4 > k) {
                                grids[i][j] = pattern;
                                count++;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        if (i == 0) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            double k1 = (double) j / i;
                            double k2 = (double) (j + 1) / i;
                            double k3 = (double) j / (i + 1);
                            double k4 = (double) (j + 1) / (i + 1);
                            if (k1 > k | k2 > k | k3 > k | k4 > k) {
                                grids[i][j] = pattern;
                                count++;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        double k1;
                        double k2;
                        if (i == 0) {
                            k1 = 999;
                            k2 = 999;
                        } else {
                            k1 = (double) j / i;
                            k2 = (double) (j + 1) / i;
                        }
                        double k3 = (double) j / (i + 1);
                        double k4 = (double) (j + 1) / (i + 1);
                        if (k1 < k | k2 < k | k3 < k | k4 < k) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            grids[i][j] = ' ';
                        }

                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        double k1;
                        double k2;
                        if (i == 0) {
                            k1 = 999;
                            k2 = 999;
                        } else {
                            k1 = (double)(width - j) / i;
                            k2 = (double) (width - j-1) / i;
                        }
                        double k3 = (double) (width - j) / (i + 1);
                        double k4 = (double) (width - j-1) / (i + 1);
                        if (k1 < k | k2 < k | k3 < k | k4 < k) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            grids[i][j] = ' ';
                        }

                    }
                }
                break;
        }
        filledgrids = count;
    }

    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
        this.fillGrids();
    }

    @Override
    public int area() {
        return filledgrids;
    }
    @Override
    public String toString() {
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+this.pattern;
    }

}
