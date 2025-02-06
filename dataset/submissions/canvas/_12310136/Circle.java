

public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;

    }

    @Override
    public void fillGrids() {
        grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((i + 1 - radius) * (i + 1 - radius) + (j + 1 - radius) * (j + 1 - radius) < radius * radius) {
                    super.grids[i][j] = pattern;
                    super.grids[i][2 * radius - 1 - j] = pattern;
                    super.grids[2 * radius - 1 - i][j] = pattern;
                    super.grids[2 * radius - 1 - i][2 * radius - 1 - j] = pattern;
                } else {
                    super.grids[i][j] = ' ';
                    super.grids[i][2 * radius - 1 - j] = ' ';
                    super.grids[2 * radius - 1 - i][j] = ' ';
                    super.grids[2 * radius - 1 - i][2 * radius - 1 - j] = ' ';
                }
            }

        }


    }

    @Override
    public void enlarge() {
        radius++;
    }

    @Override
    public void shrink() {
        radius--;
    }

    @Override
    public int area() {
        getGrids();
        this.fillGrids();
        int count = 0;
        for (char[] grid : grids) {
            for (char g : grid) {
                if (g == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }
}
