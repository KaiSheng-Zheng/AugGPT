public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    private int area;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super (location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void fillGrids() {
        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((double) i / (width-j) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (i+1) / (width-j) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) i / (width-(j+1)) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (i+1) / (width-(j+1)) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((double) (height-i) / (width-j) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (height-(i+1)) / (width-j) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (height-i) / (width-(j+1)) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (height-(i+1)) / (width-(j+1)) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((double) i / j < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (i+1) / j < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) i / (j+1) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (i+1) / (j+1) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        } else {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((double) (height-i) / j < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (height-(i+1)) / j < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (height-i) / (j+1) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else if ((double) (height-(i+1)) / (j+1) < (double) height / width) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }
    public void enlarge() {
        width += 1;
        height += 1;
        grids = new char[height][width];
        fillGrids();
    }
    public void shrink() {
        width -= 1;
        height -= 1;
        grids = new char[height][width];
        fillGrids();
    }
    public int area() {
        this.area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Character.valueOf(grids[i][j]) == Character.valueOf(pattern)) {
                    this.area += 1;
                }
            }
        }
        return this.area;
    }
    @Override
    public String toString() {
        area();
        return "RightTriangle: " + "(" + location.getX() + "," + location.getY() + ") area=" + area + " pattern=" + pattern;
    }
}