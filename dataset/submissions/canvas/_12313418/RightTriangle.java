

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (int a = 0; a < height ; a++) {
            for (int b = 0; b < width; b++) {
                if (grids[a][b] == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public void enlarge() {
        width += 1;
        height += 1;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        width = Math.max(1, width - 1);
        height = Math.max(1, height - 1);
        grids = new char[height][width];
        fillGrids();
    }


    @Override
    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d == Direction.LEFT_DOWN) {
                     if ((width-j)*height>width*(height-i-1)) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }      //the first direction over
                else if (d == Direction.LEFT_UP) {
                     if (width*i<height*(width-j)) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }        //the second direction over
                else if (d == Direction.RIGHT_UP) {
                     if (i*width <height*(j+1)) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }      //the third direction over
                else if (d == Direction.RIGHT_DOWN) {
                    if ((height-i-1)*width<height*(j+1)) {
                        grids[i][j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }    //the last direction over
            }
        }
    }
}



