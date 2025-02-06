public class RightTriangle extends Shape {
    @Override
    public char getPattern() {
        return pattern;
    }

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
                grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double slope = (double) height / width;
                switch (d) {
                    case LEFT_UP:
                        if ((i + 0.5) < (slope * (width - j - 0.5))) {
                            grids[i][j] = pattern;
                        } else {
                            double[] x = new double[3];
                            double[] y = new double[3];
                            double[] multi = new double[2];
                            x[0] = x[1] = i - 0.5;
                            x[2] = i + 0.5;
                            y[0] = y[2] = j - 0.5;
                            y[1] = j + 0.5;
                            multi[0] = ((x[0] + 0.5) - slope * (width - y[0] - 0.5)) * ((x[2] + 0.5) - slope * (width - y[2] - 0.5));
                            multi[1] = ((x[0] + 0.5) - slope * (width - y[0] - 0.5)) * ((x[1] + 0.5) - slope * (width - y[1] - 0.5));
                            int count = 0;
                            for (int k = 0; k < 2; k++) {
                                if (multi[k] < 0) {
                                    count++;
                                }
                            }
                            if (count > 0) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
                    case LEFT_DOWN:
                        if (height - i - 0.5 <= slope * (width - j - 0.5)) {
                            grids[i][j] = pattern;
                        } else {
                            double[] x = new double[3];
                            double[] y = new double[3];
                            double[] multi = new double[2];
                            x[0] = i - 0.5;
                            x[1] = x[2] = i + 0.5;
                            y[0] = y[1] = j - 0.5;
                            y[2] = j + 0.5;
                            multi[0] = ((height - x[0] - 0.5) - slope * (width - y[0] - 0.5)) * ((height - x[1] - 0.5) - slope * (width - y[1] - 0.5));
                            multi[1] = ((height - x[2] - 0.5) - slope * (width - y[2] - 0.5)) * ((height - x[1] - 0.5) - slope * (width - y[1] - 0.5));
                            int count = 0;
                            for (int k = 0; k < 2; k++) {
                                if (multi[k] < 0) {
                                    count++;
                                }
                            }
                            if (count > 0) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
                    case RIGHT_UP:
                        if ((i + 0.5) <= slope * (j + 0.5)) {
                            grids[i][j] = pattern;
                        } else {
                            double[] x = new double[3];
                            double[] y = new double[3];
                            double[] multi = new double[2];
                            x[0] = x[1] = i - 0.5;
                            x[2] = i + 0.5;
                            y[0] = j - 0.5;
                            y[1] = y[2] = j + 0.5;
                            multi[0] = ((x[0] + 0.5) - slope * (y[0] + 0.5)) * ((x[1] + 0.5) - slope * (y[1] + 0.5));
                            multi[1] = ((x[1] + 0.5) - slope * (y[1] + 0.5)) * ((x[2] + 0.5) - slope * (y[2] + 0.5));
                            int count = 0;
                            for (int k = 0; k < 2; k++) {
                                if (multi[k] < 0) {
                                    count++;
                                }
                            }
                            if (count > 0) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
                    case RIGHT_DOWN:
                        if ((height - i - 0.5) <= slope * (j + 0.5)) {
                            grids[i][j] = pattern;
                        } else {
                            double[] x = new double[3];
                            double[] y = new double[3];
                            double[] multi = new double[2];
                            x[0] = i - 0.5;
                            x[1] = x[2] = i + 0.5;
                            y[1] = j - 0.5;
                            y[0] = y[2] = j + 0.5;
                            multi[0] = ((height - x[0] - 0.5) - slope * (y[0] + 0.5)) * ((height - x[2] - 0.5) - slope * (y[2] + 0.5));
                            multi[1] = ((height - x[1] - 0.5) - slope * (y[1] + 0.5)) * ((height - x[2] - 0.5) - slope * (y[2] + 0.5));
                            int count = 0;
                            for (int k = 0; k < 2; k++) {
                                if (multi[k] < 0) {
                                    count++;
                                }
                            }
                            if (count > 0) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
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
        return "RightTriangle: " + location + " area=" + area() + " pattern=" + pattern;
    }
}