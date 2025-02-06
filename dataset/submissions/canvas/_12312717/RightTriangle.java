public class RightTriangle extends Shape {
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    public boolean JudgeTriangle(int x1, int y1, Direction d) {
        double k = (double) height / (double) width;
        double x = (double) x1;
        double y = (double) y1;
        if (d.equals(Direction.LEFT_DOWN)) {
            if (y == location.getY() && location.getX() <= x && x < location.getX() + height)
                return true;
            else if ((x + 1 - location.getX()) / (y - location.getY()) > k)
                return true;
        }
        if (d.equals(Direction.LEFT_UP)) {
            if (y == location.getY() && location.getX() <= x && x < location.getX() + height)
                return true;
            else if ((height + location.getX() - x) / (y - location.getY()) > k)
                return true;
        }
        if (d.equals(Direction.RIGHT_UP)) {
            if (y == location.getY() + width - 1 && location.getX() <= x && x < location.getX() + height)
                return true;
            else if ((location.getX() + height - x) / (location.getY() + width - y - 1) > k)
                return true;
        }
        if (d.equals(Direction.RIGHT_DOWN)) {
            if (y == location.getY() + width - 1 && location.getX() <= x && x < location.getX() + height)
                return true;
            else if ((x + 1 - location.getX()) / (location.getY() + width - y - 1) > k)
                return true;
        }
        return false;
    }

    public boolean JudgeTriangle1(int x1, int y1, Direction d) {
        double k = (double) height / (double) width;
        double x = (double) x1;
        double y = (double) y1;
        if (d.equals(Direction.LEFT_DOWN)) {
            if (x == 0)
                return true;
            else if ((y + 1) / x > k)
                return true;
        }
        if (d.equals(Direction.LEFT_UP)) {
            if (x == 0)
                return true;
            else if ((height - y) / (x) > k)
                return true;
        }
        if (d.equals(Direction.RIGHT_UP)) {
            if (y == 0)
                return true;
            double k1 = y / (x + 1);
            if (y != 0 && k1 < k)
                return true;
        }
        if (d.equals(Direction.RIGHT_DOWN)) {
            if (x == width - 1)
                return true;
            else if ((y + 1) / (width - (x + 1)) > k)
                return true;
        }
        return false;
    }

    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                if (JudgeTriangle1(j, i, this.d))
                    grids[i][j] = pattern;
                else grids[i][j] = ' ';
            }
        }
    }

    @Override
    public void enlarge() {
        this.width++;
        this.height++;
        this.grids = new char[height][width];
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                if (JudgeTriangle1(j, i, this.d))
                    grids[i][j] = pattern;
                else grids[i][j] = ' ';
            }
        }
    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
        this.grids = new char[height][width];
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                if (JudgeTriangle1(j, i, this.d))
                    grids[i][j] = pattern;
                else grids[i][j] = ' ';
            }
        }
    }

    @Override
    public int area() {
        int num = 0;
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                if (grids[i][j] == pattern)
                    num++;
            }
        }
        return num;
    }

    public String toString() {
        String a = "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + this.pattern;
        return a;
    }
}
