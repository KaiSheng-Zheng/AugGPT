public class Circle extends Shape {
    private int radius;
    private int area;
    public Circle(Location location, char pattern, int radius) {
        super (location, pattern);
        this.pattern = pattern;
        this.radius = radius;
        this.grids = new char[2*radius][2*radius];
        fillGrids();
    }
    public int getRadius() {
        return radius;
    }
    public void fillGrids() {
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (((radius-j)*(radius-j) + (radius-i)*(radius-i)) < (radius*radius)) {
                    grids[i][j] = pattern;
                } else if (((radius-j)*(radius-j) + (radius-(i+1))*(radius-(i+1))) < (radius*radius)) {
                    grids[i][j] = pattern;
                } else if (((radius-(j+1))*(radius-(j+1)) + (radius-i)*(radius-i)) < (radius*radius)) {
                    grids[i][j] = pattern;
                } else if (((radius-(j+1))*(radius-(j+1)) + (radius-(i+1))*(radius-(i+1))) < (radius*radius)) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public void enlarge() {
        radius += 1;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }
    public void shrink() {
        radius -= 1;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }
    public int area() {
        this.area = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (Character.valueOf(grids[i][j]) == Character.valueOf(pattern)) {
                    this.area += 1;
                }
            }
        }
        return this.area;
    }
    @Override
    public String toString() {
        area();
        return "Circle: " + "(" + location.getX() + "," + location.getY() + ") area=" + area + " pattern=" + pattern;
    }
}