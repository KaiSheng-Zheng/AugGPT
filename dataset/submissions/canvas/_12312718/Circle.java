public class Circle extends Shape {
    private int radius;
    private int area;

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        area = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (isInCircle(i, j, radius)) {
                    grids[i][j] = pattern;
                    area++;
                } else {
                    grids[i][j] = ' ';
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
        return area;
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area, pattern);
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static boolean isInCircle(int row, int column, int radius) {
        return (distance(row, column, radius, radius) < radius ||
                distance(row + 1, column, radius, radius) < radius ||
                distance(row, column + 1, radius, radius) < radius ||
                distance(row + 1, column + 1, radius, radius) < radius
        );
    }

    public Circle(Location location, char pattern, int radius) {
        super(pattern, location);
        this.radius = radius;
        fillGrids();
    }
}