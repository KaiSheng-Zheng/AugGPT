public class RightTriangle extends Shape {
    private int base;
    private int height;
    private Direction direction;

    public RightTriangle(Location location, char pattern, int base, int height, Direction direction) {
        super(location, pattern);
        this.base = base;
        this.height = height;
        this.direction = direction;
        this.grids = new char[height][base];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                grids[i][j] = ' ';
            }
        }


        if (direction == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < base; j++) {
                    if (height * (j + 1) > base * i)
                        grids[i][j] = pattern;
                }
            }
        } else if (direction == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < base; j++) {
                    if (height * (base - j) > base * i)
                        grids[i][j] = pattern;
                }
            }
        } else if (direction == Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < base; j++) {
                    if (height * (base - j - 1) < base * (i + 1))
                        grids[i][j] = pattern;
                }
            }
        } else if (direction == Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < base; j++) {
                    if (height * j < base * (i + 1))
                        grids[i][j] = pattern;
                }
            }
        }
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public char[][] getGrids() {
        return grids;
    }

    @Override
    public void enlarge() {
        base += 1;
        height += 1;
        grids = new char[height][base];
        fillGrids();
    }

    @Override
    public void shrink() {
        if (base > 1 && height > 1) {
            base -= 1;
            height -= 1;
        }
        grids = new char[height][base];
        fillGrids();
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%c", location.toString(), area(), pattern);
    }
}