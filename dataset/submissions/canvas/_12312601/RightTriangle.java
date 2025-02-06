public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.grids = new char[height][width];
        this.d = d;
        fillGrids();
    }
    @Override
    public void fillGrids(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
    switch (d){
        case LEFT_UP:
            for (int i = 0; i <=height; i++) {
                for (int j = 0; j <=width; j++) {
                    double a = (double)height/width;
                    double b =(double)(height-i)/j;
                    if (b>a){
                        grids[i][j] = pattern;
                    }
                }
            }
            break;
        case LEFT_DOWN:
            for (int i = 0; i <= height; i++) {
                for (int j = 0;  j <=width; j++) {
                    double a = (double)height/width;
                    double b =(double)i/j;
                    if (b>a){
                        grids[i-1][j] = pattern;
                    }
                }
            }
            break;
        case RIGHT_UP:
            for (int i = 0; i < height; i++) {
                double a = (double)(width * (height - i)) / height;
                int b = (int)Math.floor(width - a);
                for (int j = width-1; j >= b; j--) {
                    grids[i][j] = pattern;
                }
            }
            break;
        case RIGHT_DOWN:
            for (int i = 0; i < height; i++) {
                double a = (double)(width * (i + 1)) / height;
                int b = (int)Math.floor(width - a);
                for (int j = width-1; j >= b; j--) {
                    grids[i][j] = pattern;
                }
            }
            break;
        }
    }
    @Override
    public void enlarge() {
        width++;
        height++;
        grids = new char[height][width];
        fillGrids();
    }
    @Override
    public void shrink() {
        if (width > 1 && height > 1) {
        width--;
        height--;
        grids = new char[height][width];
        fillGrids();
        }
    }
    @Override
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

}
