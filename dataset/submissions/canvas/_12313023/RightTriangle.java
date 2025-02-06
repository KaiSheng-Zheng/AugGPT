public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(pattern, location);
        this.width = width;
        this.height = height;
        this.d = d;
        name = "RightTriangle";
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        switch (d) {
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (j < Math.ceil(1.0 * (i + 1) * width / height)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                for (int i = height - 1; i >= 0; i--) {
                    for (int j = 0; j < width; j++) {
                        if (j < Math.ceil(1.0 * (height - i) * width / height)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = height - 1; i >= 0; i--) {
                    for (int j = width - 1; j >= 0; j--) {
                        if (width - 1 - j < Math.ceil(1.0 * (height - i) * width / height)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= 0; j--) {
                        if (width - 1 - j < Math.ceil(1.0 * (i + 1) * width / height)) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void enlarge() {
        height += 1;
        width += 1;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        if (height != 0) {
            height -= 1;
        }
        if (width != 0) {
            width -= 1;
        }
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return name + ": "+ location.toString() +" area=" + area() + " pattern=" + pattern;
    }
}
