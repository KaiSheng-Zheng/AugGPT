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
        float k = (float) height / width;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                   
                    grids[i][j] = pattern;

                } else {
             
                    double xie = (double) (i + 1) / (j);
                    if (xie > k) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }

    
        if (d == Direction.RIGHT_DOWN) {
            char[][] newGrids = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
//                    newGrids[height - i - 1][j] = grids[i][j];
                    newGrids[i][width - j - 1] = grids[i][j];
                }

            }
            grids = newGrids;
        } else if (d == Direction.LEFT_UP) {
            char[][] newGrids = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
//                    newGrids[i][width - j - 1] = grids[i][j];
                    newGrids[height - i - 1][j] = grids[i][j];
                }
            }
            grids = newGrids;
        } else if (d == Direction.RIGHT_UP) {
            char[][] newGrids = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    newGrids[height - i - 1][width - j - 1] = grids[i][j];
                }
            }
            grids = newGrids;
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
        if (width > 0 && height > 0) {
            width--;
            height--;
            fillGrids();
        }
    }

    @Override
    public int area() {
   
        int area = 0;
        for (char[] line : grids) {
            for (char c : line) {
                if (c != ' ') {
                    area++;
                }
            }
        }
        return area;
    }
}