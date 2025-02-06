public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[radius*2][radius*2];
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (i+1 <= radius && j+1 <= radius) {
                    if ((i+1-radius)*(i+1-radius) + (j+1-radius)*(j+1-radius) < radius*radius) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (i+1 <= radius && j+1 > radius) {
                    if ((i+1-radius)*(i+1-radius) + (j-radius)*(j-radius) < radius*radius) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (i+1 > radius && j+1 > radius) {
                    if ((i-radius)*(i-radius) + (j-radius)*(j-radius) < radius*radius) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (i+1 > radius && j+1 <= radius) {
                    if ((i-radius)*(i-radius) + (j+1-radius)*(j+1-radius) < radius*radius) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius --;
        fillGrids();
    }

    @Override
    public int area() {
        int t = 0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (grids[i][j] == pattern) {
                    t ++;
                }
            }
        }
        return t;
    }
    public String toString() {
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}