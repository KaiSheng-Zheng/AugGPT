

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

        char a = ' ';
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[i].length; i1++) {
                grids[i][i1] = a;
            }
        }

        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < grids.length - 1; i++) {
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    double x = (double) (width * (i + 1)) / height;
                    if (i1 < x) {
                        grids[i][i1] = pattern;

                    }

                }
            }
            for (int i = 0; i < grids[height - 1].length; i++) {
                grids[height - 1][i] = pattern;
            }

        }
        if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < grids.length - 1; i++) {
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    double x = (double) (width * (i + 1)) / height;
                    if (i1 < x) {
                        grids[i][i1] = pattern;

                    }

                }
            }
            for (int i = 0; i < grids[height - 1].length; i++) {
                grids[height - 1][i] = pattern;
            }

            for (int i = 0; i < grids.length; i++) {
                int start = 0;
                int end = grids[i].length - 1;

                while (start < end) {
                    char temp = grids[i][start];
                    grids[i][start] = grids[i][end];
                    grids[i][end] = temp;
                    start++;
                    end--;
                }
            }
        }
        if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < grids.length - 1; i++) {
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    double x = (double) (width * (i + 1)) / height;
                    if (i1 < x) {
                        grids[i][i1] = pattern;

                    }

                }
            }
            for (int i = 0; i < grids[height - 1].length; i++) {
                grids[height - 1][i] = pattern;
            }
            for (int i = 0; i < height / 2; i++) {
                for (int j = 0; j < width; j++) {
                    char temp = grids[i][j];
                    grids[i][j] = grids[height - 1 - i][j];
                    grids[height - 1 - i][j] = temp;
                }
            }
            for (int i = 0; i < grids.length; i++) {
                int start = 0;
                int end = grids[i].length - 1;

                while (start < end) {
                    char temp = grids[i][start];
                    grids[i][start] = grids[i][end];
                    grids[i][end] = temp;
                    start++;
                    end--;
                }
            }

        }


        if (d == Direction.LEFT_UP) {
            for (int i = 0; i < grids.length - 1; i++) {
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    double x = (double) (width * (i + 1)) / height;
                    if (i1 < x) {
                        grids[i][i1] = pattern;

                    }

                }
            }
            for (int i = 0; i < grids[height - 1].length; i++) {
                grids[height - 1][i] = pattern;
            }

            for (int i = 0; i < height / 2; i++) {
                for (int j = 0; j < width; j++) {
                    char temp = grids[i][j];
                    grids[i][j] = grids[height - 1 - i][j];
                    grids[height - 1 - i][j] = temp;
                }
            }

        }


    }

    @Override
    public void enlarge() {
        width = width + 1;
        height = height + 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        width = width - 1;
        height = height - 1;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[i].length; i1++) {
                if (grids[i][i1] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        String s = "RightTriangle: " + "(" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
        return s;
    }

    ;
}
