public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        initiate();


        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {


                int x = i + 1;
                int y = j + 1;
                int center_x = radius;
                int center_y = radius;
                double distance = Math.pow(x - center_x, 2) + Math.pow(y - center_y, 2);
                if (distance < radius * radius) {
                    grids[i][j] = pattern;
                    grids[i][2*radius -1-j] = pattern;
                    grids[2*radius -1-i][j] = pattern;
                    grids[2*radius -1-i][2*radius -1-j] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return "Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }

    public void print() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                System.out.print(grids[i][j]);
            }
            System.out.println();
        }
    }
}
