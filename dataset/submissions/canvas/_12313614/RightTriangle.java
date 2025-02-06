

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
        char[][] grids2 = new char[height][width];

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = ' ';
                grids2[i][j] = ' ';
            }
        }

        double slope = (double) height / width;
        double currentSlope;
        for (int i = 1; i <grids2.length; i++) {
            for (int j = 0; j < grids2[i].length; j++) {
                if (j == 0) {
                    grids2[i-1][j] = pattern;
                } else {
                    currentSlope = (double) i / j;
                    if (currentSlope > slope) {
                        grids2[i - 1][j] = pattern;
                    }
                }
            }
        }
        for (int i = 0; i < width; i++) {
            grids2[height-1][i]=pattern;

        }

        switch (d) {
            case LEFT_UP:
                for (int i = 0; i < grids2.length; i++) {
                    for (int j = 0; j < grids2[i].length; j++) {

                        grids[i][j]=grids2[this.height-i-1][j];

                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < grids2.length; i++) {
                    for (int j = 0; j < grids2[i].length; j++) {
                        if (grids2[i][j] == pattern) {
                            if (j >= 0 && j < grids[i].length) {
                                grids[i][j] = pattern;
                            }
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < grids2.length; i++) {
                    for (int j = 0; j < grids2[i].length; j++) {
                        grids[i][j]=grids2[this.height-i-1][j];

                    }
                }
                for (int i = 0; i < grids2.length; i++) {
                    for (int j = 0; j < grids2[i].length; j++) {

                        grids2[i][j] = grids[i][j];


                    }
                }
                for (int i = 0; i < grids2.length; i++) {
                    for (int j = 0; j < grids2[i].length; j++) {


                        grids[i][j]=grids2[i][width-j-1];

                    }
                }

                break;
            case RIGHT_DOWN:
                for (int i = 0; i < grids2.length; i++) {
                    for (int j = 0; j < grids2[i].length; j++) {
                        grids[i][j]=grids2[i][width-j-1];
                    }
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void enlarge() {
        width = width + 1;
        height = height + 1;
        grids = new char[width][height];
        fillGrids();
    }

    @Override
    public void shrink() {
        width = width - 1;
        height = height - 1;
        grids = new char[width][height];
        fillGrids();
    }

    @Override
    public int area() {
        int counter = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j]==pattern){
                    counter++;
                }

            }

        }
        return counter;
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }
}
