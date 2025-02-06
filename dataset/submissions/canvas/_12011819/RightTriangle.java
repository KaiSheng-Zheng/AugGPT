public class RightTriangle extends Shape{
    private int width;
    private int height;
    private Direction d;

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        initiate();

        double slope = (double) height / (double) width;

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                double x = i + 1;
                double y = j;
                double newSlope = x / y;
                if (newSlope > slope) {
                    switch (d) {
                        case LEFT_DOWN:
                            grids[i][j] = pattern;
                            break;
                        case RIGHT_DOWN:
                            grids[i][width -1-j] = pattern;
                            break;
                        case RIGHT_UP:
                            grids[height-i-1][width -1-j] = pattern;
                            break;
                        case LEFT_UP:
                            grids[height-i-1][j] = pattern;
                            break;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }

    public void print() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                System.out.print(grids[i][j]);
            }
            System.out.println();
        }
    }
}
