import java.util.Arrays;

public class RightTriangle extends Shape{
    private int width;
    private int height;
    public int reduction=0;
    @Override
    public int getreduction() {
        return reduction;
    }
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    public int area() {
        fillGrids();
        int sum=0;
        for(char[] grid : getGrids()){
            for (char c : grid) {
                if (c==pattern) {
                    sum++;
                }
            }
        }
        return sum;
    }
    @Override
    public void enlarge() {
        setWidth(getWidth()+1);
        setHeight(getHeight()+1);
        fillGrids();
    }
    @Override
    public void shrink() {
        setWidth(getWidth()-1);
        setHeight(getHeight()-1);
        fillGrids();
    }
    public Direction getD() {
        return d;
    }
    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double k = 1.0 * this.height / this.width;
        for (char[] grid : grids) {
            Arrays.fill(grid, ' ');
        }
        for (int i = 1; i <= grids.length; i++) {
            if (this.d == Direction.LEFT_UP || this.d == Direction.LEFT_DOWN) {
                grids[i - 1][0] = this.pattern;
            } else {
                grids[i - 1][width - 1] = this.pattern;
            }
            for (int col = 1; col < grids[0].length; col++) {
                if (i * 1.0 / col > k) {
                    int row = i - 1;
                    if (this.d == Direction.LEFT_DOWN) {
                        grids[row][col] = this.pattern;
                    } else if (this.d == Direction.LEFT_UP) {
                        grids[height - 1 - row][col] = this.pattern;
                    } else if (this.d == Direction.RIGHT_DOWN) {
                        grids[row][width - 1 - col] = this.pattern;
                    } else {
                        grids[height - 1 - row][width - 1 - col] = this.pattern;
                    }
                } else {
                    break;
                }
            }
        }
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
