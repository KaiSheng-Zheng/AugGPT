import java.util.Comparator;

public class Circle extends Shape implements Comparator<Circle> {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        clear();
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (shouldFill(i, j)) {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    private void clear() {
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                grids[i][j] = ' ';
            }
        }
    }

    private boolean shouldFill(int i, int j) {
        boolean p, q, r, s;
        int x, y;
        x = j + 1;
        y = i + 1;
        p = x * x + y * y - 2 * radius * (x + y) + radius * radius < 0;
        x = j;
        y = i;
        q = x * x + y * y - 2 * radius * (x + y) + radius * radius < 0;
        x = j;
        y = i + 1;
        r = x * x + y * y - 2 * radius * (x + y) + radius * radius < 0;
        x = j + 1;
        y = i;
        s = x * x + y * y - 2 * radius * (x + y) + radius * radius < 0;
        return p || q || r || s;
    }

    @Override
    public void enlarge() {
        radius++;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (char[] grid : grids) {
            for (int j = 0; j < grids.length; j++) {
                if (grid[j] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    public String toString() {
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }

    public void display() {
        for (char[] grid : grids) {
            for (int j = 0; j < grids.length; j++) {
                System.out.print(grid[j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========================");
    }




    @Override
    public int compare(Circle o1, Circle o2) {
        if(o1.location.getX()>o2.location.getX()){
            return 1;
        } else if (o1.location.getX()<o2.location.getX()) {
            return -1;
        }else{
            if(o1.location.getY()>o2.location.getY()){
                return 1;
            } else if (o1.location.getY()<o2.location.getY()) {
                return -1;
            }else{
                return o1.pattern-o2.pattern;
            }
        }
    }
}
