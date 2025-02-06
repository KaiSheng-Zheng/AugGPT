public class RightTriangle extends Shape {
    //Fields
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
        super.className = "RightTriangle";
    }


    @Override
    public void fillGrids() {
        super.grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                super.grids[i][j] = isInRT(i, j, new Location(0, 0)) ? pattern : ' ';
            }
        }
    }

    public boolean isInRT(int i, int j, Location location) {
        switch (d) {
            case LEFT_UP:
                return ((double) (i - location.getX()) * width < (double) width * height - (double) (j - location.getY()) * height
                        && (i >= location.getX()) && (j >= location.getY()));
            case LEFT_DOWN:
                i++;
                return (double) (j - location.getY()) * height < (double) (i - location.getX()) * width
                        && (i <= location.getX() + height) && (j >= location.getY());
            case RIGHT_UP:
                j++;
                return (double) (j - location.getY()) * height > (double) (i - location.getX()) * width
                        && (i >= location.getX()) && (j <= location.getY() + width);
            case RIGHT_DOWN:
                i++;
                j++;
                return ((double) (i - location.getX()) * width > (double) width * height - (double) (j - location.getY()) * height
                        && (i <= location.getX() + height) && (j <= location.getY() + width));
            default:
                return false;
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (super.grids[i][j] == pattern) count++;
            }
        }
        return count;
    }

}
