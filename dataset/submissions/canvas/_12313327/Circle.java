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
        this.grids = new char[this.radius * 2][this.radius * 2];

        for (int i = 0; i < this.radius; i++) {
            for (int j = 0; j < this.radius; j++) {
                double distance = Math.sqrt(i * i + j * j);
                if (distance < this.radius) {
                    grids[this.radius + i][this.radius + j] = pattern; // Quadrant 1
                    grids[this.radius - i - 1][this.radius + j] = pattern; // Quadrant 2
                    grids[this.radius + i][this.radius - j - 1] = pattern; // Quadrant 4
                    grids[this.radius - i - 1][this.radius - j - 1] = pattern; // Quadrant 3
                } else {
                    grids[this.radius + i][this.radius + j] = ' ';
                    grids[this.radius - i - 1][this.radius + j] = ' ';
                    grids[this.radius + i][this.radius - j - 1] = ' ';
                    grids[this.radius - i - 1][this.radius - j - 1] = ' ';
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

        radius--;
        fillGrids();

    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < this.radius * 2; i++) {
            for (int j = 0; j < this.radius * 2; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), area(), this.pattern);
    }
}

