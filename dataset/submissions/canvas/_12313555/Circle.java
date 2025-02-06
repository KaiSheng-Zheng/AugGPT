public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < grids.length ; i++) {
            for (int j = 0 ; j < radius * 2 ; j++) {
                if (( radius - i) * ( radius - i) + ( radius - j) *  (radius - j) < radius * radius || ( radius - i - 1) * ( radius - i - 1) + ( radius - j) * ( radius - j) < radius * radius || (  radius - i) * (+ radius - i) + (+ radius - j - 1) * (+ radius - j - 1) < radius * radius || (+ radius - i - 1) * ( + radius - i - 1) + ( + radius - j - 1) * ( + radius - j - 1) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    public void enlarge() {
        radius++;
        fillGrids();
    }

    public void shrink() {
        radius--;
        fillGrids();
    }

    public int area() {
        int area = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius || (radius - i - 1) * (radius - i - 1) + (radius - j) * (radius - j) < radius * radius || (radius - i) * (radius - i) + (radius - j - 1) * (radius - j - 1) < radius * radius || (radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius * radius) {
                    area++;
                }
            }
        }
        return area;
    }

    public String toString() {
        return (String.format("Circle: (%s,%s) area=%s pattern=%s", location.getX(), location.getY(), area(), pattern));
    }

    public boolean fillGrids2() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0 ; i < grids.length; i++) {
            for (int j = 0 ; j < radius * 2; j++) {
                if (( radius - i) * ( + radius - i) + ( + radius - j) * ( + radius - j) < radius * radius || (+ radius - i - 1) * (+ radius - i - 1) + ( + radius - j) * (+ radius - j) < radius * radius || ( + radius - i) * (+ radius - i) + (+ radius - j - 1) * ( + radius - j - 1) < radius * radius || ( + radius - i - 1) * ( + radius - i - 1) + ( + radius - j - 1) * (+ radius - j - 1) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        return false;
    }
}
