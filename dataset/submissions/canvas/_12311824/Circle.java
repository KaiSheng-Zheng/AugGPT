public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        int diameter = 2 * radius;
        grids = new char[diameter][diameter];
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                double distance = 0;
                if (i < radius && j < radius) {
                    distance = Math.sqrt(Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2));
                }
                if (i < radius && j >= radius) {
                    distance = Math.sqrt(Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2));
                }
                if (i >= radius && j < radius) {
                    distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j + 1 - radius, 2));
                }
                if (i >= radius && j >= radius) {
                    distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));
                }
                if (distance < radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public char[][] getGrids() {
        return grids;
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
    public int area() {
        int filledGrids = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (grids[i][j] == pattern) {
                    filledGrids++;
                }
            }
        }
        return filledGrids;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }
}
