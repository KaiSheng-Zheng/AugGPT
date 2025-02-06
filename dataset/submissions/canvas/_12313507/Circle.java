public class Circle extends Shape {
    //Fields
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
        super.className = "Circle";
    }

    @Override
    public void fillGrids() {
        int gridLength = 2 * radius;
        super.grids = new char[gridLength][gridLength];
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                super.grids[i][j] = isInCircle(i, j, new Location(0, 0)) ? pattern : ' ';
            }
        }
    }

    public boolean isInCircle(int x, int y, Location location) {
        Location center = new Location(location.getX() + radius, location.getY() + radius);
        int relativeX = x - center.getX() + (x < center.getX() ? 1 : 0);
        int relativeY = y - center.getY() + (y < center.getY() ? 1 : 0);
        double distanceFromCenter = Math.sqrt(relativeX * relativeX + relativeY * relativeY);
        return distanceFromCenter < radius;
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
        int count = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (super.grids[i][j] == pattern) count++;
            }
        }
        return count;
    }

}
