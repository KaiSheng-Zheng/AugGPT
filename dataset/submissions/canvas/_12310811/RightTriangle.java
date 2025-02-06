public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d ;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location != null ? location : new Location(0, 0), pattern != '\0' ? pattern : '*');
        this.width = width > 0 ? width : 5;
        this.height = height > 0 ? height : 5;
        this.d = d;
        fillGrids();
    }


    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double slope1 = height / (double)width;
                double slope2 = (i + 1)/(double) (j);
                if(slope2 > slope1){
                    if(d == Direction.LEFT_DOWN){
                        grids[i][j] = pattern;
                    }
                    if(d == Direction.LEFT_UP){
                        grids[height -1 - i][j] = pattern;
                    }
                    if(d == Direction.RIGHT_DOWN){
                        grids[i][width - 1 - j] = pattern;
                    }
                    if(d == Direction.RIGHT_UP)
                        grids[height - 1 - i][width - 1 - j] = pattern;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] != pattern) {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height += 1;
        width += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        height -= 1;
        width -= 1;
        fillGrids();
    }

    @Override
    public int area() {
        int number = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern) {
                    number += 1;
                }
            }
        }
        return number;
    }

    @Override
    public char getPattern() {
        return pattern;
    }

    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}