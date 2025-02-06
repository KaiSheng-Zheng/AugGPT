public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[radius*2][radius*2];
        fillGrids();
    }

    public void fillGrids() {
        for (int i = 0; i <= radius-1; i++) {
            for (int j = 0; j <= radius-1; j++) {
                double distance = Math.sqrt((j+1-radius)*(j+1-radius)+(i+1-radius)*(i+1-radius));
                if (distance <radius) {
                    grids[i][j] = pattern;
                }
                else grids[i][j]=' ';
            }
        }
        for (int i = 0; i <= radius-1; i++) {
            for (int j = radius; j <= 2*radius-1; j++) {
                double distance = Math.sqrt((j-radius)*(j-radius)+(i+1-radius)*(i+1-radius));
                if (distance <radius) {
                    grids[i][j] = pattern;
                }
                else grids[i][j]=' ';
            }
        }
        for (int i = radius; i <= 2*radius-1; i++) {
            for (int j = 0; j <= radius-1; j++) {
                double distance = Math.sqrt((j+1-radius)*(j+1-radius)+(i-radius)*(i-radius));
                if (distance <radius) {
                    grids[i][j] = pattern;
                }
                else grids[i][j]=' ';
            }
        }
        for (int i = radius; i <= 2*radius-1; i++) {
            for (int j = radius; j <= 2*radius-1; j++) {
                double distance = Math.sqrt((j-radius)*(j-radius)+(i-radius)*(i-radius));
                if (distance <radius) {
                    grids[i][j] = pattern;
                }
                else grids[i][j]=' ';
            }
        }

    }

    public void enlarge() {
        radius++;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }

    public void shrink() {
        if (radius > 1) {
            radius--;
            grids = new char[radius*2][radius*2];
            fillGrids();
        }
    }

    public int area() {
        int count = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == pattern) count++;
            }
        }
        return count;
    }
}
