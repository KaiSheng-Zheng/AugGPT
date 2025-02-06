public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        calDistances();
        fillGrids();
    }


    public void calDistances() {
        grids = new char[radius * 2][radius * 2];
        gridsDistance = new double[radius * 2 + 1][radius * 2 + 1];
        for (int i = 0; i < radius * 2 + 1; i++) {
            for (int j = 0; j < radius * 2 + 1; j++) {
                gridsDistance[i][j] = Math.sqrt((radius - i) * (radius - i) + (radius - j) * (radius - j));

            }

        }
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (gridsDistance[i][j] < radius || gridsDistance[i + 1][j] < radius || gridsDistance[i][j + 1] < radius || gridsDistance[i + 1][j + 1] < radius) {
                    counter++;
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public char[][] getGrids() {
        return super.getGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                System.out.print(grids[i][j]);
            }
            System.out.printf("/n");
        }
    }

    @Override
    public void enlarge() {
        counter = 0;
        radius++;
        calDistances();
    }

    @Override
    public void shrink() {
        counter = 0;
        radius--;
        calDistances();
    }

    @Override
    public int area() {
        return counter;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), counter, pattern);
    }
}
