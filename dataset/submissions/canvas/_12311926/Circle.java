public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    public void fillGrids() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = '\u0020';
            }
        }
        for (int i = 0; i < grids.length / 2; i++) {
            for (int j = 0; j < grids[i].length / 2; j++) {
                if (Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
        for (int i = grids.length / 2; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length / 2; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
        for (int i = 0; i < grids.length / 2; i++) {
            for (int j = grids[i].length / 2; j < grids[i].length; j++) {
                if (Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
        for (int i = grids.length / 2; i < grids.length; i++) {
            for (int j = grids[i].length / 2; j < grids[i].length; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    public void enlarge() {
        this.radius++;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    public void shrink() {
        this.radius--;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    public int area() {
        int sum = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public char getPattern() {
        return pattern;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public int getX() {
        return location.getX();
    }

    @Override
    public int getY() {
        return location.getY();
    }

    public String toString() {
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}
