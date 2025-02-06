//package src;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    switch (d) {
                        case LEFT_DOWN, LEFT_UP -> grids[i][j] = pattern;
                        case RIGHT_DOWN, RIGHT_UP -> grids[i][width - 1] = pattern;
                    }
                }
                if (j != 0 && (double) (i + 1) / (double) (j) > (double) (height) / (double) (width)) {
                    switch (d) {
                        case LEFT_DOWN -> grids[i][j] = pattern;
                        case LEFT_UP -> grids[height - 1 - i][j] = pattern;
                        case RIGHT_UP -> grids[height - 1 - i][width - 1 - j] = pattern;
                        case RIGHT_DOWN -> grids[i][width - 1 - j] = pattern;
                    }
                }
                if (j != 0 && (double) (i + 1) / (double) (j) <= (double) (height) / (double) (width)) {
                    switch (d) {
                        case LEFT_DOWN -> grids[i][j] = ' ';
                        case LEFT_UP -> grids[height - 1 - i][j] = ' ';
                        case RIGHT_UP -> grids[height - 1 - i][width - 1 - j] = ' ';
                        case RIGHT_DOWN -> grids[i][width - 1 - j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;

    }

    @Override
    public void shrink() {
        height--;
        width--;

    }

    @Override
    public int area() {
        getGrids();
        int count = 0;
        for (char[] grid : grids) {
            for (char g : grid) {
                if (g == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }

//    public int getWidth() {
//        return width;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
}
