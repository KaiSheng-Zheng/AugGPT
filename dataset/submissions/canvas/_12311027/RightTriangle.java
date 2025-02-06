public class RightTriangle extends Shape{

    int width;
    int height;
    Direction d;
    char [][] copy= new char[30][30];
    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    int area=0;

    @Override
    public void fillGrids() {
        int area2=0;
        switch (d){
            case RIGHT_UP -> {
                grids=new char[height][width];
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (i*width<(j+1)*height){
                            copy[i][j]=pattern;
                            area2++;
                        }
                        else {
                            copy[i][j]=' ';
                        }
                    }
                }
                for (int i = 0; i < height; i++) {
                    System.arraycopy(copy[i], 0, grids[i], 0, width);
                    }
            }
            case RIGHT_DOWN -> {
                grids=new char[height][width];
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {

                        if (i*width<(j+1)*height){
                            copy[height-1-i][j]=pattern;
                            area2++;
                        }
                        else {
                            copy[height-1-i][j]=' ';
                        }
                    }
                }
                for (int i = 0; i < height; i++) {
                    System.arraycopy(copy[i], 0, grids[i], 0, width);
                }
            }

            case LEFT_UP ->  {
                grids=new char[height][width];
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {

                        if (i*width<(j+1)*height){
                            copy[i][width-1-j]=pattern;
                            area2++;
                        }
                        else {
                            copy[i][width-1-j]=' ';
                        }
                    }
                }
                for (int i = 0; i < height; i++) {
                    System.arraycopy(copy[i], 0, grids[i], 0, width);
                }
            }

            case LEFT_DOWN -> {
                grids=new char[height][width];
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (i*width<(j+1)*height){
                            copy[height-1-i][width-j-1]=pattern;
                            area2++;
                        }
                        else {
                            copy[height-1-i][width-j-1]=' ';
                        }
                    }
                }
                for (int i = 0; i < height; i++) {
                    System.arraycopy(copy[i], 0, grids[i], 0, width);
                }
                }
            }
            area=area2;
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
        return area;
    }
    public String toString(){
        return getClass().getName()+": "+location.toString()+" area="+ area + " pattern="+pattern;
    }
}
