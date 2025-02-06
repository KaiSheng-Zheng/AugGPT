public class RightTriangle extends Shape {
    private int base;
    private int height;
    private Direction direction;

    public RightTriangle(Location location, char pattern, int base, int height, Direction direction) {
        super(location, pattern);
        this.base = Math.min(Math.max(base, 1), 20);
        this.height = Math.min(Math.max(height, 1), 20);
        this.direction = direction;
        fillGrids();
    }

    @Override
    protected void fillGrids() {
        grids = new char[height][base];
        double slope = (double) height / base;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                grids[i][j] = ' ';
                int[][] corners = {
                        {i, j}, {i, j + 1}, {i + 1, j}, {i + 1, j + 1}
                };
                for (int[] corner : corners) {
                    double dx = corner[1];
                    double dy = corner[0];

                    switch (direction) {
                        case LEFT_DOWN:
                            if (dy / dx > slope) {
                                grids[i][j] = pattern;
                        }
                            break;
                        case RIGHT_UP:
                            if (dy / dx < slope) {
                                grids[i][j] = pattern;
                        }
                            break;
                        case RIGHT_DOWN:
                            if (dy / (base - dx) > slope) {
                                grids[i][j] = pattern;
                        }
                            break;
                        case LEFT_UP:
                            if (dy /(base - dx)  < slope) {
                                grids[i][j] = pattern;
                        }
                            break;
                    }
                }
            }
        }
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void enlarge() {
        base++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        if (base > 1 && height > 1) {
            base--;
            height--;
            fillGrids();
        }
    }
    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.x, location.y, area(), pattern);
    }
    public static void main(String[] args) {
        Location p1 = new Location(0, 1);
        Shape s1 = new RightTriangle(p1, 'X',4 , 6, Direction.RIGHT_UP);
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