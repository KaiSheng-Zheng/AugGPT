public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double slope =(double)width/height;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {

                switch (d) {
                    case LEFT_UP:
                        double slopeforpoint1=(double) (j-width)/i;
                        if (slopeforpoint1<-slope||i==0) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                        break;
                    case LEFT_DOWN:
                        double slopeforpoint2=(double)(j)/(i+1);
                        if (j==0||slopeforpoint2<slope) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                        break;
                    case RIGHT_UP:
                        double slopeforpoint3=(double)(j+1)/i;
                      if (i==0||slopeforpoint3>slope) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                        break;
                    case RIGHT_DOWN:
                        double slopeforpoint4=(double)(j+1-width)/(i+1);
                        if (slopeforpoint4>-slope) {
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                        break;
                    default:
                        grids[i][j] = ' ';
                }
            }
        }
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

    @Override
    public int area() {
        int area = 0;
        for (char[] row : grids) {
            for (char c : row) {
                if (c == pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%c", location, area(), pattern);
    }
}