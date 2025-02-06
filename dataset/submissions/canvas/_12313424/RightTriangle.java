import java.util.GregorianCalendar;

public class RightTriangle extends Shape {
    private int width;

    private int height;

    private final Direction d;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);

        this.width=width;
        this.height=height;
        this.d=d;

        this.fillGrids();


    }


    @Override
    public void fillGrids() {
        super.grids=new char[height][width];
        if (d==Direction.LEFT_UP) {

            for (int i=0;i<height;i++){
                grids[i][0]=pattern;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 1; j < width; j++) {
                     if (height*j<(height-i)*width){
                         grids[i][j]=pattern;
                     }else {
                         grids[i][j]=' ';
                     }
                }
            }
        }
        if (d==Direction.LEFT_DOWN) {

            for (int i=0;i<height;i++){
                grids[i][0]=pattern;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    if (height*j<(i+1)*width){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }
        }
        if (d==Direction.RIGHT_UP) {

            for (int i=0;i<height;i++){
                grids[i][width-1]=pattern;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width-1; j++) {
                    if (height*(j+1)>i*width){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }
        }
        if (d==Direction.RIGHT_DOWN) {

            for (int i=0;i<height;i++){
                grids[i][width-1]=pattern;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width-1; j++) {
                    if (height*(j+1)>(height-i-1)*width){
                        grids[i][j]=pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
            }
        }



    }


    @Override
    public void enlarge() {
         this.height+=1;
         this.width+=1;
        grids=new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        this.height-=1;
        this.width-=1;
        grids=new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        fillGrids();
        int a=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]==pattern){
                    a+=1;
                }

            }
        }

        return a;
    }


    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s",location.getX(),location.getY(),area(),pattern);
    }


}
