public class Circle extends Shape {
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    private int radius;

    @Override
    public int area() {
        int area = 0;
        for (int u = 0; u < 2 * radius; u++) {
            for (int v = 0; v < 2 * radius; v++) {
                if (grids[u][v] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public void fillGrids() {
        for (int a = 0; a < 2 * radius; a++) {
            for (int b = 0; b < 2 * radius; b++) {
                grids[a][b] = ' ';
            }
        }
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (((i - radius + 1) * (i - radius + 1) + (j - radius + 1) * (j - radius + 1)) < radius * radius) {
                    grids[i][j] = pattern;
                    grids[2 * radius - 1 - i][2 * radius - 1 - j] = pattern;
                    grids[2 * radius - 1 - i][j] = pattern;
                    grids[i][2 * radius - 1 - j] = pattern;
                }
            }
        }
    }


    @Override
    public void enlarge() {
        radius += 1;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius = Math.max(1, radius - 1);
        grids = new char[2 * radius][2 * radius];
        fillGrids();


    }
}

