public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                grids[i][j] = ' ';
            }
        }
        coordinate = new int[radius * 2 + 1][radius * 2 + 1];
        for (int i = 0; i <= radius * 2; i++) {
            for (int j = 0; j <= radius * 2; j++) {
                if (distance(i, j, radius, radius) < radius) {
                    coordinate[i][j] = 1;
                }
            }
        }
        for (int i = 0; i <= radius * 2; i++) {
            for (int j = 0; j <= radius * 2; j++) {
                if (coordinate[i][j] == 1) {
                    if (i < radius * 2 && j < radius * 2)
                        grids[i][j] = pattern;
                    if (i >= 1 && j < radius * 2)
                        grids[i - 1][j] = pattern;
                    if (i < radius * 2 && j >= 1)
                        grids[i][j - 1] = pattern;
                    if (i >= 1 && j >= 1)
                        grids[i - 1][j - 1] = pattern;
                }
            }
        }
    }

    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    public void shrink() {
        if (radius == 1)
            return;
        this.radius--;
        fillGrids();

    }

    public int area() {
        int num = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j] == pattern) num++;
            }
        }
        return num;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }

}
