public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d){
        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char[][] grids = new char[height][width];
        double k = (double) height/width;
        switch (d){
            case LEFT_DOWN:
                for (int i = 0; i < width; i++) {
                    double h = Math.ceil((width-i)*k);
                    for (int j = 0; j < h; j++) {
                        grids[height-j-1][i] = pattern;
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < width; i++) {
                    double h = Math.ceil((i+1)*k);
                    for (int j = 0; j < h; j++) {
                        grids[height-j-1][i] = pattern;
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 0; i < width; i++) {
                    double h = Math.ceil((width-i)*k);
                    for (int j = 0; j < h; j++) {
                        grids[j][i] = pattern;
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < width; i++) {
                    double h = Math.ceil((i+1)*k);
                    for (int j = 0; j < h; j++) {
                        grids[j][i] = pattern;
                    }
                }
                break;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j] != pattern){
                    grids[i][j] = ' ';
                }
            }
        }
        this.grids = grids;
    }

    @Override
    public void enlarge() {
        width ++;
        height ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        width --;
        height --;
        fillGrids();
    }

    @Override
    public int area() {
        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j] == pattern){
                    sum++;
                }
            }
        }
        return sum;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(),location.getY(),area(),pattern);
    }
}
