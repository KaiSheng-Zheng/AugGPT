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
        double RATE = (double) this.height / this.width;

        switch (this.d) {
            case LEFT_DOWN:
                for (int i = 0; i < this.height; i++) {
                    grids[i][0] = this.pattern;
                }
                for (int i = 0; i < this.height; i++) {
                    for (int j = 1; j < this.width; j++) {
                        double rate = (double) (i + 1) / j;
                        if (rate > RATE) {
                            this.grids[i][j] = this.pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 0; i < this.height; i++) {
                    this.grids[i][0] = this.pattern;
                }
                for (int i = 0; i < this.height; i++) {
                    for (int j = 1; j < this.width; j++) {
                        double rate = (double) (this.height - i) / j;
                        if (rate > RATE) {
                            this.grids[i][j] = this.pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        double rate = (double) (this.height - i - 1) / (j + 1);
                        if (rate < RATE) {
                            this.grids[i][j] = this.pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        double rate = (double) (i) / (j + 1);
                        if (rate < RATE) {
                            this.grids[i][j] = this.pattern;
                        } else {
                            this.grids[i][j] = ' ';
                        }
                    }
                }
                break;
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