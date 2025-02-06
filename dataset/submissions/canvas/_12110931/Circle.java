public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                int a1 = (i - radius) * (i - radius) + (j - radius) * (j - radius);
                int a2 = (i + 1 - radius) * (i + 1 - radius) + (j - radius) * (j - radius);
                int a3 = (i - radius) * (i - radius) + (j + 1 - radius) * (j + 1 - radius);
                int a4 = (i + 1 - radius) * (i + 1 - radius) + (j + 1 - radius) * (j + 1 - radius);
                if (a1 >= radius*radius && a2 >= radius*radius && a3 >= radius*radius && a4 >= radius*radius) {
                    grids[i][j] = ' ';
                } else {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int m = grids.length;
        int n = grids[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grids[i][j] != ' ') ans++;
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return "Circle: (" + location.getX() + "," + location.getY() + ")" +
                " area=" + area() + " pattern=" + pattern;
    }
}