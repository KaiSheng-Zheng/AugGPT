
public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;
    private int area;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    public void fillGrids() {
        area = 0;
        this.grids = new char[height][width];
        double slopeofdiagnal = (double) width / (double) height;
        if(d==Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((double) j / (double) (i + 1) < slopeofdiagnal) {
                        grids[i][j] = pattern;
                        area++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d==Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i==0||(double) (j+1) / (double) i > slopeofdiagnal) {
                        grids[i][j] = pattern;
                        area++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        } else if (d==Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j==0||(double)(height-i)/(double) j>(double) height/(double) width ){
                        grids[i][j] = pattern;
                        area++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }else {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j==width-1||(double) (i+1)/(double) (width-j-1)>(double) height/(double) width ){
                        grids[i][j] = pattern;
                        area++;
                    } else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }

    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    public void shrink() {
        height--;
        width--;
        fillGrids();
    }

    public int area() {
        return area;
    }

    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),this.area(),pattern);
    }

    @Override
    public char pattern() {
        return pattern;
    }
}
