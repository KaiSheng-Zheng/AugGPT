import java.util.Comparator;

public class Circle extends Shape{
    protected int radius;

    protected int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = (radius >= 1 && radius <= 15) ? radius : 0;
    }


    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        setRadius(radius);
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[radius*2][radius*2];
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if ((radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius * radius) {
                    grids[i][j] = getPattern();
                    grids[2 * radius - 1 - i][2 * radius - 1 - j] = getPattern();
                    grids[i][2 * radius - 1 - j] = getPattern();
                    grids[2 * radius - 1 - i][j] = getPattern();
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius+=1;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius-=1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == getPattern()) {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", getLocation(), area(), getPattern());
    }
}
