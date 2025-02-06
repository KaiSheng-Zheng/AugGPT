public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
    }
    public void fillGrids() {
        char[][] grid = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (radius * radius > (radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1)) {
                    grid[i][j] = pattern;
                } else {
                    grid[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][radius * 2 - j - 1] = ' ';
                }else {
                    grid[i][radius * 2 - j - 1] = pattern;
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (grid[i][j] == ' ') {
                    grid[radius * 2 - i - 1][j] = ' ';
                }else {
                    grid[radius * 2 - i - 1][j] = pattern;
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (grid[i][j] == ' ') {
                    grid[radius * 2 - i - 1][radius * 2 - j - 1] = ' ';
                }else {
                    grid[radius * 2 - i - 1][radius * 2 - j - 1] = pattern;
                }
            }
        }
        grids = grid;
    }
    public void enlarge() {
        this.radius = this.radius + 1;
    }

    public void shrink() {
        this.radius = this.radius - 1;
    }

    public int area() {
        int area;
        int sum = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (getGrids()[i][j] == ' ') {
                    sum = sum + 1;
                }
            }
        }
        area = radius * radius * 4 - sum;
        return area;
    }
    public void setRadius(int r) {
        this.radius = r;
    }
}
