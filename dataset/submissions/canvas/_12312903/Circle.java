public class Circle extends Shape {

    private int radius;


    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        // should fill the empty slot with ' ', rather than leave it null.
        numberOfFilledGrids = 0;

        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius) {
                    grids[i - 1][j - 1] = pattern;
                    grids[2 * radius - i][j - 1] = pattern;
                    grids[i - 1][2 * radius - j] = pattern;
                    grids[2 * radius - i][2 * radius - j] = pattern;
                    numberOfFilledGrids += 4;
                }
            }
        }
    }


    @Override
    public void enlarge() {
        radius += 1;
        resizeGrid();
        fillGrids();
    }

    private void resizeGrid() {
        int newGridSize = 2 * radius;
        char[][] newGrid = new char[newGridSize][newGridSize];
        for (int i = 0; i < Math.min(newGridSize, grids.length); i++) {
            for (int j = 0; j < Math.min(newGridSize, grids[i].length); j++) {
                newGrid[i][j] = grids[i][j];
            }
        }
        grids = newGrid;
    }

    @Override
    public void shrink() {
        if (radius > 1) {
            radius -= 1;
            resizeGrid();
            fillGrids();
        }

    }

    @Override
    public int area() {
        return numberOfFilledGrids;
    }

    public String toString() {
        return "Circle: " + super.getLocation().toString() + " area=" + area() + " pattern=" + pattern;
    }
}


