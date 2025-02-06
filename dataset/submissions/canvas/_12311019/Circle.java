public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char C, int radium) {
        super(location, C);
        this.radius = radium;
        fillGrids();
    }

    public void fillGrids() {
        grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                int x = i + 1;
                int y = j + 1;
                int center = radius;
                int distance = (center - x) * (center - x) + (center - y) * (center - y);
                if (distance < radius * radius) {
                    grids[i][j] = pattern;
                    grids[2 * radius - 1 - i][j] = pattern;
                    grids[i][2 * radius - j - 1] = pattern;
                    grids[2 * radius - 1 - i][2 * radius - j - 1] = pattern;
                } else {
                    grids[i][j] = ' ';
                    grids[2 * radius - 1 - i][j] = ' ';
                    grids[i][2 * radius - j - 1] = ' ';
                    grids[2 * radius - 1 - i][2 * radius - j - 1] = ' ';
                }
            }
        }
    }

    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    public void shrink() {
        this.radius--;
        fillGrids();
    }

    public int area() {
        int area = 0;
        for (char[] inner : grids) {
            for (char c : inner) {
                if (c == pattern) {
                    area++;
                }
            }
        }
        return area;
    }
    public int getRadius()
    {
        return radius;
    }
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s", location.getX(), location.getY(), area(), pattern);
    }
}