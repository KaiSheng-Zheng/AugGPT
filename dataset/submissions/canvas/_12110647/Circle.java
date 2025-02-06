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
                int lux = j;
                int luy = i;
                double lud = Math.pow(lux - radius, 2) + Math.pow(luy - radius, 2);
                int ldx = j;
                int ldy = i+1;
                double ldd = Math.pow(ldx - radius, 2) + Math.pow(ldy - radius, 2);
                int rux = j+1;
                int ruy = i;
                double rud = Math.pow(rux - radius, 2) + Math.pow(ruy - radius, 2);
                int rdx = j+1;
                int rdy = i+1;
                double rdd = Math.pow(rdx - radius, 2) + Math.pow(rdy - radius, 2);

                double ld = Math.min(lud,ldd);
                double rd = Math.min(rud,rdd);

                double distance = Math.min(ld,rd);

                if (distance < radius*radius) {
                    grids[i][j] = pattern;
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
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int count = 0;
        for (char[] row : grids) {
            for (char cell : row) {
                if (cell == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%s", location, area(), pattern);
    }
}
