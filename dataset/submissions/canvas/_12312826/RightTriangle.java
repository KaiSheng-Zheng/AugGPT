import java.util.GregorianCalendar;
import java.util.WeakHashMap;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();

    }

    public void fillGrids() {
        this.grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
        if (d == Direction.LEFT_DOWN) {
            double Tan = ((double) height) / ((double) width);
            for (int i = 0; i < height; i++) {
                grids[i][0]=pattern;
            }
            for (int i = 0; i <width ; i++) {
                grids[height-1][i]=pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    double tan = ((double) i) / ((double) j);
                    if(tan>Tan) {
                        grids[i - 1][j] = pattern;
                    }
                }
            }
        }
        if(d==Direction.LEFT_UP ){
            double Tan = ((double) height) / ((double) width);
            for (int i = 0; i < height; i++) {
                grids[i][0]=pattern;
            }
            for (int i = 0; i < width; i++) {
                grids[0][i]=pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    double tan = ((double) (height-i)) /((double) j);
                    if(tan>Tan) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
        if(d==Direction.RIGHT_DOWN ){
            double Tan = ((double) height) / ((double) width);
            for (int i = 0; i < height; i++) {
                grids[i][width-1]=pattern;
            }
            for (int i = 0; i < width; i++) {
                grids[height-1][i]=pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    double tan = ((double)i) /((double) (width-j));
                    if(tan>Tan) {
                        grids[i - 1][j-1] = pattern;
                    }
                }
            }
        }
        if(d==Direction.RIGHT_UP ){
            double Tan = ((double) height) / ((double) width);
            for (int i = 0; i < width; i++) {
                grids[0][i]=pattern;
            }
            for (int i = 0; i < height; i++) {
                grids[i][width-1]=pattern;
            }
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j < width; j++) {
                    double tan = ((double) height-i) /((double) width- j);
                    if(tan>Tan) {
                        grids[i][j-1] = pattern;
                    }
                }
            }
        }
    }
    public int area(){
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }

    public char[][] getGrids() {
        return this.grids;
    }

    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    public void shrink() {
        width--;
        height--;
        fillGrids();
    }
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%c", location, area(), pattern);
    }
}
