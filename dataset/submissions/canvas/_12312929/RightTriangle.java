public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    int Sum = 0;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d == Direction.LEFT_DOWN ) {
                    if (height * (width - j) > width * (height - i - 1)) {
                        grids[i][j] = pattern;
                        Sum++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
                if (d == Direction.LEFT_UP ) {
                    if (height * j < width * (height - i )) {
                        grids[i][j] = pattern;
                        Sum++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
                if (d == Direction.RIGHT_DOWN ) {
                    if (height * (j + 1) > width * (height - i - 1)) {
                        grids[i][j] = pattern;
                        Sum++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
                if (d == Direction.RIGHT_UP) {
                    if (height * (width - j - 1) < width * (height - i)) {
                        grids[i][j] = pattern;
                        Sum++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }
    public void enlarge() {
        Sum = 0;
        width++;
        height++;
        fillGrids();
    }
    public void shrink() {
        Sum = 0;
        if (width > 1 && height > 1) {
            width--;
            height--;
            fillGrids();
        }
    }
    public int area() {
        return Sum;
    }
}