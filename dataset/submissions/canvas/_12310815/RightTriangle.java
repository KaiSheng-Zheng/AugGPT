

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    int area;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super();
        super.location = location;
        super.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        area = 0;
        super.grids = new char[height][width];
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < grids.length + 1; i++) {
                double slope = (double) width / height;
                area += (int) Math.ceil(i * slope);
                if (i != grids.length) {
                    for (int j = 0; j < Math.min((int) Math.abs(Math.ceil((i + 1) * slope)), width); j++) {
                        grids[i][j] = pattern;
                    }
                }
            }
            for (int k = 0; k < grids.length; k++) {
                for (int l = 0; l < grids[0].length; l++) {
                    if (grids[k][l] != pattern) {
                        grids[k][l] = ' ';
                    }
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            for (int i = 1; i < grids.length + 1; i++) {
                double slope = (double) width / height;
                area += (int) Math.ceil(i * slope);
                for (int j = width - 1; j >= Math.max(width - (int) Math.ceil(slope * i), 0); j--) {
                    grids[i - 1][j] = pattern;
                }
            }
            for (int k = 0; k < grids.length; k++) {
                for (int l = 0; l < grids[0].length; l++) {
                    if (grids[k][l] != pattern) {
                        grids[k][l] = ' ';
                    }
                }
            }
            char[][] reversedArray = new char[grids.length][grids[0].length];
            for (int i = 0; i < grids.length; i++) {
                reversedArray[i] = grids[grids.length - 1 - i].clone();
            }
            grids = reversedArray;
        } else if (d == Direction.LEFT_UP) {
            for (int i = 0; i < grids.length + 1; i++) {
                double slope = -(double) width / height;
                double intercept = width;
                area += (int) Math.ceil(slope * i + intercept);
                if (i != grids.length) {
                    for (int j = 0; j < Math.min((int) Math.abs(Math.ceil(i * slope + intercept)), width); j++) {
                        grids[i][j] = pattern;
                    }
                }
            }
            for (int k = 0; k < grids.length; k++) {
                for (int l = 0; l < grids[0].length; l++) {
                    if (grids[k][l] != pattern) {
                        grids[k][l] = ' ';
                    }
                }
            }
        } else if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < grids.length + 1; i++) {
                double slope = -(double) width / height;
                double intercept = width;
                area += (int) Math.ceil(slope * i + intercept);
                if (i != grids.length) {
                    for (int j = width - 1; j > width - 1 - (int) Math.ceil(slope * i + intercept); j--) {
                        grids[i][j] = pattern;
                    }
                }
            }
            //Math.min((int) Math.abs(Math.ceil(i * slope+intercept)), width - 1)
            for (int k = 0; k < grids.length; k++) {
                for (int l = 0; l < grids[0].length; l++) {
                    if (grids[k][l] != pattern) {
                        grids[k][l] = ' ';
                    }
                }
            }
            char[][] reversedArray = new char[grids.length][grids[0].length];
            for (int i = 0; i < grids.length; i++) {
                reversedArray[i] = grids[grids.length - 1 - i].clone();
            }
            grids = reversedArray;
        }
    }


    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        return area;
    }

    @Override
    public String toString() {
        return "RightTriangle: (" + this.location.getX() + "," + this.location.getY() + ") area=" + area + " pattern=" + pattern;
    }
}




