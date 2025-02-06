public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[2 * radius][2 * radius];
        fillGrids();
    }


    public void fillGrids() {
        this.grids = new char[2 * radius][2 * radius];
        double centerX = radius - 0.5;
        double centerY = radius - 0.5;

        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                double distance = Math.pow(Math.abs(i - centerX)-0.5, 2) + Math.pow(Math.abs(j - centerY)-0.5, 2);
                if (distance < Math.pow(radius, 2)) {
                    this.grids[i][j] = pattern;
                } else {
                    this.grids[i][j] = ' ';
                }
            }
        }
    }


    public void enlarge() {
        this.radius += 1;
        this.grids = new char[2 * radius][2 * radius];
        fillGrids();
    }


    public void shrink() {
        if (this.radius > 1) {
            this.radius -= 1;
            this.grids = new char[2 * radius][2 * radius];
            fillGrids();
        }
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }
}