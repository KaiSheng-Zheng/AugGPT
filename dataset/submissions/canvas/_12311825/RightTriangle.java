public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
    }
    public void fillGrids() {
        char[][] grid = new char[height][width];
        double h = height;
        double w = width;
        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j != 0) {
                        if ((h - i) / j > h / w) {
                            grid[i][j] = pattern;
                        }else {
                            grid[i][j] = ' ';
                        }
                    }else {
                        grid[i][j] = pattern;
                    }
                }
            }
        }
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j != 0) {
                        if ((i + 1.0) / j > h / w) {
                            grid[i][j] = pattern;
                        }else {
                            grid[i][j] = ' ';
                        }
                    }else {
                        grid[i][j] = pattern;
                    }
                }
            }
        }
        if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i != 0) {
                        if ((j + 1.0) / i > w / h) {
                            grid[i][j] = pattern;
                        }else {
                            grid[i][j] = ' ';
                        }
                    }else {
                        grid[i][j] = pattern;
                    }
                }
            }
        }
        if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (h != i + 1){
                        if ((j + 1) / (h - i - 1) > w / h) {
                            grid[i][j] = pattern;
                        }else {
                            grid[i][j] = ' ';
                        }
                    }else {
                        grid[i][j] = pattern;
                    }
                }
            }
        }
        grids = grid;
    }
    public void enlarge() {
        this.width = this.width + 1;
        this.height = this.height + 1;
    }
    public void shrink() {
        this.width = this.width - 1;
        this.height = this.height - 1;
    }
    public int area() {
        int area;
        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (getGrids()[i][j] == ' ') {
                    sum = sum + 1;
                }
            }
        }
        area = height * width - sum;
        return area;
    }
}
