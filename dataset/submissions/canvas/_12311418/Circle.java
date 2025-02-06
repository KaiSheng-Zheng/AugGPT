public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        String name = "Circle";
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                double distance;
                if (i < radius && j < radius) {
                    distance = Math.sqrt(Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2));
                    if (distance < radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                } else if (i >= radius && j < radius) {
                    distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j + 1 - radius, 2));
                    if (distance < radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                } else if (i < radius) {
                    distance = Math.sqrt(Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2));
                    if (distance < radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                } else {
                    distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));
                    if (distance < radius) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public char[][] getGrids() {
        return super.getGrids();
    }

    @Override
    public void enlarge() {
        radius += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -= 1;
        fillGrids();
    }

    public int area() {
        int count = 0;
        if (grids.length > 0) {
            for (int i = 0; i < getGrids().length; i++) {
                for (int j = 0; j < getGrids()[i].length; j++) {
                    if (grids[i][j] == pattern) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }

    public static void main(String[] args) {
        Location p1 = new Location(1, 0);
        Shape s1 = new Circle(p1, '*', 5);
        char[][] grids = s1.getGrids();
        for (char[] grid : grids) {
            System.out.println(grid);
        }
        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
        s1.shrink();
        grids = s1.getGrids();
        for (char[] grid : grids) {
            System.out.println(grid);
        }
        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
    }
}