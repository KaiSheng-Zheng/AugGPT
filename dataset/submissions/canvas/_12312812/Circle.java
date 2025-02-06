public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (i < radius & j < radius) {
                    if (radius * radius > (radius - 1 - i) * (radius - 1 - i) + (radius - 1 - j) * (radius - 1 - j)) {
                        grids[i][j] = pattern;
                    } else grids[i][j] = ' ';
                } else if (i < radius & j + 1 > radius) {
                    if (radius * radius > (radius - 1 - i) * (radius - 1 - i) + (radius - j) * (radius - j)) {
                        grids[i][j] = pattern;
                    } else grids[i][j] = ' ';
                } else if (i + 1 > radius & j < radius) {
                    if (radius * radius > (radius - i) * (radius - i) + (radius - 1 - j) * (radius - 1 - j)) {
                        grids[i][j] = pattern;
                    } else grids[i][j] = ' ';
                } else if (i + 1 > radius & j + 1 > radius) {
                    if (radius * radius > (radius - i) * (radius - i) + (radius - j) * (radius - j)) {
                        grids[i][j] = pattern;
                    } else grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -= 1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
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
