

public class Circle extends Shape {
    private int radius;

    private final int[][] DIRECTIONS = {
            {-1, -1}, // top-left
            {-1, 0},  // top
            {-1, 1},  // top-right
            {0, -1},  // left
            {0, 1},   // right
            {1, -1},  // bottom-left
            {1, 0},   // bottom
            {1, 1}    // bottom-right
    };

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        int diameter = radius * 2;
        grids = new char[diameter][diameter];
        int cx = radius;
        int cy = radius;

        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                int dx = i - cx;
                int dy = j - cy;
                if (dx > 0) {
                    dx++;
                }
                if (dy > 0) {
                    dy++;
                }
//                if (i == 8 && j == 9){
//                    System.out.println("");
//                }
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance <= radius) {
                    grids[i][j] = pattern;
                } else {
                    boolean p = true;
                    for (int k = 0; k < 8; ++k) {
                        distance = Math.sqrt((DIRECTIONS[k][0] + dx) * (DIRECTIONS[k][0] + dx) + (DIRECTIONS[k][1] + dy) * (DIRECTIONS[k][1]  + dy));
                        if (distance < radius){
                            grids[i][j] = pattern;
                            p = false;
                            break;
                        }
                    }
                    if (p){
                    grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        if (radius < 15) {
            radius++;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int count = 0;
        for (char[] row : grids) {

            int k = 0;
            for (char cell : row) {
                if (cell == pattern) {
                    count++;
                    k++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }
}
