public class Circle extends Shape {
    private int radius;
    private int areacount;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    public void fillGrids() {
        //clear the counter before counting
        int diameter = radius * 2;
        int mid = diameter-1;
        grids = new char[diameter][diameter];
        int radiusSquared = radius * radius;
        for (int i = 1; i <= diameter; i++) {
            for (int j = 1;j<= diameter;j++) {
                grids[j-1][i-1] = ' ';
            }
        }
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                int dx = i - radius;
                int dy = j - radius;
                int distanceSquared = dx * dx + dy * dy;
                if (distanceSquared < radiusSquared) {
                    grids[i-1][j-1] = pattern;
                    grids[mid-(i-1)][j-1]= pattern;
                    grids[i-1][mid-(j-1)]=pattern;
                    grids[mid-(i-1)][mid-(j-1)]=pattern;
                    areacount+=4;
                }
            }
        }
    }

    public void enlarge() {
        areacount=0;
        radius++;
        fillGrids();
    }

    public void shrink() {
        areacount=0;
        radius--;
        fillGrids();
    }

    public int area() {
        return areacount;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s", super.getLocation().getX(), super.getLocation().getY(), this.area(), super.getPattern());
    }
}
