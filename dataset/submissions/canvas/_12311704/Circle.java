public class Circle extends Shape {
    private int radius;
    private char[][] grids;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    public void fillGrids() {
        int diameter = 2 * radius;
        grids = new char[diameter][diameter];

        // Initialize the grid with spaces
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                grids[i][j] = ' ';
            }
        }

        // Fill the circle
        for (int y = 0; y < radius; y++) {
            for (int x = 0; x < radius; x++) {
                // Adjust the condition to accurately represent a filled circle
                if (Math.pow(radius - y - 1, 2) + Math.pow(radius - x - 1, 2) < Math.pow(radius, 2)) {
                    grids[y][x] = pattern;
                    grids[y][2 * radius - 1 - x] = pattern;
                    grids[2 * radius - 1 - y][x] = pattern;
                    grids[2 * radius - 1 - y][2 * radius - 1 - x] = pattern;
                }
            }
        }
    }

    @Override
    public char[][] getGrids() {
        return grids;
    }

    @Override
    public void enlarge() {
        radius += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        if (radius > 1) {
            radius -= 1;
            fillGrids();
        }
    }

    @Override
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", location.toString(), area(), pattern);
    }
}