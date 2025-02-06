import java.util.Comparator;

public class RightTriangle extends Shape   {
    private int width;
    private int height;
    private Direction d ;

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d){
       super(location,pattern);
       this.width = width;
       this.height = height;
       this.d = d;
       fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double slope = (double) height /width;
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < width; j++) {
                switch (d){
                    case LEFT_DOWN :
                        if((i+1) > (double)j*slope){
                            grids[i][j] = pattern;
                        }
                        break;
                    case LEFT_UP:
                        if((height-i) > (double)j*slope){
                            grids[i][j] = pattern;
                        }
                        break;
                    case RIGHT_DOWN:
                        if((height-i-1) < (double)(j+1)*slope){
                            grids[i][j] = pattern;
                        }
                        break;
                    case RIGHT_UP:
                        if(i < (double)(j+1)*slope){
                            grids[i][j] = pattern;
                        }
                        break;
                }
                if(grids[i][j] != pattern){
                    grids[i][j] = ' ';
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
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j] == pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),this.area(),pattern);
    }

}
