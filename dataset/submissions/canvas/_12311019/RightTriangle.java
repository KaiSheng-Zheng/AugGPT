public class RightTriangle extends Shape {
    private final Direction d;
    private int height;
    private int width;

    public RightTriangle(Location location, char pattern, int width, int height, Direction direction) {
        super(location, pattern);
        this.height = height;
        this.width = width;
        this.d = direction;
        fillGrids();
    }

    public void fillGrids() {
        grids = new char[height][width];
        double tan = (double) height / width;
        switch (d) {
            case LEFT_UP: {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (i == 0 || j == 0) {
                            grids[i][j] = pattern;
                        } else {
                            double Gtan = (double) (height - i) / j;
                            if (Gtan > tan) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                    }
                }
                break;
            }
            case RIGHT_UP: {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (i == 0 || j == width - 1) {
                            grids[i][j] = pattern;
                        } else {
                            int x = j + 1;
                            int y = i;
                            double Gtan = (double) (height - y) / (width - x);
                            if (Gtan > tan) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                    }
                }
                break;
            }
            case LEFT_DOWN: {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (i == height - 1 || j == 0) {
                            grids[i][j] = pattern;
                        } else {
                            int x = j;
                            int y = i + 1;
                            double Gtan = (double) y / x;
                            if (Gtan > tan) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                    }
                }
                break;
            }
            case RIGHT_DOWN:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (i == height - 1 || j == width - 1) {
                            grids[i][j] = pattern;
                        } else {
                            int x = j + 1;
                            int y = i + 1;
                            double Gtan = (double) y / (width - x);
                            if (Gtan > tan) {
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                    }
                }
                break;
        }
    }

    public void enlarge() {
        this.width++;
        this.height++;
        fillGrids();
    }

    public void shrink() {
        this.width--;
        this.height--;
        fillGrids();
    }

    public int area() {
        int area = 0;
        for (char[] inner : grids) {
            for (char c : inner) {
                if (c == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }

    public int getHeight()
    {return height;}
    public int getWidth()
    {return width;}
}