public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width= width;
        this.height=height;
        this.d = d;
        fillGrids();
    }

    public char[][] setGrids(){
        this.grids= new char[height][width];
        return grids;
    }
    public String toString(){
        return "RightTriangle: "+"("+location.getX()+","+location.getY()+") "+"area=" +area() +" pattern="+pattern;
    }
    @Override
    public void fillGrids() {
        setGrids();
        char space = ' ';
        double test = (double)height/width;
        if (d == Direction.LEFT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0) {
                        grids[i][j] = pattern;
                    } else {
                        double n = (double) (i + 1) / j;
                        if (n > test) {
                            grids[i][j] = pattern;
                        }
                        if (n <= test) {
                            grids[i][j] = space;
                        }
                    }
                }
            }
        }
        else{
            if (d==Direction.LEFT_UP){
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (j == 0) {
                            grids[i][j] = pattern;
                        } else {
                            double n = (double) (i + 1) / j;
                            if (n > test) {
                                grids[height-i-1][j] = pattern;
                            }
                            if (n <= test) {
                                grids[height-i-1][j] = space;
                            }
                        }
                    }
                }
            }
            if (d==Direction.RIGHT_DOWN){
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (j == 0) {
                            grids[i][width-1] = pattern;
                        } else {
                            double n = (double) (i + 1) / j;
                            if (n > test) {
                                grids[i][width-j-1] = pattern;
                            }
                            if (n <= test) {
                                grids[i][width-j-1] = space;
                            }
                        }
                    }
                }
            }
            if (d==Direction.RIGHT_UP){
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (j == 0) {
                            grids[i][width-1] = pattern;
                        } else {
                            double n = (double) (i + 1) / j;
                            if (n > test) {
                                grids[height-i-1][width-j-1] = pattern;
                            }
                            if (n <= test) {
                                grids[height-i-1][width-j-1] = space;
                            }
                        }
                    }
                }
            }
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
        int n = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern){
                    n++;
                }
            }
        }
        return n;
    }
}
