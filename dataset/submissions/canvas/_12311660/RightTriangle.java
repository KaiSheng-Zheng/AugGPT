import java.util.Arrays;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    @Override
    public char[][] fillGrids() {

        super.grids = new char[height][width];
        double k = 1.0 * this.height / this.width;
        this.area = 0;
        for (char[] grid : grids) {
            Arrays.fill(grid, ' ');
        }
        for (int i = 1; i <= grids.length; i++) {
            if (this.d == Direction.LEFT_UP || this.d == Direction.LEFT_DOWN) {
                grids[i - 1][0] = this.pattern;
                area++;
            } else {
                grids[i - 1][width - 1] = this.pattern;
                this.area++;
            }
            for (int col = 1; col < grids[0].length; col++) {
                if (i * 1.0 / col > k) {
                    int row = i - 1;
                    if (this.d == Direction.LEFT_DOWN) {
                        grids[row][col] = this.pattern;
                        this.area++;
                    } else if (this.d == Direction.LEFT_UP) {
                        grids[height - 1 - row][col] = this.pattern;
                        this.area++;
                    } else if (this.d == Direction.RIGHT_DOWN) {
                        grids[row][width - 1 - col] = this.pattern;
                        this.area++;
                    } else {
                        grids[height - 1 - row][width - 1 - col] = this.pattern;
                        this.area++;
                    }
                } else {
                    break;
                }
            }
        }
        return grids;
    }


    @Override
    public void enlarge() {
        width++;
        height++;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        width = Math.max(width - 1, 0);
        height = Math.max(height - 1, 0);
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (char[] row : grids) {
            for (char cell : row) {
                if (cell == pattern) count++;
            }
        }
        return count;
    }
    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(),
                area(), pattern);
    }

}
