
public class Circle extends Shape{

    private int radius;

    
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void fillGrids() {

        grids = new char[radius * 2][radius * 2];

        int[] border = new int[radius];

        for (int i = 0; i < radius; i++) {

            double temp = radius - Math.sqrt(Math.pow(radius, 2) - Math.pow(radius-i-1, 2));
            border[i] = (int) Math.floor(temp);
        }

        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (j >= border[i]) {
                    grids[j][i] = pattern;

                    grids[j][radius * 2 - i - 1] = pattern;
                    grids[radius * 2 - j - 1][i] = pattern;
                    grids[radius * 2 - j - 1][radius * 2 - i - 1] = pattern;
                } else {
                    grids[j][i] = ' ';
                    grids[j][radius * 2 - i - 1] = ' ';
                    grids[radius * 2 - j - 1][i] = ' ';
                    grids[radius * 2 - j - 1][radius * 2 - i - 1] = ' ';
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
        fillGrids();
    }

    @Override
    public int area() {
        int res = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j] == pattern) {
                    res++;
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Circle: " + location.toString() + " area=" + area() + " pattern=" + pattern;
    }

}
