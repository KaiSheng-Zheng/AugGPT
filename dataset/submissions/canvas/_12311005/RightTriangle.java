public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        this.location = location;
        this.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;
    }

    @Override
    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    @Override
    public char[][] getGrids() {

        return grids;
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        setGrids(grids);
        double Slope = (double) height / width ;
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0) {
                        grids[i][j] = pattern;
                    }
                    else  {
                        double slope = (double) (i + 1) / j;
                        if (slope > Slope) {
                            grids[i][j] = pattern;
                    } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
            setGrids(grids);
        }
        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0) {
                        grids[i][j] = pattern;
                    }
                    if (j != 0) {
                        double slope = (double) (height - i) / j;
                        if (slope > Slope) {
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                    }
                    }
                }
            }
            setGrids(grids);
        }
        if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == width - 1) {
                        grids[i][j] = pattern;
                    }
                    if (j != width - 1) {
                        double slope = (double) (i + 1) / (width - j - 1);
                        if (slope > Slope) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                    }
                    }
                }
            }
            setGrids(grids);
        }
        if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == width - 1) {
                        grids[i][j] = pattern;
                    }
                    if (j != width - 1) {
                        double slope = (double) (height - i) / (width - j-1 );
                        if (slope > Slope) {
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                    }
                    }
                }
            }
            setGrids(grids);
        }
    }

    @Override
    public void enlarge() {
        height += 1;
        width += 1;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        height -= 1;
        width -= 1;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        fillGrids();
        int area = 0;
        char[][] chars = getGrids();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == pattern) {
                    area += 1;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "(" + location.getX() + "," + location.getY() + ") " + "area=" + area() + " pattern=" + pattern;
    }
}