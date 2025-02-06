public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        int diameter = radius * 2;
        grids = new char[diameter][diameter];
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                if (radius == 1) {
                    grids[i][j] = pattern;
                } else {
                    if (i <= radius - 1 && j <= radius - 1) {
                        int x = radius - 1;
                        int y = radius - 1;
                        if ((i - x) * (i - x) + (j - y) * (j - y) < radius * radius) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                    if (i <= radius - 1 && j >= radius) {
                        int x = radius - 1;
                        int y = radius;
                        if ((i - x) * (i - x) + (j - y) * (j - y) < radius * radius) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                    if (i >= radius && j <= radius - 1) {
                        int x = radius;
                        int y = radius - 1;
                        if ((i - x) * (i - x) + (j - y) * (j - y) < radius * radius) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                    if (i >= radius && j >= radius) {
                        int x = radius;
                        int y = radius;
                        if ((i - x) * (i - x) + (j - y) * (j - y) < radius * radius) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
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
        radius--;
        if (radius >= 1) {
            fillGrids();
        } else {
            radius = 1;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public char getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", location.toString(), area(), pattern);
    }
}
