public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillRightTriangleGrids(pattern, width, height, d);
    }

    public void fillRightTriangleGrids(char pattern, int width, int height, Direction d) {
        grids = new char[height][width];
        char[][] temp = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double k = height*((double)(width-j)/width);
                if (i<k){
                    temp[i][j] = pattern;
                } else {
                    temp[i][j] = ' ';
                }
            }
        }
        switch (d) {
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[i][j] = temp[i][j];
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[i][width - j - 1] = temp[i][j];
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[height - i - 1][j] = temp[i][j];
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[height - i - 1][width - j - 1] = temp[i][j];
                    }
                }
        }
    }

    @Override
    public void fillGrids() {
        fillRightTriangleGrids(pattern, width, height, d);
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillRightTriangleGrids(pattern, width, height, d);
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillRightTriangleGrids(pattern, width, height, d);
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%c", location, area(), pattern);
    }
}

