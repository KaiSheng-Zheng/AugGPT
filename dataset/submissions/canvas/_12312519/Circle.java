public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = Math.min(Math.max(radius, 1), 15);
        fillGrids();
    }

    @Override
    protected void fillGrids() {
        int diameter = 2 * radius ;
        grids = new char[diameter][diameter];
        int centerX = radius, centerY = radius;

        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                int[][] corners = {
                        {i, j}, {i, j + 1}, {i + 1, j}, {i + 1, j + 1}
                };
                boolean isInCircle = false;
                for (int[] corner : corners) {
                    double dx = corner[1] - centerX;
                    double dy = corner[0] - centerY;
                    if (Math.sqrt(dx * dx + dy * dy) < radius) {
                        isInCircle= true;
                        break;
                    }
                }
                if (isInCircle ) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }

            }
        }
    }

    @Override
    public int area() {
        int filledCount = 0;
        for (char[] row : grids) {
            for (char cell : row) {
                if (cell == pattern) filledCount++;
            }
        }
        return filledCount;
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.x, location.y, area(), pattern);
    }

    public static void main(String[] args) {
        Location p1 = new Location(1, 0);
        Shape s1 = new Circle(p1, '*', 5);
        char[][] grids = s1.getGrids();
        for (char[] grid : grids) {
            System.out.println(grid);
        }
        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
        s1.shrink();
        grids = s1.getGrids();
        for (char[] grid : grids) {
            System.out.println(grid);
        }
        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
    }
}
