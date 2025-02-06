public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double slope = (double) (height) / (width);
                switch (d) {
                    case LEFT_UP:
                        if ((double) (i) / (width - j) < slope) {
                            this.grids[i][j] = pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                        break;
                    case LEFT_DOWN: {
                        if ((double) (i + 1) / (j) > slope) {
                            this.grids[i][j] = pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                        break;
                    }

                    case RIGHT_UP:
                        if ((double) (i) / (j + 1) < slope) {
                            this.grids[i][j] = pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                        break;
                    case RIGHT_DOWN:
                        if ((double) (i + 1) / (width - j - 1) > slope) {
                            this.grids[i][j] = pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                        break;
                }
            }
        }
    }

    public void enlarge() {
        this.width += 1;
        this.height += 1;
        this.grids = new char[height][width];
        fillGrids();
    }


    public void shrink() {
        if (this.width > 1 && this.height > 1) {
            this.width -= 1;
            this.height -= 1;
            this.grids = new char[height][width];
            fillGrids();
        }
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

}