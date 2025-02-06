public class Circle extends Shape {

    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }


    @Override
    public int area() {
        var tmp = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                tmp += grids[i][j] == pattern ? 1 : 0;
            }
        }
        return tmp;
    }

    private boolean isInside(int x, int y) {
        var cx = (double) radius;
        var cy = (double) radius;
        var dirs = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (var dir : dirs) {
            var dx = x + dir[0];
            var dy = y + dir[1];
            var diff = (dx - cx) * (dx - cx) + (dy - cy) * (dy - cy) - radius * radius;
            if (diff < -1e-7) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void fillGrids() {
        grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = isInside(i, j) ? pattern : ' ';
            }
        }
    }

    @Override
    public void enlarge() {
        radius += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -= 1;
        fillGrids();
    }


}