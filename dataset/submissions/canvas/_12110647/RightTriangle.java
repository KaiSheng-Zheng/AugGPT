/*
public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d);
    public RightTriangle(Location location, char pattern, int width, int height, Direction d);
}
*/
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

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        if(d == Direction.LEFT_UP || d == Direction.RIGHT_UP){
            for (int i = 0; i < height; i++) {
                int fillCount = (int) Math.ceil((double) (height - i) * width / height);
                int emptyCount = width - fillCount;

                for (int j = 0; j < width; j++) {
                    if ((d == Direction.LEFT_UP && j < fillCount) ||
                            (d == Direction.RIGHT_UP && j >= emptyCount)) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }else{
            for (int i = 0; i < height; i++) {
                int fillCount = (int) Math.ceil((double) (i+1) * width / height);
                int emptyCount = width - fillCount;

                for (int j = 0; j < width; j++) {
                    if((d == Direction.LEFT_DOWN && j < fillCount) ||
                            (d == Direction.RIGHT_DOWN && j >= emptyCount)) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
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
        if (width > 1 && height > 1) {
            width--;
            height--;
            fillGrids();
        }
        /*width--;
        height--;
        fillGrids();*/
    }

    @Override
    public int area() {
        int count = 0;
        for (char[] row : grids) {
            for (char cell : row) {
                if (cell == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%s", location, area(), pattern);
    }
}