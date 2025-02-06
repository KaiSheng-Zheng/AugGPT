public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                double distanceRightDown = Math.sqrt(Math.pow(radius - 1 - i, 2) + Math.pow(radius - 1 - j, 2));
                if (distanceRightDown < radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (i >= radius && j >= radius) {
                    grids[i][j] = grids[radius * 2 - i - 1][radius * 2 - j - 1];
                } else if (i >= radius) {
                    grids[i][j] = grids[radius * 2 - i - 1][j];
                } else if (j >= radius) {
                    grids[i][j] = grids[i][radius * 2 - j - 1];
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int counter = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == pattern) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
