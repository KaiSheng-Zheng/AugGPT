import java.awt.*;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width; // Ensure the width is within [1-20]
        this.height = height; // Ensure the height is within [1-20]
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' '; // Initialize with space
            }
        }
        switch (d) {
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (!(width*i >= width*height-height * j
                                && width*(i+1) >= width*height-height * j
                                &&width*i >= width*height-height * (j+1)
                                &&width*(i+1) >= width*height-height * (j+1)

                        )) {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;

            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (!(
                                width*i <= height * j&&
                                        width*(i+1) <= height * j&&
                                        width*i <= height * (j+1)&&
                                        width*(i+1) <= height * (j+1)
                        )) {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;

            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (!(
                                width*i >= height * j&&
                                        width*(i+1) >= height * j&&
                                        width*i >= height * (j+1)&&
                                        width*(i+1) >= height * (j+1)
                        )) {
                            grids[i][j] = pattern;
                        }
                    }
                }
                break;

            default:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (!(width*i <= width*height-height * j
                                && width*(i+1) <= width*height-height * j
                                &&width*i <= width*height-height * (j+1)
                                &&width*(i+1) <= width*height-height * (j+1)

                        )) {
                            grids[i][j] = pattern;
                        }
                    }
                }
        }
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

    @Override
    public void enlarge() {
        if (width < 20 && height < 20) {
            width++;
            height++;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if (width > 1 && height > 1) {
            width--;
            height--;
            fillGrids();
        }
    }
}

