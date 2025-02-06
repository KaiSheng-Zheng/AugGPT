public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        super.location = location;
        super.pattern = pattern;
        this.radius = radius;

        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (ifInside(j,i)) {
                    grids[i][j] = pattern;
                }
                else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public int area() {
        int tempArea = 0;

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    tempArea++;
                }
            }
        }
        return tempArea;
    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s",location.getX(),location.getY(),area(),pattern);
    }

    private boolean ifInside(int x, int y) {
        int locY = (grids.length+1)/2;
        int locX = (grids[0].length+1)/2;

        return ((locX-x) * (locX-x) + (locY-y) * (locY-y) < radius * radius ||
                (locX-x) * (locX-x) + (locY-y-1) * (locY-y-1) < radius * radius ||
                (locX-x-1) * (locX-x-1) + (locY-y) * (locY-y) < radius * radius ||
                (locX-x-1) * (locX-x-1) + (locY-y-1) * (locY-y-1) < radius * radius);
    }
}
