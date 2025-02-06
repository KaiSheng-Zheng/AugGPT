public class RightTriangle extends Shape {

    private int width;
    private int height;
    private Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.d = d;
        this.height=height;
        this.width=width;
        fillGrids();
    }




    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                double slope= (double) height /width;
                if ((d == Direction.LEFT_UP && slope > ((double) (i) /(width-j)) ||
                        (d == Direction.LEFT_DOWN && slope < (double) (i+1)/j) )||
                        (d == Direction.RIGHT_UP && slope > (double)  i/(j+1))  ||
                        (d == Direction.RIGHT_DOWN && slope < (double) (i+1)/(width-j-1))) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(),area(),pattern);
    }
}
