public class Circle extends Shape {
    private int radius;  // value of radius is within 1-15

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids(); // u should consider what if there is no pattern in initial step
    }

    public  void fillGrids() {
        int height = radius * 2;
        int width = radius * 2;
        grids = new char[height][width];
            for (int i = 0; i < radius; i++) {
                for (int j = 0; j < radius; j++) {
                    //might have errors (may need to check conditions for array bounds)

                    int pathX = radius - (i + 1);
                    int pathY = radius - (j + 1);
                    double distance = Math.sqrt((pathX) * (pathX) + (pathY) * (pathY));
                    if (distance < radius) {
                        grids[i][j] = pattern;
                        grids[i][(2*radius-1)-j] = pattern;
                        grids[(2*radius-1)-i][j] = pattern;
                        grids[(2*radius-1)-i][(2*radius-1)-j] = pattern;
                    }
                    else{
                        grids[i][j] = ' ';
                        grids[i][(2*radius-1)-j] = ' ';
                        grids[(2*radius-1)-i][j] = ' ';
                        grids[(2*radius-1)-i][(2*radius-1)-j] = ' ';

                    }

                }
            }
    }

    public  void enlarge() {
        this.radius++;
        fillGrids();
    }

    public  void shrink() {
        this.radius--;
        fillGrids();
    }

    public  int area() {
        int count = 0;
        for(int i=0; i< 2*radius; i++) {
            for(int j=0; j< 2*radius; j++) {
                if(grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;

    }

@Override
    public String toString() {
        String className = "Circle";
        String output = className + ": " + "("+ location.getX() + "," + location.getY() + ") area="+ area() + " pattern=" + pattern;

        return output;
    }
}
