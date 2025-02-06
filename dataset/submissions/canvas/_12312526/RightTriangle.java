public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids(){

        grids = new char[height][width];
        double Slop = (double)height / (double)width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (d == Direction.RIGHT_UP){
                    if (calculateSlop((double)height - (i +1)  , (double)width-j) < Slop){
                        grids[height -i-1][width -1-j] = pattern;
                    }
                    else {
                        grids[height -i-1][width -1-j] = ' ';
                    }
                }

                else if (d == Direction.LEFT_DOWN){
                    if (calculateSlop((double)height - (i +1)  , (double)width-j)  < Slop){
                        grids[i][j] = pattern;
                    }
                    else {
                        grids[i][j] = ' ';
                    }
                }

                else if (d == Direction.RIGHT_DOWN){
                    if (calculateSlop((double)height - (i +1)  , (double)width-j) < Slop){
                        grids[i][width -1 - j] = pattern;
                    }
                    else {
                        grids[i][width -1 - j] = ' ';
                    }
                }
                else if (d == Direction.LEFT_UP){
                    if (calculateSlop((double)height - (i +1)  , (double)width-j) < Slop){
                        grids[height -i-1][j] = pattern;
                    }
                    else {
                        grids[height -i-1][j] = ' ';
                    }
                }
            }
        }
    }

    public void enlarge(){
        width++;
        height++;
        fillGrids();
    }

    public void shrink(){
        width--;
        height--;
        fillGrids();
    }

    public int area(){
        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern){
                    count++;
                }

            }
        }

        return count;
    }
    public double calculateSlop(double heightCoordinate, double widthCoordinate){
        return heightCoordinate / widthCoordinate;
    }

    @Override
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(),pattern);
    }
}
