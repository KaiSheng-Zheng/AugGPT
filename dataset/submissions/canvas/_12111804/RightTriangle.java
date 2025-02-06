public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height =  height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[this.height][this.width];
        switch(this.d) {
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (width - (double) i * width / height > j) {
                            grids[i][j] = this.pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((double) (i + 1) * width / height > j) {
                            grids[i][j] = this.pattern;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_UP: for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((double) i * width / height < j + 1) {
                        grids[i][j] = this.pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
            break;
            case RIGHT_DOWN: for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((width) - (double) (i + 1) * width / height < j + 1) {
                        grids[i][j] = this.pattern;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
            break;
        }
    }

    @Override
    public void enlarge() {
        this.height ++;
        this.width ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width --;
        this.height --;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for(char[] line: this.grids){
            for(char c: line){
                if(c == this.pattern){
                    count ++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "RightTriangle: " + super.toString();
    }
}
