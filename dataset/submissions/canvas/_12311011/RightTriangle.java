public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    private int count = 0;
    private double tan;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        tan = (double)width/height;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        switch (d){
            case RIGHT_UP:
                for (int i = 1; i <= height ; i++) {
                    double x = tan*i;
                    for (int j = 0; j < width; j++) {
                        if (j<x){
                        grids[height-i][width-j-1] = pattern;
                        count++;}
                        else{
                            grids[height-i][width-j-1] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 1; i <= height ; i++) {
                    double x = tan*i;
                    for (int j = 0; j < width; j++) {
                        if (j<x){
                        grids[i-1][width-j-1] = pattern;
                        count++;}
                        else{
                            grids[i-1][width-j-1] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 1; i <= height ; i++) {
                    double x = tan*i;
                    for (int j = 0; j < width; j++) {
                        if (x-j>0) {
                        grids[height-i][j] = pattern;
                        count++;}
                        else{
                            grids[height-i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 1; i <= height; i++) {
                    double x = tan*i;
                    for (int j = 0; j < width; j++) {
                        if (x-j>0) {
                        grids[i-1][j] = pattern;
                        count++;
                        }
                        else{
                            grids[i-1][j] = ' ';
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void enlarge() {
        count=0;
        width++;height++;
        tan = (double)width/height;
        fillGrids();
    }

    @Override
    public void shrink() {
        count=0;
        width--;height--;
        tan = (double)width/height;
        fillGrids();
    }

    @Override
    public int area() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%s", getLocation(), area(), getPattern());
    }

}