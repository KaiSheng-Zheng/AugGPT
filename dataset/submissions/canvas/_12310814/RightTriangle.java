public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    private int pattern_count;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];//initialize the grids in the constructor
        fillGrids();
    }

    @Override
    public void fillGrids() {
        //LEFT_DOWN
        if(d.equals(Direction.LEFT_DOWN)){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (inTest_LEFTDOWN(i, j, height, width)){
                        grids[i][j] = pattern;
                        pattern_count ++;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }
            }
        }
        //LEFT_UP
        else if(d.equals(Direction.LEFT_UP)){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (inTest_LEFTUP(i, j, height, width)){
                        grids[i][j] = pattern;
                        pattern_count ++;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }
            }
        }
        //RIGHT_DOWN
        else if(d.equals(Direction.RIGHT_DOWN)){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (inTest_RIGHTDOWN(i, j, height, width)){
                        grids[i][j] = pattern;
                        pattern_count ++;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }
            }
        }
        //RIGHT_UP
        else if(d.equals(Direction.RIGHT_UP)){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (inTest_RIGHTUP(i, j, height, width)){
                        grids[i][j] = pattern;
                        pattern_count ++;
                    }
                    else{
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    //Whether the point should be in the RightTriangle
    private boolean inTest_LEFTDOWN(int x1, int x2, int h, int w){
        double tan = (double) (h - 1 - x1) /(w - x2);//LEFT_DOWN coordinate
        return tan < (double) h/w;
    }

    private boolean inTest_LEFTUP(int x1, int x2, int h, int w){
        double tan = (double) x1 /(w - x2);//LEFT_UP coordinate
        return tan < (double) h/w;
    }

    private boolean inTest_RIGHTDOWN(int x1, int x2, int h, int w){
        double tan = (double) (h - 1 - x1) /(x2 + 1);//LEFT_UP coordinate
        return tan < (double) h/w;
    }

    private boolean inTest_RIGHTUP(int x1, int x2, int h, int w){
        double tan = (double) x1/(x2 + 1);//LEFT_UP coordinate
        return tan < (double) h/w;
    }


    @Override
    public void enlarge() {
        pattern_count = 0;
        height ++;
        width ++;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        pattern_count = 0;
        height --;
        width --;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        return pattern_count;
    }

    @Override
    public String toString() {
        return "RightTriangle: (" + location.getX() + "," + location.getY() + ") area="
                + area() + " pattern=" + pattern;
    }
}
