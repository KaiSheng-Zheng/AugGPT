

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {

        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;

        fillGrids();

    }

    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        double R = (double) this.height / this.width;

        if (this.d == Direction.LEFT_DOWN || this.d == Direction.LEFT_UP) {
            R= (double) height / width;
            for (int i = 0; i < this.height; i++) {
                grids[i][0] = this.pattern;
            }
            for (int i = 0; i < this.height; i++) {
                for (int j = 1; j < this.width; j++) {
                    double rate;
                    if (this.d == Direction.LEFT_DOWN) {
                        rate = (double) (i + 1) / j;
                    } else {
                        rate = (double) (this.height - i) / j;
                    }
                    if (rate > R) {
                        grids[i][j] = this.pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (this.d == Direction.RIGHT_DOWN || this.d == Direction.RIGHT_UP) {
            for (int i = 0; i < this.height; i++) {
                for (int j = 0; j < this.width; j++) {
                    double rate;
                    if (this.d == Direction.RIGHT_DOWN) {
                        rate = (double) (this.height - i - 1) / (j + 1);
                    } else {
                        rate = (double) (i) / (j + 1);
                    }
                    if (rate < R) {
                        grids[i][j] = this.pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }




    @Override
    public void enlarge() {

        this.height++;
        this.width++;

        fillGrids();

    }

    @Override
    public void shrink() {

        this.height--;
        this.width--;

        fillGrids();

    }

    @Override
    public int area() {

        int count = 0;

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), area(), this.pattern);
    }

}