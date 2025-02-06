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

    public void fillGrids() {
        char[][] G = new char[width][height];
        switch (d) {
            case LEFT_DOWN:
                G = ifLEFT_DOWN();
                grids = G;
                break;
            case LEFT_UP:
                G = ifLEFT_UP();
                grids = G;
                break;
            case RIGHT_DOWN:
                G = ifRIGHT_DOWN();
                grids = G;
                break;
            case RIGHT_UP:
                G = ifRIGHT_UP();
                grids = G;
                break;
        }
    }

    private char[][] ifRIGHT_UP() {
        char[][] G = ifLEFT_DOWN();
        char[][] G2 = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                G2[i][j] = G[height - i - 1][width - j - 1];
            }
        }
        return G2;
    }

    private char[][] ifRIGHT_DOWN() {
        char[][] G = ifLEFT_DOWN();
        char[][] G2 = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                G2[i][j] = G[i][width-j-1];
            }
        }
        return G2;
    }

    private char[][] ifLEFT_UP() {
        char[][] G = ifLEFT_DOWN();
        char[][] G2 = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                G2[i][j] = G[height-1-i][j];
            }
        }
        return G2;
    }

    public char[][] ifLEFT_DOWN() {
        char[][] G = new char[height][width];
        int x = 0;
        int y = 0;
        double angle = 0;
        double angle0 = height / width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                G[i][j] = pattern;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                } else {
                    x = j;
                    y = i + 1;
                    angle = y / x;
                    if (y*width<=x*height) {
                        G[i][j] = ' ';
                    }
                }
            }
        }
        return G;
    }

    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }


    public void shrink() {
        width--;
        height--;
        fillGrids();
    }

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
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }


}