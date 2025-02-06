import java.util.ArrayList;
import java.util.List;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
       this.locations = new ArrayList<Location>();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for (int i =0 ; i < height; i++) {
            for (int j = 0; j < width ; j++) {
                grids[i][j] = ' ';
            }
        }



            double slope1 = (double) width / (double) height;

            for (int i = 1; i < height+1; i++) {
                for (int j = 0; j < width; j++) {

                    double slope = (double)( j) / (double) (i);
if (slope <  slope1) {
    if(d==Direction.LEFT_DOWN) {grids[i-1][j]=pattern;
         }
if(d==Direction.LEFT_UP) {grids[height-1-i+1][j]=pattern;
 }
if(d==Direction.RIGHT_DOWN) {grids[i-1][width-1-j]=pattern;}
if(d==Direction.RIGHT_UP) {grids[height-1-i+1][width-1-j]=pattern;}
}


                    }
                }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width ; j++) {
                if (grids[i][j] == pattern) {
                    this.locations.add(new Location(i+this.getX(), j+this.getY()));}
            }
        }

        }
@Override
    public void enlarge(){
        this.width++;
        this.height++;
    fillGrids();
}
@Override
    public void shrink(){
        this.width--;
        this.height--;
    fillGrids();
}
@Override
    public int area(){
    fillGrids();
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

