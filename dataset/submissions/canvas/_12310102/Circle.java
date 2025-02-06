public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillCircleGrids(pattern, radius);
    }

    public void fillCircleGrids(char pattern, int radius) {
        double distance;
        grids = new char[2 * radius][2 * radius];
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));
                if (distance < radius) {
                    grids[i - 1][j - 1] = pattern;
                } else {
                    grids[i - 1][j - 1] = ' ';
                }
            }
        }
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                grids[i - 1][2 * radius - j] = grids[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                grids[2 * radius - i][j - 1] = grids[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                grids[2 * radius - i][2 * radius - j] = grids[i - 1][j - 1];
            }
        }
    }

    @Override
    public void fillGrids() {
        fillCircleGrids(pattern, radius);
    }

    @Override
    public void enlarge() {
        radius++;
        fillCircleGrids(pattern, radius);
    }

    @Override
    public void shrink() {
        radius--;
        fillCircleGrids(pattern, radius);
    }

    @Override
    public int area() {
        int area = 0;
        for(int i=0; i<grids.length; i++) {
            for(int j=0; j<grids[0].length; j++) {
                if(grids[i][j] == pattern) {
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
