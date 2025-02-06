

import java.util.Arrays;
import java.util.List;


public class    RightTriangle extends Shape implements ShapeCanvas{
    private int width;


    private int height;

    public int count = 0;

    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        this.fillGrids();
    }

    public RightTriangle(Location location, char pattern, Direction d) {
        super(location, pattern);
        this.d = d;

    }

    @Override
    public void fillGrids() {
        super.grids = new char[height][width];
        double k = 1.0 * this.height / this.width;
        this.count = 0;
        for (char[] grid : grids) {
            Arrays.fill(grid, ' ');
        }
        for (int i = 1; i <= grids.length; i++) {
            if (this.d == Direction.LEFT_UP || this.d == Direction.LEFT_DOWN) {
                grids[i - 1][0] = this.pattern;
                count++;
            } else {
                grids[i - 1][width - 1] = this.pattern;
                count++;
            }
            for (int col = 1; col < grids[0].length; col++) {
                if (i * 1.0 / col > k) {
                    int row = i - 1;
                    if (this.d == Direction.LEFT_DOWN) {
                        grids[row][col] = this.pattern;
                        count++;
                    } else if (this.d == Direction.LEFT_UP) {
                        grids[height - 1 - row][col] = this.pattern;
                        count++;
                    } else if (this.d == Direction.RIGHT_DOWN) {
                        grids[row][width - 1 - col] = this.pattern;
                       count++;
                    } else {
                        grids[height - 1 - row][width - 1 - col] = this.pattern;
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
    }


    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        this.grids = new char[this.height][this.width];
        count = 0;
        this.fillGrids();


    }

    @Override
    public void shrink() {
        this.height--;
        this.width--;
        this.grids = new char[this.height][this.width];
        count = 0;
        this.fillGrids();

    }

    @Override
    public int area() {

        return this.count;
    }

    public String toString() {
        return "RightTriangle: " + location.toString() + " area="
                + area() + " pattern=" + pattern;

    }
    public char getPattern(){
        return pattern;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        return false;
    }

    @Override
    public char[][] getCanvas() {
        return new char[0][];
    }

    @Override
    public int getShapeCount() {
        return 0;
    }

    @Override
    public int getSpaceGridCount() {
        return 0;
    }

    @Override
    public List<Shape> getShapesByArea() {
        return null;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        return null;
    }


}
