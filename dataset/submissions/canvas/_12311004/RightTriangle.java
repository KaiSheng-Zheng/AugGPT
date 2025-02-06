public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.d = d;
        this.width = width;
        this.height = height;
        rCalDistance();
    }

    public void rCalDistance() {
        grids = new char[height][width];
        double tan = (double) height / width;


        switch (d) {
            case RIGHT_UP -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((height - i) > tan * (width - j) || (height - i - 1) > tan * (width - j) || (height - i - 1) > tan * (width - j - 1) || (height - i) > tan * (width - j - 1)) {
                            counter++;
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
            case LEFT_UP -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((height - i) > tan * (j) || (height - i - 1) > tan * (j) || (height - i - 1) > tan * (j + 1) || (height - i) > tan * (j + 1)) {
                            counter++;
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
            case LEFT_DOWN -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((height - i) < tan * (width - j) || (height - i - 1) < tan * (width - j) || (height - i - 1) < tan * (width - j - 1) || (height - i) < tan * (width - j - 1)) {
                            counter++;
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
            case RIGHT_DOWN -> {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((height - i) < tan * (j) || (height - i - 1) < tan * (j) || (height - i - 1) < tan * (j + 1) || (height - i) < tan * (j + 1)) {
                            counter++;
                            grids[i][j] = pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
            }
        }
    }


        @Override
        public char[][] getGrids () {
            return super.getGrids();
        }

        @Override
        public void fillGrids () {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(grids[i][j]);
                }
                System.out.printf("/n");
            }

        }

        @Override
        public void enlarge () {
            counter = 0;
            width++;
            height++;
            rCalDistance();
        }

        @Override
        public void shrink () {
            counter = 0;
            width--;
            height--;
            rCalDistance();
        }

        @Override
        public int area () {
            return counter;
        }
        public String toString () {
            return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), counter, pattern);
        }
    }
