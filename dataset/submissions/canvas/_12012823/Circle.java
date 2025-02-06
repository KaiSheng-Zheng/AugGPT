public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char[][] res = new char[radius * 2][radius * 2];
        for(int i = 1;i <= radius;i++) {
            for(int j = 1;j <= radius;j++) {
                int length = (i - radius) * (i - radius) + (j - radius) * (j - radius);
                if(length < radius * radius) {
                    res[i-1][j-1] = pattern;
                    res[i-1][2 * radius - j] = pattern;
                    res[2 * radius - i][j-1] = pattern;
                    res[2 * radius - i][2 * radius - j] = pattern;

                } else {
                    res[i-1][j-1] = ' ';
                    res[i-1][2 * radius - j] = ' ';
                    res[2 * radius - i][j-1] = ' ';
                    res[2 * radius - i][2 * radius - j] = ' ';
                }
            }
        }
        grids = res;

    }

    @Override
    public void enlarge() {
        this.radius = this.radius + 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius = this.radius - 1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for(int i = 0;i < radius * 2;i++) {
            for(int j = 0;j < radius * 2;j++) {
                if(grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%s", getClass().getName(), this.location.getX(), this.location.getY(), area(), pattern);
    }
}
