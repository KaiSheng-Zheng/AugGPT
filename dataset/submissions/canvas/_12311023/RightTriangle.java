import java.util.Arrays;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getD() {
        return d;
    }


    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        super.grids = new char[height][width];
        double k = 1.0 * this.height / this.width;
        this.area = 0;
        for (char[] grid : grids) {
            Arrays.fill(grid, ' ');
        }
        for (int i = 1; i <= grids.length; i++) {
            if (this.d == Direction.LEFT_UP || this.d == Direction.LEFT_DOWN) {
                grids[i - 1][0] = this.pattern;
                area++;
            } else {
                grids[i - 1][width - 1] = this.pattern;
                this.area++;
            }
            for (int col = 1; col < grids[0].length; col++) {
                if (i * 1.0 / col > k) {
                    int row = i - 1;
                    if (this.d == Direction.LEFT_DOWN) {
                        grids[row][col] = this.pattern;
                        this.area++;
                    } else if (this.d == Direction.LEFT_UP) {
                        grids[height - 1 - row][col] = this.pattern;
                        this.area++;
                    } else if (this.d == Direction.RIGHT_DOWN) {
                        grids[row][width - 1 - col] = this.pattern;
                        this.area++;
                    } else {
                        grids[height - 1 - row][width - 1 - col] = this.pattern;
                        this.area++;
                    }
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.width += 1;
        this.height += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width -= 1;
        this.height -= 1;
        fillGrids();
    }


    @Override
    public int area() {
        return super.area;
    }

    public static void main(String[] args) {
        Location p1 = new Location(0, 1);
        Shape s1 = new RightTriangle(p1, 'X', 7, 3, Direction.RIGHT_UP);
        char[][] grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
        s1.enlarge();
        grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
    }
}
