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

    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d.equals(Direction.LEFT_DOWN)) {
                    if ((i + 1) * width > (j) * height) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                } else if (d.equals(Direction.RIGHT_UP)) {
                    if ((i) * width < (j + 1) * height) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                } else if (d.equals(Direction.LEFT_UP)) {
                    if ((i) * width < (width - j) * height) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                } else if (d.equals(Direction.RIGHT_DOWN)) {
                    if ((i + 1) * width > (width - j - 1) * height) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    public void shrink() {
        if (width > 1 && height > 1) {
            width--;
            height--;
            fillGrids();
        }
    }

    public int area() {
        int n=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j] == pattern){
                    n++;
                }
            }
        }
        return n;
    }
}


