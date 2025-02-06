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
        this.grids = new char[this.height][this.width];
        this.countPattern = 0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                double xLeft = j;
                double xRight = (double) j + 1.0;
                double yUp = i;
                double yDown = (double) i + 1.0;
                if (this.d == Direction.LEFT_DOWN) {
                    if (yDown * this.width > xLeft * this.height) {
                        this.grids[i][j] = this.pattern;
                        this.countPattern++;
                    }
                } else if (this.d == Direction.RIGHT_UP) {
                    if (yUp * this.width < xRight * this.height) {
                        this.grids[i][j] = this.pattern;
                        this.countPattern++;
                    }
                } else if (this.d == Direction.LEFT_UP) {
                    if (xLeft * this.height + yUp * this.width < this.width * this.height) {
                        this.grids[i][j] = this.pattern;
                        this.countPattern++;
                    }
                } else if (this.d == Direction.RIGHT_DOWN) {
                    if (xRight * this.height + yDown * this.width > this.width * this.height) {
                        this.grids[i][j] = this.pattern;
                        this.countPattern++;
                    }
                }
            }
        }
    }

    public void enlarge() {
        this.width += 1;
        this.height += 1;
        fillGrids();
    }

    public void shrink() {
        this.width -= 1;
        this.height -= 1;
        fillGrids();
    }

    public int area() {
        return countPattern;
    }

    public String toString() {
        return super.toString("RightTriangle");
    }
}
