public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[2 * radius][2 * radius];
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((radius - 1 - i) * (radius - 1 - i) + (radius - 1 - j) * (radius - 1 - j) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }

        }
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < 2 * radius; j++) {
                if ((j - radius) * (j - radius) + (radius - 1 - i) * (radius - 1 - i) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        for (int i = radius; i < 2 * radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((i - radius) * (i - radius) + (radius - 1 - j) * (radius - 1 - j) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        for (int i = radius; i < 2 * radius; i++) {
            for (int j = radius; j < 2 * radius; j++) {
                if ((j - radius) * (j - radius) + (i - radius) * (i - radius) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius = radius + 1;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        radius = radius - 1;
        this.fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), this.area(), this.pattern);
    }


}
