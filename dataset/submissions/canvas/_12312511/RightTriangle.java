public class RightTriangle extends Shape implements Comparable<RightTriangle> {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    public String toString() {
        return "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }

    @Override
    public void fillGrids() {
        clear();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (shouldFill(i, j)) {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    private void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
    }

    private boolean shouldFill(int i, int j) {
        double x, y;
        switch (d) {
            case LEFT_UP -> {
                x = j;
                y = i;
                return y / height + x / width < 1;
            }
            case LEFT_DOWN -> {
                x = j;
                y = i + 1;
                return width * y > height * x;
            }
            case RIGHT_UP -> {
                x = j + 1;
                y = i;
                return width * y < height * x;
            }
            case RIGHT_DOWN -> {
                x = j + 1;
                y = i + 1;
                return x / width + y / height > 1;
            }
        }
        return false;
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    public void display() {
        for (char[] grid : grids) {
            for (char c : grid) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("==========================");
    }

    @Override
    public int compareTo(RightTriangle o) {
        if(super.location.getX()>o.location.getX()){
            return 1;
        } else if (super.location.getX()<o.location.getX()) {
            return -1;
        }else{
            if(super.location.getY()>o.location.getY()){
                return 1;
            } else if (super.location.getY()<o.location.getY()) {
                return -1;
            }else{
                return this.pattern-o.pattern;
            }
        }
    }
}
