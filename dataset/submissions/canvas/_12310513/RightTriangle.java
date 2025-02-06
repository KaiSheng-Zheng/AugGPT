public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        setWidth(width);
        setHeight(height);
        setD(d);
        fillGrids();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = (width >= 1 && width <= 20) ? width : 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = (height >= 1 && height <= 20) ? height : 0;
    }

    public void setD(Direction d) {
        this.d = d;
    }

    public Direction getD() {
        return d;
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (getD() == Direction.RIGHT_UP) {
                    if (height * (j + 1) > width * i)
                        grids[i][j] = getPattern();
                    else
                        grids[i][j] = ' ';
                } else if (getD() == Direction.LEFT_DOWN) {
                    if (height * j < width * (i + 1)) {
                        grids[i][j] = getPattern();
                    } else
                        grids[i][j] = ' ';
                } else if (getD() == Direction.RIGHT_DOWN) {
                    if (width * (i+1) + height * (j+1) > height * width) {
                        grids[i][j] = getPattern();
                    } else
                        grids[i][j] = ' ';
                } else {
                    if (width * i + height * j < height * width) {
                        grids[i][j] = getPattern();
                    } else
                        grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width += 1;
        height += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        width -= 1;
        height -= 1;
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
        return String.format("RightTriangle: %s area=%d pattern=%c", getLocation(), area(), getPattern());
    }
}
