
public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();
}

class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
    }

    int count = 0;
    int n = 0;

    @Override
    public char[][] getGrids() {
        if (n == 0) {
            grids = new char[radius * 2][radius * 2];
            return grids;
        } else {
            return grids;
        }
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < getGrids().length; i++) {
            for (int j = 0; j < getGrids()[0].length; j++) {
                int row = getGrids().length;
                int col = getGrids()[0].length;
                int x = 0;
                int y = 0;
                if (i < row / 2 && j < col / 2) {
                    x = location.getX() - radius + 1 + j;
                    y = location.getY() + radius - 1 - i;
                } else if (i >= row / 2 && j < col / 2) {
                    x = location.getX() - radius + 1 + j;
                    y = location.getY() + radius - i;
                } else if (i < row / 2 && j >= col / 2) {
                    x = location.getX() - radius + j;
                    y = location.getY() + radius - 1 - i;
                } else if (i >= row / 2 && j >= col / 2) {
                    x = location.getX() - radius + j;
                    y = location.getY() + radius - i;
                }
                if (Math.pow(x - location.getX(), 2) + Math.pow(y - location.getY(), 2) < radius * radius) {
                    n++;
                    count++;
                    grids[i][j] = pattern;
                } else {
                    n++;
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        count = 0;
        n = 0;
        radius = radius + 1;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void shrink() {
        count = 0;
        n = 0;
        radius = radius - 1;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public int area() {
        count = 0;
        n = 0;
        fillGrids();
        return count;
    }

    public String toString() {
        String s = "Circle: " + location + " area=" + count + " pattern=" + pattern;
        return s;
    }
}

class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.height = height;
        this.width = width;
        this.d = d;
    }

    int count = 0;
    int n = 0;

    @Override
    public char[][] getGrids() {
        if (n == 0) {
            grids = new char[height][width];
            return grids;
        } else {
            return grids;
        }
    }

    @Override
    public void fillGrids() {
        double k = (double) height / width;
        getGrids();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (
                        (d.equals(Direction.LEFT_UP) && i + k * j < height)
                                || (d.equals(Direction.LEFT_DOWN) && i + 1 > k * j)
                                || (d.equals(Direction.RIGHT_UP) && i < k * (j + 1))
                                || (d.equals(Direction.RIGHT_DOWN) && (i+1) + k * (j+1) > height)
                ) {
                    n++;
                    count++;
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        count = 0;
        n = 0;
        height = height + 1;
        width = width + 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        count = 0;
        n = 0;
        height = height - 1;
        width = width - 1;
        fillGrids();
    }

    @Override
    public int area() {
        count = 0;
        n = 0;
        fillGrids();
        return count;
    }

    public String toString() {
        String s = "RightTriangle: " + location + " area=" + count + " pattern=" + pattern;
        return s;
    }
}

