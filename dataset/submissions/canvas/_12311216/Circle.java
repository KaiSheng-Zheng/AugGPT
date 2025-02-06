public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                double[] distances;
                distances = new double[]{
                        Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2)),
                        Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j + 1 - radius, 2)),
                        Math.sqrt(Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2)),
                        Math.sqrt(Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2))
                };

                boolean insideCircle = false;
                for (double distance : distances) {
                    if (distance < radius) {
                        insideCircle = true;
                        break;
                    }
                }

                if (insideCircle) {
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
        int area = 0;
        for (char[] row : grids) {
            for (char c : row) {
                if (c == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", location, area(), pattern);
    }
}