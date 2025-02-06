public class RightTriangle extends Shape {

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    public int area() {
        int j = 0;
        char[][] b = this.getGrids();
        for (int i = 0; i < b.length; i++) {
            for (int k = 0; k < b[i].length; k++) {
                if (b[i][k] == pattern) {
                    j++;
                }
            }
        }
        return j;
    }

    public char[][] getGrids() {
        return grids;
    }


    public void fillGrids() {
        double slope = (double) height / width;
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
                grids[i][0] = pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j < width; j++) {
                    if (i / (double)j > slope) {
                        grids[i - 1][j] = pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]!=pattern){
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                grids[i][0] = pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j < width; j++) {
                    if (i / (double)j > slope) {
                        grids[height-i][j] = pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]!=pattern){
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                grids[i][width-1] = pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i /(double) (width-j) > slope) {
                        grids[height-i][j-1] = pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]!=pattern){
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                grids[i][width-1] = pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i /(double) (width-j) > slope) {
                        grids[i-1][j-1] = pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]!=pattern){
                        grids[i][j] = ' ';
                    }
                }
            }
        }

    }


    public void enlarge() {
        width++;
        height++;
        this.grids = new char[height][width];
        fillGrids();
    }

    public void shrink() {
        width--;
        height--;
        this.grids = new char[height][width];
        fillGrids();
    }
    public String toString() {
        return "RightTriangle: "+ location.toString() + " "+"area="+area()+" "+ "pattern="+pattern;
    }
}
