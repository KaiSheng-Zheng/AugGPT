import java.util.Arrays;

public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    @Override
    public char[][] fillGrids() {
        super.grids = new char[radius * 2][radius * 2];
        for (char[] grid : grids) {
            Arrays.fill(grid, this.pattern);
        }
        area = (int) Math.pow(radius * 2, 2);
        for (int i = 1; i < radius; i++) {
            for (int j = 1; j < radius; j++) {
                double length = Math.pow(radius - i, 2) + Math.pow(radius - j, 2);
                int row = i - 1;
                int col = j - 1;
                if (length >= radius * radius) {
                    grids[row][col] = ' ';
                    grids[grids.length - row - 1][col] = ' ';
                    grids[row][grids.length - col - 1] = ' ';
                    grids[grids.length - row - 1][grids.length - col - 1] = ' ';
                    area -= 4;
                } else {
                    break;
                }
            }
        }
        return grids;
    }

    @Override
    public int area() {
        return super.area;
    }



    @Override
    public void enlarge() {
        radius++;
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius = Math.max(radius - 1, 0);
        grids = new char[2 * radius][2 * radius];
        fillGrids();
    }


    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(),
                area(), pattern);
    }

}
