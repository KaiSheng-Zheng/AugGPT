public class Circle extends Shape {
    private int radius;
    private int height;
    private int width;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.height = 2 * radius;
        this.width = 2 * radius;
        grids = new char[height][width];
        this.fillGrids();
    }

    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = 32;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i < radius && j < radius) {
                    if (calculateDistance(i + 1, j + 1, radius, radius) < radius) {
                        grids[i][j] = pattern;
                    }
                }

                if (i > radius && j < radius) {
                    if (calculateDistance(i, j + 1, radius, radius) < radius) {
                        grids[i][j] = pattern;
                    }
                }

                if (i < radius && j > radius) {
                    if (calculateDistance(i + 1, j, radius, radius) < radius) {
                        grids[i][j] = pattern;
                    }
                }

                if (i > radius && j > radius) {
                    if (calculateDistance(i, j, radius, radius) < radius) {
                        grids[i][j] = pattern;
                    }
                }

                if (i == radius || j == radius) {
                    grids[i][j] = pattern;
                }

            }
        }
    }

    public void enlarge() {
        radius++;
        height = 2 * radius;
        width = 2 * radius;
        update();
    }

    public void shrink() {
        radius--;
        height = 2 * radius;
        width = 2 * radius;
        update();
    }

    public void update() {
        grids = new char[height][width];
        fillGrids();
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    count++;
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
