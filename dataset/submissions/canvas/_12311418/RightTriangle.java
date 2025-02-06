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

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {

                double k = (double) width / height;
                if (d == Direction.LEFT_DOWN) {
                    if (k * (i + 1) > j) {
                        grids[i][j] = pattern; // Inside the right triangle
                    } else {
                        grids[i][j] = ' '; // Fill with space
                    }
                } else if (d == Direction.RIGHT_DOWN) {
                    if (width - k * (i + 1) < j + 1) {
                        grids[i][j] = pattern; // Inside the right triangle
                    } else {
                        grids[i][j] = ' '; // Fill with space
                    }
                } else if (d == Direction.LEFT_UP) {
                    if (width - k * i > j) {
                        grids[i][j] = pattern; // Inside the right triangle
                    } else {
                        grids[i][j] = ' '; // Fill with space
                    }
                } else if (d == Direction.RIGHT_UP) {
                    if (k * i < j + 1) {
                        grids[i][j] = pattern; // Inside the right triangle
                    } else {
                        grids[i][j] = ' '; // Fill with space
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height += 1;
        width += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        height -= 1;
        width -= 1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < getGrids().length; i++) {
            for (int j = 0; j < getGrids()[i].length; j++) {
                if (grids[i][j] != ' ') {
                    count++;
                }
            }
        }

        return count;
    }
    public String toString() {
        return "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
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
