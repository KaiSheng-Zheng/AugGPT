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


        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {

                if (Math.pow(i+1 - radius, 2) + Math.pow(j+1 - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }


        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[i][diameter - j - 1] = grids[i][j];
                grids[diameter - i - 1][j] = grids[i][j];
                grids[diameter - i - 1][diameter - j - 1] = grids[i][j];
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
        if (radius > 0) {
            radius--;
            fillGrids();
        }
    }

    @Override
    public int area() {

        int area = 0;
        for (char[] line : grids) {
            for (char c : line) {
                if (c != ' ') {
                    area++;
                }
            }
        }
        return area;
    }
}