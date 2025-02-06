public class RightTriangle extends Shape {
    public Direction getD() {
        return d;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private final Direction d;
    private int width;
    private int height;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }


    @Override
    public void fillGrids() {
        numberOfFilledGrids = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (d) {
                    case LEFT_UP, LEFT_DOWN:
                        if (j == 0) {
                            grids[i][0] = pattern;
                            numberOfFilledGrids += 1;
                        } else {
                            grids[i][j] = ' ';
                        }
                        break;
                    case RIGHT_UP, RIGHT_DOWN:
                        if (j == width - 1) {
                            grids[i][width-1] = pattern;
                            numberOfFilledGrids += 1;
                        } else {
                            grids[i][j] = ' ';
                        }
                        break;
                }
            }

        }
        for (int i = 1; i <=height; i++) {
            for (int j = 1; j < width; j++) {
                if ((double) i / j > (double) height / width) {
                    switch (d) {
                        case LEFT_DOWN:
                            grids[i - 1][j] = pattern;
                            numberOfFilledGrids += 1;
                            break;
                        case LEFT_UP:
                            grids[height-i][j] = pattern;
                            numberOfFilledGrids += 1;
                            break;
                        case RIGHT_UP:
                            grids[height-i][width-j -1] = pattern;
                            numberOfFilledGrids += 1;
                            break;
                        case RIGHT_DOWN:
                            grids[i - 1][width-j-1] = pattern;
                            numberOfFilledGrids += 1;
                            break;

                    }
                }
            }

        }
    }


    public void enlarge() {
        height += 1;
        width += 1;
        resizeGrid();
        fillGrids();
    }

    private void resizeGrid() {
        char[][] newGrid = new char[height][width];

        grids = newGrid;
    }


    @Override
    public void shrink() {
        height -= 1;
        width -= 1;
        resizeGrid();
        fillGrids();

    }

    @Override
    public int area() {
        return numberOfFilledGrids;
    }
    public String toString() {
        return "RightTriangle: " + super.getLocation().toString() + " area=" + area() + " pattern=" + pattern;
    }
}
