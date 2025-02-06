public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        sum=0;
        double slope = (double) this.height / this.width;
        grids = new char[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                int x = 0, y = 0;
                switch (this.d) {
                    case LEFT_DOWN -> {
                        x = i;
                        y = j;
                    }
                    case LEFT_UP -> {
                        x = this.height - 1 - i;
                        y = j;
                    }
                    case RIGHT_DOWN -> {
                        x = i;
                        y = this.width - 1 - j;
                    }
                    case RIGHT_UP -> {
                        x = this.height - 1 - i;
                        y = this.width - 1 - j;
                    }
                }
                if ((double) (i+1) / (j) > slope) {
                    grids[x][y] = pattern;
                    sum+=1;
                } else {
                    grids[x][y] = ' ';
                }
            }
        }
    }
    @Override
    public void enlarge() {
        this.height+=1;
        this.width+=1;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.height-=1;
        this.width-=1;
        this.fillGrids();
    }

    @Override
    public int area() {
        return sum;
    }
}
